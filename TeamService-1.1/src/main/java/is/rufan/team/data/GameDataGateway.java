package is.rufan.team.data;

import is.rufan.team.domain.Game;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public interface GameDataGateway {
    void addGame(Game game);
    Game getGame(int gameId);
    List<Game> getGames();
}
