package is.rufan.team.service;

import is.rufan.team.domain.Game;

import java.util.List;

public interface GameService
{
  void addGame(Game game);
  List<Game> getGames();
}
