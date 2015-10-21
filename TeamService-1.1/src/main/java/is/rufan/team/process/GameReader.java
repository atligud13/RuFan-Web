package is.rufan.team.process;

import is.rufan.team.domain.Game;
import is.rufan.team.domain.Team;
import is.rufan.team.domain.Venue;
import is.ruframework.reader.RuAbstractReader;

import is.ruframework.reader.RuJsonUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GameReader extends RuAbstractReader
{
  public Object parse(String content)
  {
    List<Game> games = new ArrayList<Game>();

    // Root object
    JSONArray jGames = (JSONArray)JSONValue.parse(content);

    for (int i=0; i < jGames.size(); i++)
    {
      JSONObject jGame = (JSONObject)jGames.get(i);

      Game game = new Game();

      // Event id
      game.setGameId(RuJsonUtil.getInt(jGame, "EventId"));
      game.setStartTime(convertDate((String) jGame.get("StartTime")));

      // Home team
      JSONObject jHomeTeam = (JSONObject)jGame.get("Home");
      Team teamHome = new Team();
      teamHome.setTeamId(RuJsonUtil.getInt(jHomeTeam, "Id"));
      game.setTeamHome(teamHome);

      // Away team
      JSONObject jAwayTeam = (JSONObject)jGame.get("Away");
      Team teamAway = new Team();
      teamAway.setTeamId(RuJsonUtil.getInt(jAwayTeam, "Id"));
      game.setTeamAway(teamAway);

      // Venue
      JSONObject jVenue = (JSONObject)jGame.get("Venue");
      Venue venue = new Venue();
      venue.setVenueId(RuJsonUtil.getInt(jVenue, "Id"));
      game.setVenue(venue);

      games.add(game);
      readHandler.read(i, game);
    }


    return games;
  }

  // 2015-08-21T16:19:30.3373863Z
  private  Date convertDate(String strDate)
  {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd\'T\'HH:mm:ss", Locale.ENGLISH);
    Date date = null;

    try
    {
      date = format.parse(strDate);
    }
    catch (ParseException var4)
    {
      System.out.println("FAIL");
    }
    return date;
  }
}
