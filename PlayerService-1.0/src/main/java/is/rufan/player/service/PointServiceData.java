package is.rufan.player.service;

import is.rufan.player.data.PointDataGateway;
import is.rufan.player.domain.Point;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class PointServiceData implements PointService {
    RuDataAccessFactory factory;
    PointDataGateway pointDataGateway;

    public PointServiceData() throws RuException
    {
        factory = RuDataAccessFactory.getInstance("pointdata.xml");
        pointDataGateway = (PointDataGateway) factory.getDataAccess("pointData");
    }

    public Point getPoint(int pointId) {
        return pointDataGateway.getPoint(pointId);
    }

    public List<Point> getPoints() {
        return pointDataGateway.getPoints();
    }

    public List<Point> getPointsByPlayerId(int playerId) {
        return pointDataGateway.getPointsByPlayerId(playerId);
    }

    public void addPoint(Point point) throws PointServiceException {
        pointDataGateway.addPoint(point);
    }
}
