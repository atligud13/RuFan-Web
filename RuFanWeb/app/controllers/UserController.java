package controllers;


import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import models.ProfileViewModel;
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
  static Form<ProfileViewModel> userForm = form(ProfileViewModel.class);

  public Result get() {
      UserService service = (UserService) ctx.getBean("userService");
      String username = session("username");
      User currentUser = service.getUserByUsername(username);

      ProfileViewModel model = new ProfileViewModel();
      model.user = new UserRegistration();
      model.user.setId(currentUser.getId());
      model.user.setName(currentUser.getName());
      model.user.setUsername(currentUser.getUsername());
      model.user.setPassword(currentUser.getPassword());
      model.user.setRepeatPassword(currentUser.getPassword());
      model.user.setEmail(currentUser.getEmail());

      userForm = userForm.fill(model);

      return ok(user.render(userForm));
  }

  public Result update() {
      return ok();
  }
}
