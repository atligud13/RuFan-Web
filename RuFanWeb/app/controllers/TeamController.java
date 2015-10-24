package controllers;

import is.rufan.team.domain.FantasyTeam;
import is.rufan.team.service.FantasyTeamService;
import is.rufan.user.domain.User;
import is.rufan.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.mvc.*;

import views.html.fanteam;

import java.util.ArrayList;
import java.util.List;

public class TeamController extends Controller {

    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
    protected UserService userService = (UserService) ctx.getBean("userService");
    protected FantasyTeamService teamService = (FantasyTeamService) ctx.getBean("fantasyTeamService");

    public Result getUserTeam() {
        User user = userService.getUserByUsername((String)session("username"));
        List<FantasyTeam> teams = teamService.getFantasyTeamsForUser(user.getId());
        List<FantasyTeam> activeTeams = new ArrayList<>();

        for (FantasyTeam team : teams) {
            System.out.println(team.getTournament().getName());
            if (team.getTournament().isActive()) {
                activeTeams.add(team);
            }
        }

        return ok(fanteam.render(activeTeams));
    }

}
