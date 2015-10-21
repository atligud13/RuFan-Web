package controllers;


import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.mvc.*;
import is.rufan.user.service.UserService;

import views.html.user;

import static play.data.Form.*;

public class UserController extends Controller
{
  protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
  static Form<UserRegistration> userForm = form(UserRegistration.class);

  public Result get() {
      UserService service = (UserService) ctx.getBean("userService");
      String username = session("username");
      User currentUser = service.getUserByUsername(username);

      UserRegistration regist = new UserRegistration();
      regist.setId(currentUser.getId());
      regist.setName(currentUser.getName());
      regist.setUsername(currentUser.getUsername());
      regist.setPassword(currentUser.getPassword());
      regist.setRepeatPassword(currentUser.getPassword());
      regist.setEmail(currentUser.getEmail());

      userForm = userForm.fill(regist);
      System.out.println(userForm.value());

      return ok(user.render(userForm));
  }

  public Result update() {
      return ok();
  }
}
