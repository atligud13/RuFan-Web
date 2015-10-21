package is.rufan.player.service;

import is.rufan.player.domain.Point;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public interface PointService
{
    Point getPoint(int pointId);
    List<Point> getPoints();
    List<Point> getPointsByPlayerId(int playerId);
    void addPoint(Point point) throws PointServiceException;
}
