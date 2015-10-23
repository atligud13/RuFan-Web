package is.rufan.team.domain;

import is.rufan.player.domain.Player;

import java.util.List;

/**
 * Created by Atli Guðlaugsson on 10/23/2015.
 */
public class FantasyTeam {
    private int id;
    private int userId;

    private Player gK;

    private Player d1;
    private Player d2;
    private Player d3;
    private Player d4;
    private Player m1;
    private Player m2;
    private Player m3;
    private Player m4;
    private Player f1;
    private Player f2;

    public FantasyTeam(int userId)
    {
        this.id = 0;
        this.userId = userId;
        this.gK = new Player();
        this.d1 = new Player();
        this.d2 = new Player();
        this.d3 = new Player();
        this.d4 = new Player();
        this.m1 = new Player();
        this.m2 = new Player();
        this.m3 = new Player();
        this.m4 = new Player();
        this.f1 = new Player();
        this.f2 = new Player();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Player getD4() {
        return d4;
    }

    public void setD4(Player d4) {
        this.d4 = d4;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getgK() {
        return gK;
    }

    public void setgK(Player gK) {
        this.gK = gK;
    }

    public Player getD1() {
        return d1;
    }

    public void setD1(Player d1) {
        this.d1 = d1;
    }

    public Player getD2() {
        return d2;
    }

    public void setD2(Player d2) {
        this.d2 = d2;
    }

    public Player getD3() {
        return d3;
    }

    public void setD3(Player d3) {
        this.d3 = d3;
    }

    public Player getM1() {
        return m1;
    }

    public void setM1(Player m1) {
        this.m1 = m1;
    }

    public Player getM2() {
        return m2;
    }

    public void setM2(Player m2) {
        this.m2 = m2;
    }

    public Player getM3() {
        return m3;
    }

    public void setM3(Player m3) {
        this.m3 = m3;
    }

    public Player getM4() {
        return m4;
    }

    public void setM4(Player m4) {
        this.m4 = m4;
    }

    public Player getF1() {
        return f1;
    }

    public void setF1(Player f1) {
        this.f1 = f1;
    }

    public Player getF2() {
        return f2;
    }

    public void setF2(Player f2) {
        this.f2 = f2;
    }
}
