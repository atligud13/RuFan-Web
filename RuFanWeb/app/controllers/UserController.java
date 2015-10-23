package controllers;


import is.rufan.user.domain.User;
import is.rufan.user.domain.UserRegistration;
import models.ProfileViewModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import play.data.*;
import play.data.validation.Validation;
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
      
      //validateForm(filledForm);

      if (filledForm.hasErrors())
      {
          return badRequest(user.render(filledForm));
      }
      return ok();
  }

  private void validateForm(Form<ProfileViewModel> filledForm) {
      ProfileViewModel model = filledForm.get();
      System.out.println(model.favTeam);
      String cardNumber = (String) filledForm.field("cardNumber").value();
      if (!cardNumber.equals("") && !cardNumber.matches("\\d{16}")) {
          filledForm.reject("cardNumber", "Card number should be 16 digits");
      }
  }
}
