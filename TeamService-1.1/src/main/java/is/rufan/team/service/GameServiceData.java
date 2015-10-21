package is.rufan.team.service;

import is.rufan.team.data.GameDataGateway;
import is.rufan.team.domain.Game;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.List;

public class GameServiceData implements GameService
{
  RuDataAccessFactory factory;
  GameDataGateway gameDataGateway;

  public GameServiceData() throws RuException
  {
    factory = RuDataAccessFactory.getInstance("gamedata.xml");
    gameDataGateway = (GameDataGateway) factory.getDataAccess("gameData");
  }

  public void addGame(Game game)
  {
    gameDataGateway.addGame(game);
  }

  public List<Game> getGames()
  {
    return gameDataGateway.getGames();
  }
}
