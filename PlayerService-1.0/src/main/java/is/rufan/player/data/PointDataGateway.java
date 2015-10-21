package is.rufan.player.data;

import is.rufan.player.domain.Point;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public interface PointDataGateway
{
    void addPoint(Point point);
    Point getPoint(int pointId);
    List<Point> getPoints();
    List<Point> getPointsByPlayerId(int playerId);
}
