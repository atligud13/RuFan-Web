package is.rufan.tournament.data;

import is.rufan.tournament.domain.Tournament;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Atli Guðlaugsson on 10/22/2015.
 */
public class TournamentData extends RuData implements TournamentDataGateway {

    public void addTournament(Tournament tournament) {
        SimpleJdbcInsert insertTournament =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("tournaments")
                        .usingGeneratedKeyColumns("id");

        Map<String, Object> tParameters = new HashMap<String, Object>(7);
        tParameters.put("name", tournament.getName());
        tParameters.put("active", tournament.isActive());
        tParameters.put("startdate", tournament.getStartDate());
        tParameters.put("enddate", tournament.getEndDate());
        tParameters.put("entryfee", tournament.getEntryFee());
        tParameters.put("maxentries", tournament.getMaxEntries());
        tParameters.put("leaguename", tournament.getLeagueName());
        tParameters.put("prize", tournament.getPrize());

        try
        {
            insertTournament.execute(tParameters);
        }
        catch(DataIntegrityViolationException e)
        {
            log.warning("Something went wrong when inserting tournament");
        }
    }

    public Tournament getTournament(int tournamentId) {
        String sql = "select * from tournaments where id = ?";
        JdbcTemplate queryT = new JdbcTemplate(getDataSource());
        Tournament tournament = queryT.queryForObject(sql, new Object[] { tournamentId },
                new TournamentRowMapper());

        return tournament;
    }

    public List<Tournament> getTournaments() {
        String sql = "select * from tournaments";
        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = queryPosition.query(sql,
                new TournamentRowMapper());

        return tournaments;
    }

    public List<Tournament> getActiveTournaments() {
        String sql = "select * from tournaments where active = 1";

        JdbcTemplate queryPosition= new JdbcTemplate(getDataSource());

        List<Tournament> tournaments = queryPosition.query(sql,
                new TournamentRowMapper());

        return tournaments;
    }
}
