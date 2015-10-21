package is.rufan.player.domain;

/**
 * Created by Atli Guðlaugsson on 10/21/2015.
 */
public class Point {
    protected int playerId;
    protected double score;

    public Point(){}
    public Point(int playerId, double score)
    {
        this.playerId = playerId;
        this.score = score;
    }

    public int getPlayerId()
    {
        return this.playerId;
    }
    public void setPlayerId(int playerId)
    {
        this.playerId = playerId;
    }
    public double getScore()
    {
        return this.score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }
}
