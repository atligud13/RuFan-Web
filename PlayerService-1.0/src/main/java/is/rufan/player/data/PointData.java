package is.rufan.player.data;

import is.rufan.player.domain.Point;
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
public class PointData extends RuData implements PointDataGateway
{
    public void addPoint(Point point) {
        /*System.out.println("Adding point:" + point.getPointId() +
                "for player: " + point.getPlayerId() + ", score: " + point.getScore());*/
        SimpleJdbcInsert insertPoint =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("points");

        Map<String, Object> pointParameters = new HashMap<String, Object>(3);
        pointParameters.put("playerid", point.getPlayerId());
        pointParameters.put("score", point.getScore());

        try
        {
            insertPoint.execute(pointParameters);
        }
        catch(DataIntegrityViolationException e)
        {
            log.warning(e.toString());
        }
    }

    public Point getPoint(int pointId) {
        String sql = "select * from points where id = ?";
        JdbcTemplate queryPoint= new JdbcTemplate(getDataSource());
        Point point = queryPoint.queryForObject(sql, new Object[] { pointId },
                new PointRowMapper());
        return point;
    }

    public List<Point> getPoints()
    {
        String sql = "select * from points";
        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());

        List<Point> points = queryPosition.query(sql,
                new PointRowMapper());

        return points;
    }

    public List<Point> getPointsByPlayerId(int playerId)
    {
        String sql = "select * from points where playerId = ?";
        JdbcTemplate queryPoint= new JdbcTemplate(getDataSource());
        List<Point> points =  queryPoint.query(sql, new Object[] { playerId },
                new PointRowMapper());
        return points;
    }
}
