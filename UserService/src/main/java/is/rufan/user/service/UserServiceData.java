package is.rufan.user.service;

import is.rufan.user.data.UserDataGateway;
import is.rufan.user.data.UserNotFoundException;
import is.rufan.user.domain.User;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.logging.Logger;

public class UserServiceData implements UserService
{
  Logger logger = Logger.getLogger(this.getClass().getName());
  private UserDataGateway userDataGateway;
  RuDataAccessFactory factory;

  public UserServiceData() throws RuException
  {
    factory = RuDataAccessFactory.getInstance("userdata.xml");
    userDataGateway = (UserDataGateway) factory.getDataAccess("playerData");
  }

  public static void main(String[] args)
  {
    // Simple test to see if updating a user works
    try
    {
      UserService userService = new UserServiceData();
      
      User atli = new User(2, "atli cool", "atlicoolboy", "atlicool@atli.is", "123456");
      userService.addUser(atli);
      try
      {
        userService.updateUser(atli);
      }
      catch(UserNotFoundException e)
      {
        System.out.println("Atli not found");
      }

      User atli2 = new User(2, "Atli", "atligud", "atli@ru.is", "123456", 6140, "585858-5858", "Mastercard", 10, 2016);
      try
      {
        userService.updateUser(atli2);
      }
      catch(UserNotFoundException e)
      {
        System.out.println("Atli2 not found");
      }
    }
    catch(RuException e)
    {
      System.out.println("Could not update");
    }

    System.out.println("Updating atli worked!");
  }

  public int addUser(User user)
  {
    return userDataGateway.create(user);
  }

  public void updateUser(User user)
  {
    try
    {
      userDataGateway.updateUser(user);
    }
    catch(UserNotFoundException e)
    {
      throw new UserNotFoundException();
    }
  }

  public User getUser(int id)
  {
    return userDataGateway.find(id);
  }

  public User getUserByUsername(String username)
  {
    return userDataGateway.find(username);
  }
}
