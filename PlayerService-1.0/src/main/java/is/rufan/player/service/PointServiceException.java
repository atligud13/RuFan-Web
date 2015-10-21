package is.rufan.player.service;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class PointServiceException extends RuntimeException {
    public PointServiceException()
    {
    }

    public PointServiceException(String message)
    {
        super(message);
    }

    public PointServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
