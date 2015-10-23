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
  protected UserService service = (UserService) ctx.getBean("userService");
  static Form<UserRegistration> userForm = form(UserRegistration.class);

  public Result get() {
      String username = session("username");
      User currentUser = service.getUserByUsername(username);

      UserRegistration model = new UserRegistration();
      model.setId(currentUser.getId());
      model.setName(currentUser.getName());
      model.setUsername(currentUser.getUsername());
      model.setPassword(currentUser.getPassword());
      model.setRepeatPassword(currentUser.getPassword());
      model.setEmail(currentUser.getEmail());
      model.setFavoriteTeamId(currentUser.getFavoriteTeamId());
      model.setCreditCardType(currentUser.getCreditCardType());
      model.setCreditCardNumber(currentUser.getCreditCardNumber());
      model.setCreditCardExpirationYear(currentUser.getCreditCardExpirationYear());
      model.setCreditCardExpirationMonth(currentUser.getCreditCardExpirationMonth());

      Form<UserRegistration> newForm = userForm.fill(model);

      return ok(user.render(newForm));
  }

  public Result update() {
      Form<UserRegistration> filledForm = userForm.bindFromRequest();

      validate(filledForm);

      if (filledForm.hasErrors())
      {
          return badRequest(user.render(filledForm));
      }

      // Patching non-required fields
      User newUser = filledForm.get();
      User oldUser = service.getUserByUsername(newUser.getUsername());

      newUser.setPassword((newUser.getPassword().length() < 6 ? oldUser.getPassword() : newUser.getPassword()));
      
      service.updateUser(newUser);

      return ok(user.render(filledForm));
  }

  private void validate(Form<UserRegistration> filledForm) {
      if (filledForm.field("name").value().length() < 1) {
          filledForm.reject("user.name", "Name is required");
      }

      if (filledForm.field("email").value().length() < 1) {
          filledForm.reject("email", "Email is required");
      }

      if (filledForm.field("password").value().length() > 0) {
          if (filledForm.field("password").value().length() < 6) {
              filledForm.reject("password", "Password needs to be at least 6 letters");
          }
          else if (!filledForm.field("repeatPassword").value().equals(filledForm.field("password").value())) {
              filledForm.reject("password", "Password doesn't match");
              filledForm.reject("repeatPassword", "Password doesn't match");
          }
      }

      String ccNumber = filledForm.field("creditCardNumber").value();
      if (ccNumber.length() > 0 && !ccNumber.matches("\\d{16}")) {
          filledForm.reject("creditCardNumber", "Creditcard number should be 16 numbers without spaces");
      }
  }
}
