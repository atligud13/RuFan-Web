package is.rufan.team.service;

import is.rufan.player.domain.Country;
import is.rufan.player.domain.Player;
import is.rufan.player.domain.Position;
import is.rufan.player.service.PlayerService;
import is.rufan.player.service.PlayerServiceData;
import is.rufan.team.data.FantasyTeamDataGateway;
import is.rufan.team.domain.FantasyTeam;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;
import javassist.tools.rmi.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/23/2015.
 */
public class FantasyTeamServiceData implements FantasyTeamService {
    RuDataAccessFactory factory;
    FantasyTeamDataGateway fantasyTeamDataGateway;

    public FantasyTeamServiceData() throws RuException
    {
        factory = RuDataAccessFactory.getInstance("teamdata.xml");
        fantasyTeamDataGateway = (FantasyTeamDataGateway) factory.getDataAccess("fantasyTeamData");
    }

    public static void main(String[] args)
    {
        try
        {
            FantasyTeamService fantasyTeamService = new FantasyTeamServiceData();

            FantasyTeam f = new FantasyTeam(2);
            fantasyTeamService.addFantasyTeam(f);

            FantasyTeam fantasyTeam = new FantasyTeam(1);
            fantasyTeam.setId(2);
            fantasyTeam.setgK(new Player(346029, "Michael", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setD1(new Player(322494, "Atli", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setD2(new Player(330263, "Arnar", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setD3(new Player(330383, "Christan", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setD4(new Player(330396, "Henderson", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setM1(new Player(331252, "Guy", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setM2(new Player(345024, "Hitler", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setM3(new Player(345025, "Putin", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setM4(new Player(345033, "Bush", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setF1(new Player(345145, "Trump", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            fantasyTeam.setF2(new Player(345157, "Sanders", "Owen", 170, 80, new Date(), new Country(1, "England", "ENG"), 10, new Position(1, "Forward", "F", 0)));
            try
            {
                fantasyTeamService.updateFantasyTeam(fantasyTeam);
                System.out.println("All fantasy teams: " + fantasyTeamService.getAllFantasyTeams().size());
                System.out.println("All fantasy teams for Atli: " + fantasyTeamService.getFantasyTeamsForUser(2).size());
            }
            catch (ObjectNotFoundException e)
            {
                System.out.println("Object not found exception thrown when updating fantasy teams");
            }

        }
        catch(RuException e)
        {
            System.out.println("Something went wrong when testing fantasy team service");
        }
    }

    public void addFantasyTeam(FantasyTeam fantasyTeam) {
        fantasyTeamDataGateway.addFantasyTeam(fantasyTeam);
    }

    public void updateFantasyTeam(FantasyTeam fantasyTeam) throws ObjectNotFoundException {
        try
        {
            fantasyTeamDataGateway.updateFantasyTeam(fantasyTeam);
        }
        catch(ObjectNotFoundException e)
        {
            throw e;
        }
    }

    public FantasyTeam getFantasyTeam(int id) {
        return fantasyTeamDataGateway.getFantasyTeam(id);
    }

    public List<FantasyTeam> getFantasyTeamsForUser(int userId) {
        return fantasyTeamDataGateway.getFantasyTeamsForUser(userId);
    }

    public List<FantasyTeam> getAllFantasyTeams() {
        return fantasyTeamDataGateway.getAllFantasyTeams();
    }
}
