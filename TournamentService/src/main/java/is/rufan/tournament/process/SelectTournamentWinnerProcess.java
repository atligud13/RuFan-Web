package is.rufan.tournament.process;

import is.rufan.player.domain.Point;
import is.rufan.player.process.PointImportProcess;
import is.rufan.player.service.PointService;
import is.rufan.team.domain.FantasyTeam;
import is.rufan.team.service.FantasyTeamService;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentService;
import is.ruframework.process.RuAbstractProcess;
import is.ruframework.reader.RuReadHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/26/2015.
 * ATTENTION: This process assumes that the point import process
 * has already been run. It is located in the player service.
 */
public class SelectTournamentWinnerProcess extends RuAbstractProcess implements RuReadHandler {
    private TournamentService tournamentService;
    private FantasyTeamService fantasyTeamService;
    private PointService pointService;

    @Override
    public void beforeProcess() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:tournamentapp.xml");
        tournamentService = (TournamentService) applicationContext.getBean("tournamentService");
        fantasyTeamService = (FantasyTeamService) applicationContext.getBean("fantasyTeamService");
        pointService = (PointService) applicationContext.getBean("pointService");
    }

    @Override
    public void startProcess() {

        List<Tournament> tournaments = tournamentService.getTournaments();

        /* For each tournament we get the teams */
        for(Tournament tournament : tournaments) {
            List<FantasyTeam> fantasyTeams = fantasyTeamService.getFantasyTeamsForTournament(tournament.getTournamentId());

            /* We calculate the score of each player and add it to the tournament results table */
            for(FantasyTeam team : fantasyTeams) {
                int teamScore = calculateTeamScore(team);
                tournamentService.addTournamentResult(team.getId(), teamScore);
            }

            /* Finally we set the winner to selected */
            tournamentService.setWinnerSelected(tournament.getTournamentId());
        }

    }

    public int calculateTeamScore(FantasyTeam team) {
        int score = 0;
        score += calculatePlayerScore(team.getgK().getPlayerId());
        score += calculatePlayerScore(team.getD1().getPlayerId());
        score += calculatePlayerScore(team.getD2().getPlayerId());
        score += calculatePlayerScore(team.getD3().getPlayerId());
        score += calculatePlayerScore(team.getD4().getPlayerId());
        score += calculatePlayerScore(team.getM1().getPlayerId());
        score += calculatePlayerScore(team.getM2().getPlayerId());
        score += calculatePlayerScore(team.getM3().getPlayerId());
        score += calculatePlayerScore(team.getM4().getPlayerId());
        score += calculatePlayerScore(team.getF1().getPlayerId());
        score += calculatePlayerScore(team.getF2().getPlayerId());

        return score;
    }

    public int calculatePlayerScore(int playerId) {
        int score = 0;
        List<Point> points =  pointService.getPointsByPlayerId(playerId);

        for(Point p : points) {
            score += p.getScore();
        }
        return score;
    }

    public void read(int i, Object o) {

    }
}
