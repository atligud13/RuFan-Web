package controllers;



import is.rufan.player.domain.Player;
import is.rufan.team.domain.FantasyTeam;
import is.rufan.team.service.FantasyTeamService;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentService;
import is.rufan.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.mvc.*;
import is.rufan.user.service.UserService;

import views.html.editfanteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static play.data.Form.*;

public class FantasyTeamController extends Controller
{
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
    protected UserService userService = (UserService) ctx.getBean("userService");
    protected TournamentService tournamentService = (TournamentService) ctx.getBean("tournamentService");
    protected FantasyTeamService fanTeamService = (FantasyTeamService) ctx.getBean("fantasyTeamService");
    static Form<FantasyTeam> teamForm = form(FantasyTeam.class);
    Tournament tournament;

    public Result get(int tournamentId) {
        String username = session("username");
        User currentUser = userService.getUserByUsername(username);
        tournament = (Tournament) tournamentService.getTournament(tournamentId);
        List<FantasyTeam> userTeams = fanTeamService.getFantasyTeamsForUser(currentUser.getId());
        FantasyTeam currentTeam = new FantasyTeam(currentUser.getId());

        /* Going through all of the users team to see if he already
         * has a team competing in this tournament */
        for(FantasyTeam t : userTeams) {
            if(t.getTournament().getTournamentId() == tournamentId) {
                currentTeam = t;
            }
        }

        Form<FantasyTeam> newForm = teamForm.fill(currentTeam);

        return ok(editfanteam.render(tournament, currentTeam, newForm));
    }

    public Result post() {
        return ok();
    }

    public Result update() {
        Form<FantasyTeam> filledForm = teamForm.bindFromRequest();
        FantasyTeam newTeam = filledForm.get();

        return ok(editfanteam.render(tournament, newTeam, filledForm));
    }
}
