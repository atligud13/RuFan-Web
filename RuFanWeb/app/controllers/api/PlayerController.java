package controllers.api;

import is.rufan.player.domain.Player;
import is.rufan.player.service.PlayerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.libs.Json;
import play.mvc.*;

import java.util.List;

public class PlayerController extends Controller {
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
    protected PlayerService service = (PlayerService) ctx.getBean("playerService");

    public Result getPlayers(int teamId, int posId) {
        List<Player> players;

        if (posId == 0) {
            players = service.getPlayers(teamId);
        } else {
            players = service.getPlayersByPosition(teamId, posId);
        }

        return ok(Json.toJson(players));
    }
}
