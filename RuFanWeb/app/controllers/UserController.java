package controllers;


import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import models.ProfileViewModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.data.validation.*;
import play.mvc.*;
import is.rufan.user.service.UserService;

import views.html.user;

import static play.data.Form.*;

public class UserController extends Controller
{
  protected ApplicationContext ctx = new FileSystemXmlApplicationContext("/conf/userapp.xml");
  protected UserService service = (UserService) ctx.getBean("userService");
  static Form<ProfileViewModel> userForm = form(ProfileViewModel.class);

  public Result get() {
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
      Form<ProfileViewModel> filledForm = userForm.bindFromRequest();

      if (filledForm.field("user.name").value().length() < 1) {
          filledForm.reject("user.name", "Name is required");
      }

      if (filledForm.field("user.email").value().length() < 1) {
          filledForm.reject("user.email", "Email is required");
      }

      if (filledForm.field("user.password").value().length() > 0) {
          if (filledForm.field("user.password").value().length() < 6) {
              filledForm.reject("user.password", "Password needs to be at least 6 letters");
          }
          else if (!filledForm.field("user.repeatPassword").value().equals(filledForm.field("user.password").value())) {
              filledForm.reject("user.password", "Password doesn't match");
              filledForm.reject("user.repeatPassword", "Password doesn't match");
          }
      }

      if (filledForm.hasErrors())
      {
          return badRequest(user.render(filledForm));
      }
      return ok();
  }
}
