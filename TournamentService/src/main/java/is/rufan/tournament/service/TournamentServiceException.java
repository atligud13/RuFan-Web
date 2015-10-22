package is.rufan.tournament.service;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public class TournamentServiceException extends RuntimeException {
    public TournamentServiceException()
    {
    }

    public TournamentServiceException(String message)
    {
        super(message);
    }

    public TournamentServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
