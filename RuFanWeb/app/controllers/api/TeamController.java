package controllers.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.libs.Json;
import play.mvc.*;

import is.rufan.team.service.TeamService;
import is.rufan.team.domain.Team;

import java.util.List;

public class TeamController extends Controller {
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
    protected TeamService service = (TeamService) ctx.getBean("teamService");

    public Result getTeams() {
        List<Team> teams = service.getTeams();

        return ok(Json.toJson(teams));
    }
}
