package controllers;


import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import models.UserProfileViewModel;
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
  protected UserService service = (UserService) ctx.getBean("userService");
  static Form<UserProfileViewModel> userForm = form(UserProfileViewModel.class);

  public Result get() {
      String username = session("username");

      // User is not logged in
      if (username == null) {
          return redirect("/");
      }

      User currentUser = service.getUserByUsername(username);

      UserProfileViewModel model = new UserProfileViewModel(currentUser);

      Form<UserProfileViewModel> newForm = userForm.fill(model);

      return ok(user.render(newForm));
  }

  public Result update() {
      Form<UserProfileViewModel> filledForm = userForm.bindFromRequest();

      if (!filledForm.field("password").value().equals(filledForm.field("repeatPassword").value())) {
          filledForm.reject("password", "Password doesn't match");
          filledForm.reject("repeatPassword", "Password doesn't match");
      }

      if (filledForm.hasErrors())
      {
          System.out.println(filledForm);
          return badRequest(user.render(filledForm));
      }

      User oldUser = service.getUserByUsername(session("username"));
      User newUser = filledForm.get();

      oldUser.setName(newUser.getName());
      oldUser.setEmail(newUser.getEmail());
      oldUser.setPassword((newUser.getPassword().length() < 6 ? oldUser.getPassword() : newUser.getPassword()));
      oldUser.setFavoriteTeamId(newUser.getFavoriteTeamId());
      oldUser.setCreditCardType(newUser.getCreditCardType());
      oldUser.setCreditCardNumber(newUser.getCreditCardNumber());
      oldUser.setCreditCardExpirationMonth(newUser.getCreditCardExpirationMonth());
      oldUser.setCreditCardExpirationYear(newUser.getCreditCardExpirationYear());

      service.updateUser(oldUser);

      return redirect("/user");
  }
}
