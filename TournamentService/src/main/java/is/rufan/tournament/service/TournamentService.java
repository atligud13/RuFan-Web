package is.rufan.tournament.service;

import is.rufan.tournament.domain.Tournament;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public interface TournamentService {
    Tournament getTournament(int tournamentId);
    List<Tournament> getTournaments();
    List<Tournament> getActiveTournaments();
    void addTournament(Tournament tournament);
    void setWinnerSelected(int tournamentId);
    void addTournamentResult(int teamId, int score);
}
