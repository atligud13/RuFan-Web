package is.rufan.tournament.domain;

import java.util.Date;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public class Tournament {
    protected int tournamentId;
    protected String name;
    protected boolean active;
    protected Date startDate;
    protected Date endDate;
    protected int entryFee;
    protected int maxEntries;
    protected String leagueName;
    protected int prize;
    protected boolean winnerSelected;

    public boolean isWinnerSelected() {
        return winnerSelected;
    }

    public void setWinnerSelected(boolean winnerSelected) {
        this.winnerSelected = winnerSelected;
    }

    public Tournament(){}

    public Tournament(int tournamentId, String name, boolean active, Date startDate,
                      Date endDate, String leagueName, int maxEntries, int entryFee, int prize) {
        this.tournamentId = tournamentId;
        this.name = name;
        this.active = active;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leagueName = leagueName;
        this.maxEntries = maxEntries;
        this.entryFee = entryFee;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public int getMaxEntries() {
        return maxEntries;
    }

    public void setMaxEntries(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
}
