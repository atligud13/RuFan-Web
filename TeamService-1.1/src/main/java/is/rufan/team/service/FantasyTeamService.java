package is.rufan.team.service;

import is.rufan.team.domain.FantasyTeam;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/23/2015.
 */
public interface FantasyTeamService
{
    void addFantasyTeam(FantasyTeam fantasyTeam);
    void updateFantasyTeam(FantasyTeam fantasyTeam);
    FantasyTeam getFantasyTeam(int id);
    List<FantasyTeam> getFantasyTeamsForUser(int userId);
    List<FantasyTeam> getFantasyTeamsForTournament(int tournamentId);
    List<FantasyTeam> getAllFantasyTeams();
}
