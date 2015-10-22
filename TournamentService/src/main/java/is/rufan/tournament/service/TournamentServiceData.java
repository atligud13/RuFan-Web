package is.rufan.tournament.service;

import is.rufan.tournament.data.TournamentDataGateway;
import is.rufan.tournament.domain.Tournament;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public class TournamentServiceData implements TournamentService {
    RuDataAccessFactory factory;
    TournamentDataGateway tournamentDataGateway;

    public TournamentServiceData() throws RuException
    {
        factory = RuDataAccessFactory.getInstance("tournamentdata.xml");
        tournamentDataGateway = (TournamentDataGateway) factory.getDataAccess("tournamentData");
    }

    public static void main(String[] args)
    {
        /* Inserting mock tournaments into the database */
        TournamentService tournamentService;
        try
        {
            tournamentService = new TournamentServiceData();
            ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(0);

            /* Creating mock dates */
            Date startDate1 = new Date();
            Date startDate2 = new Date();
            Date startDate3 = new Date();
            Date startDate4 = new Date();

            cal.set(2015, 12, 20, 0, 0, 0);
            Date startDate5 = cal.getTime();
            Date endDate1 = cal.getTime();
            Date endDate2 = cal.getTime();
            Date endDate3 = cal.getTime();

            cal.set(2015, 11, 1, 0, 0, 0);
            Date endDate4 = cal.getTime();
            Date endDate5 = cal.getTime();

            /* Creating mock tournament */
            tournaments.add(new Tournament(1, "EPL $1000 GTD", true,
                    startDate1, endDate1, "English Premier League", 100,
                    10, 1000));
            tournaments.add(new Tournament(2, "EPL $750 GTD", true,
                    startDate2, endDate2, "English Premier League", 100,
                    7, 750));
            tournaments.add(new Tournament(3, "EPL $300 GTD", true,
                    startDate3, endDate3, "English Premier League", 50,
                    5, 500));
            tournaments.add(new Tournament(4, "EPL $1000 All Pick FFA", true,
                    startDate4, endDate4, "English Premier League", 50,
                    10, 1000));
            tournaments.add(new Tournament(5, "EPL $1000 GTD", true,
                    startDate5, endDate5, "English Premier League", 100,
                    10, 1000));

            /* Adding all the tournaments */
            for(int i = 0; i < tournaments.size(); i++) {
                tournamentService.addTournament(tournaments.get(i));
            }
        }
        catch(RuException e)
        {
            System.out.println("Something went wrong when creating mock tournaments in main");
        }
    }

    public Tournament getTournament(int tournamentId)
    {
        return tournamentDataGateway.getTournament(tournamentId);
    }

    public List<Tournament> getTournaments()
    {
        return tournamentDataGateway.getTournaments();
    }

    public void addTournament(Tournament tournament)
    {
        tournamentDataGateway.addTournament(tournament);
    }
}
