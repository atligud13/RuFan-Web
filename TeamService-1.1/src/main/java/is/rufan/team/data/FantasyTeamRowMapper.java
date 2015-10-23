package is.rufan.team.data;

import is.rufan.player.data.PlayerData;
import is.rufan.player.data.PlayerDataGateway;
import is.rufan.team.domain.FantasyTeam;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Atli Guðlaugsson on 10/23/2015.
 */
public class FantasyTeamRowMapper implements RowMapper<FantasyTeam> {
    public FantasyTeam mapRow(ResultSet rs, int i) throws SQLException {
        RuDataAccessFactory factory;
        PlayerDataGateway playerDataGateway;
        FantasyTeam fantasyTeam;

        try
        {
            factory = RuDataAccessFactory.getInstance("teamdata.xml");
            playerDataGateway = (PlayerDataGateway) factory.getDataAccess("playerData");
            fantasyTeam = new FantasyTeam(rs.getInt("userid"));
            fantasyTeam.setId(rs.getInt("id"));
            if(rs.getInt("gkid") > 0) fantasyTeam.setgK(playerDataGateway.getPlayer(rs.getInt("gkid")));
            if(rs.getInt("d1id") > 0) fantasyTeam.setD1(playerDataGateway.getPlayer(rs.getInt("d1id")));
            if(rs.getInt("d2id") > 0) fantasyTeam.setD2(playerDataGateway.getPlayer(rs.getInt("d2id")));
            if(rs.getInt("d3id") > 0) fantasyTeam.setD3(playerDataGateway.getPlayer(rs.getInt("d3id")));
            if(rs.getInt("d4id") > 0) fantasyTeam.setD4(playerDataGateway.getPlayer(rs.getInt("d4id")));
            if(rs.getInt("m1id") > 0) fantasyTeam.setM1(playerDataGateway.getPlayer(rs.getInt("m1id")));
            if(rs.getInt("m2id") > 0) fantasyTeam.setM2(playerDataGateway.getPlayer(rs.getInt("m2id")));
            if(rs.getInt("m3id") > 0) fantasyTeam.setM3(playerDataGateway.getPlayer(rs.getInt("m3id")));
            if(rs.getInt("m4id") > 0) fantasyTeam.setM4(playerDataGateway.getPlayer(rs.getInt("m4id")));
            if(rs.getInt("f1id") > 0) fantasyTeam.setF1(playerDataGateway.getPlayer(rs.getInt("f1id")));
            if(rs.getInt("f2id") > 0) fantasyTeam.setF2(playerDataGateway.getPlayer(rs.getInt("f2id")));
            return fantasyTeam;
        }
        catch(RuException e)
        {
            System.out.println("Error creating factory");
        }
        return null;
    }
}
