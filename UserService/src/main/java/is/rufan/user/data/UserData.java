package is.rufan.user.data;

import is.rufan.user.domain.User;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserData extends RuData implements UserDataGateway
{
  public int create(User user) throws UserDuplicateException
  {
    SimpleJdbcInsert insertUser =
        new SimpleJdbcInsert(getDataSource())
            .withTableName("users")
            .usingGeneratedKeyColumns("id");

    Map<String, Object> parameters = new HashMap<String, Object>(5);
    parameters.put("name", user.getName());
    parameters.put("username", user.getUsername());
    parameters.put("email", user.getEmail());
    parameters.put("password", user.getPassword());

    int returnKey = 0;
    try
    {
      returnKey = insertUser.executeAndReturnKey(parameters).intValue();
    }
    catch (DataIntegrityViolationException divex)
    {
      String msg = "Username is taken";
      log.warning(msg);
      throw new UserDuplicateException(msg);
    }
    return returnKey;
  }

  public User find(int userid)
  {
    String sql = "select * from users where id = ?";
    JdbcTemplate queryPlayer = new JdbcTemplate(getDataSource());

    try
    {
      User user = queryPlayer.queryForObject(sql, new Object[]{userid},
          new UserRowMapper());
      return user;
    }
    catch(EmptyResultDataAccessException erdax)
    {
      return null;
    }
  }

  public User find(String username)
  {
    String sql = "select * from users where username = ?";
    JdbcTemplate queryPlayer = new JdbcTemplate(getDataSource());

    try
    {
      User user = queryPlayer.queryForObject(sql, new Object[]{username},
          new UserRowMapper());
      return user;
    }
    catch(EmptyResultDataAccessException erdax)
    {
      return null;
    }

  }

  public void updateUser(User user) throws UserNotFoundException
  {
    String updateTableSQL = "update users SET name = ?, username = ?, email = ?, password = ?  where id = ?";
    try
    {
      PreparedStatement preparedStatement = getDataSource().getConnection().prepareStatement(updateTableSQL);
      preparedStatement.setString(1, user.getName());
      preparedStatement.setString(2, user.getUsername());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getPassword());
      preparedStatement.setInt(5, user.getId());

      // execute update SQL stetement
      preparedStatement.executeUpdate();

      System.out.println("Record is updated to users table!");

    }
    catch(SQLException e)
    {
      log.warning("Could not update user");
      throw new UserNotFoundException();
    }
  }

}
