package controllers;



import is.rufan.player.domain.Player;
import is.rufan.player.service.PlayerService;
import is.rufan.team.domain.FantasyTeam;
import is.rufan.team.service.FantasyTeamService;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentService;
import is.rufan.user.domain.User;
import javassist.tools.rmi.ObjectNotFoundException;
import models.EditFantasyTeamViewModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.Routes;
import play.data.*;
import play.data.validation.ValidationError;
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
    protected PlayerService playerService = (PlayerService) ctx.getBean("playerService");
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

        return ok(editfanteam.render(tournament, currentTeam, newForm));
    }

    public Result update(int tournamentId) {
        User user = userService.getUserByUsername(session("username"));
        Form<EditFantasyTeamViewModel> filledForm = teamForm.bindFromRequest();
        EditFantasyTeamViewModel model = filledForm.get();
        FantasyTeam team;

        // This is a new team
        if (model.id == 0) {
            team = new FantasyTeam(user.getId());
            team.setTournament(tournamentService.getTournament(tournamentId));
        } else {
            team = fanTeamService.getFantasyTeam(model.id);
        }

        team.setgK(getPlayer(model.gk));
        team.setD1(getPlayer(model.d1));
        team.setD2(getPlayer(model.d2));
        team.setD3(getPlayer(model.d3));
        team.setD4(getPlayer(model.d4));
        team.setM1(getPlayer(model.m1));
        team.setM2(getPlayer(model.m2));
        team.setM3(getPlayer(model.m3));
        team.setM4(getPlayer(model.m4));
        team.setF1(getPlayer(model.f1));
        team.setF2(getPlayer(model.f2));

        if (model.id == 0) {
            try {
                fanTeamService.addFantasyTeam(team);
            } catch (NullPointerException e) {
                filledForm.reject("A player has to be selected in every position.");
                return badRequest(editfanteam.render(team.getTournament(), team, filledForm));
            }
        } else {
            try {
                fanTeamService.updateFantasyTeam(team);
            } catch (ObjectNotFoundException e) {
            }
        }

        //return ok(editfanteam.render(newTeam, filledForm));
        return redirect("/fantasyteam/" + tournamentId);
    }

    private Player getPlayer(int id) {
        return (id > 0 ? playerService.getPlayer(id) : null);
    }
}