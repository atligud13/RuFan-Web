package is.rufan.player.data;

import is.rufan.player.domain.Point;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class PointRowMapper implements RowMapper<Point>
{
    public Point mapRow(ResultSet resultSet, int i) throws SQLException {
        Point point = new Point();
        point.setPlayerId(resultSet.getInt("playerid"));
        point.setScore(resultSet.getInt("score"));

        return point;
    }
}
