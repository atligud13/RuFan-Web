package is.rufan.team.data;

import is.rufan.player.data.PlayerDataGateway;
import is.rufan.team.domain.FantasyTeam;
import is.ruframework.data.RuData;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Atli Guðlaugsson on 10/23/2015.
 */
public class FantasyTeamData extends RuData implements FantasyTeamDataGateway {
    public void addFantasyTeam(FantasyTeam fantasyTeam)
    {
        SimpleJdbcInsert insertTeam =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("fantasyteams")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> fTeamParameters = new HashMap<String, Object>(12);
        fTeamParameters.put("userid", fantasyTeam.getUserId());
        fTeamParameters.put("gkid", fantasyTeam.getgK().getPlayerId());
        fTeamParameters.put("d1id", fantasyTeam.getD1().getPlayerId());
        fTeamParameters.put("d2id", fantasyTeam.getD2().getPlayerId());
        fTeamParameters.put("d3id", fantasyTeam.getD3().getPlayerId());
        fTeamParameters.put("d4id", fantasyTeam.getD4().getPlayerId());
        fTeamParameters.put("m1id", fantasyTeam.getM1().getPlayerId());
        fTeamParameters.put("m2id", fantasyTeam.getM2().getPlayerId());
        fTeamParameters.put("m3id", fantasyTeam.getM3().getPlayerId());
        fTeamParameters.put("m4id", fantasyTeam.getM4().getPlayerId());
        fTeamParameters.put("f1id", fantasyTeam.getF1().getPlayerId());
        fTeamParameters.put("f2id", fantasyTeam.getF2().getPlayerId());

        try
        {
            insertTeam.execute(fTeamParameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Something went wrong when creating fantasy team");
            log.warning(divex.toString());
        }
    }

    public void updateFantasyTeam(FantasyTeam fantasyTeam) throws ObjectNotFoundException
    {
        String sql = "update fantasyteams SET gkid = ?, d1id = ?, d2id = ?, d3id = ?, " +
                "d4id = ?, m1id = ?, m2id = ?, m3id = ?, m4id = ?, f1id = ?, f2id = ?  where id = ?";

        try
        {
            PreparedStatement preparedStatement = getDataSource().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, fantasyTeam.getgK().getPlayerId());
            preparedStatement.setInt(2, fantasyTeam.getD1().getPlayerId());
            preparedStatement.setInt(3, fantasyTeam.getD2().getPlayerId());
            preparedStatement.setInt(4, fantasyTeam.getD3().getPlayerId());
            preparedStatement.setInt(5, fantasyTeam.getD4().getPlayerId());
            preparedStatement.setInt(6, fantasyTeam.getM1().getPlayerId());
            preparedStatement.setInt(7, fantasyTeam.getM2().getPlayerId());
            preparedStatement.setInt(8, fantasyTeam.getM3().getPlayerId());
            preparedStatement.setInt(9, fantasyTeam.getM4().getPlayerId());
            preparedStatement.setInt(10, fantasyTeam.getF1().getPlayerId());
            preparedStatement.setInt(11, fantasyTeam.getF2().getPlayerId());
            preparedStatement.setInt(12, fantasyTeam.getId());

            // execute update SQL statement
            preparedStatement.executeUpdate();

            System.out.println("Record is updated to fantasy teams table!");
        }
        catch(SQLException e)
        {
            log.warning("Could not update fantasy team");
            throw new ObjectNotFoundException("FANTASY_TEAM_NOT_FOUND");
        }
    }

    public FantasyTeam getFantasyTeam(int id)
    {
        String sql = "select * from fantasyteams where id = ?";
        JdbcTemplate queryFantasyTeam= new JdbcTemplate(getDataSource());
        FantasyTeam fantasyTeam = queryFantasyTeam.queryForObject(sql, new Object[] { id },
                new FantasyTeamRowMapper());
        return fantasyTeam;
    }

    public List<FantasyTeam> getFantasyTeamsForUser(int userId)
    {
        String sql = "select * from fantasyteams where userid = ?";
        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());
        ArrayList<FantasyTeam> fantasyTeams = new ArrayList<FantasyTeam>();
        RuDataAccessFactory factory;
        PlayerDataGateway playerDataGateway;

        List<Map<String, Object>> rows = queryPosition.queryForList(sql, new Object[] { userId });

        try
        {
            factory = RuDataAccessFactory.getInstance("teamdata.xml");
            playerDataGateway = (PlayerDataGateway) factory.getDataAccess("playerData");
            for(Map r : rows)
            {
                FantasyTeam fantasyTeam = new FantasyTeam((Integer) (r.get("userid")));
                fantasyTeam.setId((Integer) (r.get("id")));
                /* Here's where the fun part starts */
                if((Integer)(r.get("gkid")) > 0) fantasyTeam.setgK(playerDataGateway.getPlayer((Integer)(r.get("gkid"))));
                if((Integer)(r.get("d1id")) > 0) fantasyTeam.setD1(playerDataGateway.getPlayer((Integer) (r.get("d1id"))));
                if((Integer)(r.get("d2id")) > 0) fantasyTeam.setD2(playerDataGateway.getPlayer((Integer) (r.get("d2id"))));
                if((Integer)(r.get("d3id")) > 0) fantasyTeam.setD3(playerDataGateway.getPlayer((Integer) (r.get("d3id"))));
                if((Integer)(r.get("d4id")) > 0) fantasyTeam.setD4(playerDataGateway.getPlayer((Integer) (r.get("d4id"))));
                if((Integer)(r.get("m1id")) > 0) fantasyTeam.setM1(playerDataGateway.getPlayer((Integer) (r.get("m1id"))));
                if((Integer)(r.get("m2id")) > 0) fantasyTeam.setM2(playerDataGateway.getPlayer((Integer) (r.get("m2id"))));
                if((Integer)(r.get("m3id")) > 0) fantasyTeam.setM3(playerDataGateway.getPlayer((Integer) (r.get("m3id"))));
                if((Integer)(r.get("m4id")) > 0) fantasyTeam.setM4(playerDataGateway.getPlayer((Integer) (r.get("m4id"))));
                if((Integer)(r.get("f1id")) > 0) fantasyTeam.setF1(playerDataGateway.getPlayer((Integer) (r.get("f1id"))));
                if((Integer)(r.get("f2id")) > 0) fantasyTeam.setF2(playerDataGateway.getPlayer((Integer) (r.get("f2id"))));
                fantasyTeams.add(fantasyTeam);
            }
        }
        catch(RuException e)
        {
            System.out.println("Error creating factory");
        }
        return fantasyTeams;
    }

    public List<FantasyTeam> getAllFantasyTeams()
    {
        String sql = "select * from fantasyteams";
        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());

        List<FantasyTeam> fantasyTeams = queryPosition.query(sql,
                new FantasyTeamRowMapper());

        return fantasyTeams;
    }
}
