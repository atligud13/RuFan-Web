package is.rufan.team.data;

import is.rufan.team.domain.FantasyTeam;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.List;

/**
 * Created by Atli Gušlaugsson on 10/23/2015.
 */
public interface FantasyTeamDataGateway
{
    void addFantasyTeam(FantasyTeam fantasyTeam);
    void updateFantasyTeam(FantasyTeam fantasyTeam);
    FantasyTeam getFantasyTeam(int id);
    List<FantasyTeam> getFantasyTeamsForUser(int userId);
    List<FantasyTeam> getFantasyTeamsForTournament(int tournamentId);
    List<FantasyTeam> getAllFantasyTeams();
}
