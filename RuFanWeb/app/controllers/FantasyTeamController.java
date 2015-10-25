package controllers;



import is.rufan.player.domain.Player;
import is.rufan.team.domain.FantasyTeam;
import is.rufan.team.service.FantasyTeamService;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentService;
import is.rufan.user.domain.User;
import models.EditFantasyTeamViewModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Routes;
import play.data.*;
import play.mvc.*;
import is.rufan.user.service.UserService;

import views.html.editfanteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static play.data.Form.*;

public class FantasyTeamController extends Controller {
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
    protected UserService userService = (UserService) ctx.getBean("userService");
    protected TournamentService tournamentService = (TournamentService) ctx.getBean("tournamentService");
    protected FantasyTeamService fanTeamService = (FantasyTeamService) ctx.getBean("fantasyTeamService");
    static Form<EditFantasyTeamViewModel> teamForm = form(EditFantasyTeamViewModel.class);
    Tournament tournament;

    public Result get(int tournamentId) {
        String username = session("username");
        User currentUser = userService.getUserByUsername(username);
        tournament = tournamentService.getTournament(tournamentId);
        List<FantasyTeam> userTeams = fanTeamService.getFantasyTeamsForUser(currentUser.getId());
        FantasyTeam currentTeam = new FantasyTeam(currentUser.getId());

        /* Going through all of the users team to see if he already
         * has a team competing in this tournament */
        for(FantasyTeam t : userTeams) {
            if(t.getTournament().getTournamentId() == tournamentId) {
                currentTeam = t;
            }
        }

        EditFantasyTeamViewModel model = new EditFantasyTeamViewModel(currentTeam);

        Form<EditFantasyTeamViewModel> newForm = teamForm.fill(model);

        return ok(editfanteam.render(currentTeam, newForm));
    }

    public Result update(int tournamentId) {
        Form<EditFantasyTeamViewModel> filledForm = teamForm.bindFromRequest();

        System.out.println(filledForm);

        //return ok(editfanteam.render(newTeam, filledForm));
        return redirect("/");
    }
}