package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public interface TournamentDataGateway {
    void addTournament(Tournament tournament);
    void setWinnerSelected(int tournamentId);
    Tournament getTournament(int tournamentId);
    List<Tournament> getTournaments();
    List<Tournament> getActiveTournaments();
    void addTournamentResult(int teamId, int score);
}
