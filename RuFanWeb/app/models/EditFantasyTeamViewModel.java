package models;

import is.rufan.team.domain.FantasyTeam;

public class EditFantasyTeamViewModel {
    public int id;
    public int gk;
    public int d1;
    public int d2;
    public int d3;
    public int d4;
    public int m1;
    public int m2;
    public int m3;
    public int m4;
    public int f1;
    public int f2;

    public EditFantasyTeamViewModel() {}
    public EditFantasyTeamViewModel(FantasyTeam team) {
        this.id = team.getId();
        this.gk = team.getgK().getPlayerId();
        this.d1 = team.getD1().getPlayerId();
        this.d2 = team.getD2().getPlayerId();
        this.d3 = team.getD3().getPlayerId();
        this.d4 = team.getD4().getPlayerId();
        this.m1 = team.getM1().getPlayerId();
        this.m2 = team.getM2().getPlayerId();
        this.m3 = team.getM3().getPlayerId();
        this.m4 = team.getM4().getPlayerId();
        this.f1 = team.getF1().getPlayerId();
        this.f2 = team.getF2().getPlayerId();
    }
}
