package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public class TournamentRowMapper implements RowMapper<Tournament> {
    public Tournament mapRow(ResultSet resultSet, int i) throws SQLException {
        Tournament tournament = new Tournament();
        tournament.setTournamentId(resultSet.getInt("id"));
        tournament.setActive(resultSet.getBoolean("active"));
        tournament.setStartDate(resultSet.getDate("startdate"));
        tournament.setEndDate(resultSet.getDate("enddate"));
        tournament.setEntryFee(resultSet.getInt("entryfee"));
        tournament.setMaxEntries(resultSet.getInt("maxentries"));
        tournament.setLeagueName(resultSet.getString("leaguename"));
        tournament.setName(resultSet.getString("name"));
        tournament.setPrize(resultSet.getInt("prize"));
        tournament.setWinnerSelected(resultSet.getBoolean("winnerselected"));

        return tournament;
    }
}
