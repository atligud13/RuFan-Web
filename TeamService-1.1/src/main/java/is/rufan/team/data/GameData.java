package is.rufan.team.data;

import is.rufan.team.domain.Game;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class GameData extends RuData implements GameDataGateway {
    public void addGame(Game game) {
        SimpleJdbcInsert insertGame =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("games");

        Map<String, Object> gameParameters = new HashMap<String, Object>(5);
        gameParameters.put("gameid", game.getGameId());
        gameParameters.put("hometeamid", game.getTeamHome().getTeamId());
        gameParameters.put("awayteamid", game.getTeamAway().getTeamId());
        gameParameters.put("venueid", game.getVenue().getVenueId());
        gameParameters.put("startdate", game.getStartTime());

        try
        {
            insertGame.execute(gameParameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Duplicate entry");
        }
    }

    public Game getGame(int gameId) {
        String sql = "select * from games where id = ?";
        JdbcTemplate queryGame = new JdbcTemplate(getDataSource());
        Game game = queryGame.queryForObject(sql, new Object[] { gameId },
                new GameRowMapper());
        return game;
    }

    public List<Game> getGames() {
        String sql = "select * from games";
        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());

        List<Game> games = queryPosition.query(sql,
                new GameRowMapper());

        return games;
    }
}
