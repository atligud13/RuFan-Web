package is.rufan.player.process;

import is.rufan.player.domain.Point;
import is.ruframework.reader.RuAbstractReader;
import is.ruframework.reader.RuJsonUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class PointReader extends RuAbstractReader {
    public Object parse(String content) {
        // Get points
        JSONArray jPoints = (JSONArray) JSONValue.parse(content);

        JSONObject jPoint;
        List<Point> points = new ArrayList<Point>();
        Point point;

        for(int i = 0; i < jPoints.size(); i++)
        {
            point = new Point();
            jPoint = (JSONObject) jPoints.get(i);
            point.setPlayerId(RuJsonUtil.getInt(jPoint, "PlayerId"));
            point.setScore(((Number) jPoint.get("FantasyPoints")).doubleValue());

            points.add(point);
            readHandler.read(i, point);
        }

        return points;
    }
}
