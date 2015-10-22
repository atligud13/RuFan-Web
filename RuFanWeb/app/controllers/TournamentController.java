package controllers;


import is.rufan.player.domain.Country;
import is.rufan.player.domain.Player;
import is.rufan.player.domain.Position;
import is.rufan.player.service.PlayerService;
import is.rufan.tournament.domain.Tournament;
import is.rufan.tournament.service.TournamentService;
import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.mvc.*;
import is.rufan.user.service.UserService;

import views.html.tournaments;

import java.util.ArrayList;
import java.util.Date;

import static play.data.Form.*;

public class TournamentController extends Controller
{
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");

    public Result get() {
        TournamentService service = (TournamentService) ctx.getBean("tournamentService");
        ArrayList<Tournament> tournamentList = (ArrayList<Tournament>) service.getTournaments();

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player(0, "Atli", "Gudlaugsson", 80, 80, new Date(), new Country(0, "Iceland", "ICE"), 0, new Position(0, "Forward", "F", 0)));
        players.add(new Player(0, "Arnar", "Gudlaugsson", 80, 80, new Date(), new Country(0, "Iceland", "ICE"), 0, new Position(0, "Forward", "F", 0)));
        players.add(new Player(0, "Anton", "Gudlaugsson", 80, 80, new Date(), new Country(0, "Iceland", "ICE"), 0, new Position(0, "Forward", "F", 0)));
        players.add(new Player(0, "Bjarni", "Gudlaugsson", 80, 80, new Date(), new Country(0, "Iceland", "ICE"), 0, new Position(0, "Forward", "F", 0)));
        players.add(new Player(0, "Thordis", "Gudlaugsson", 80, 80, new Date(), new Country(0, "Iceland", "ICE"), 0, new Position(0, "Forward", "F", 0)));

        return ok(tournaments.render(tournamentList));
    }

    public Result post() {
        return ok();
    }
}
