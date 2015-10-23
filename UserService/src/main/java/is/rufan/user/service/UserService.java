package is.rufan.user.service;

import is.rufan.user.data.UserNotFoundException;
import is.rufan.user.domain.User;

public interface UserService
{
  int addUser(User user);
  void updateUser(User user);
  User getUser(int id);
  User getUserByUsername(String username);
}
