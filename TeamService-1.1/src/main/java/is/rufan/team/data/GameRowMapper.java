package is.rufan.team.data;

import is.rufan.team.domain.Game;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */

public class GameRowMapper implements RowMapper<Game> {
    public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
        RuDataAccessFactory factory;
        TeamDataGateway teamDataGateway;
        VenueDataGateway venueDataGateway;
        Game game = new Game();

        try
        {
            factory = RuDataAccessFactory.getInstance("teamdata.xml");
            teamDataGateway = (TeamDataGateway) factory.getDataAccess("teamData");
            venueDataGateway = (VenueDataGateway) factory.getDataAccess("venueData");
            game.setGameId(rs.getInt("gameid"));
            game.setTeamHome(teamDataGateway.getTeam(rs.getInt("hometeamid")));
            game.setTeamAway(teamDataGateway.getTeam(rs.getInt("awayteamid")));
            game.setVenue(venueDataGateway.getVenue(rs.getInt("venueid")));
            game.setStartTime(rs.getTime("startdate"));
        }
        catch(RuException e)
        {
            System.out.println("Error creating factory");
        }

        return game;
    }
}
