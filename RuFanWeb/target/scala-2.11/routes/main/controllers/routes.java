
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/conf/routes
// @DATE:Tue Oct 20 14:50:09 GMT 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseSignupController SignupController = new controllers.ReverseSignupController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLoginController LoginController = new controllers.ReverseLoginController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseSignupController SignupController = new controllers.javascript.ReverseSignupController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLoginController LoginController = new controllers.javascript.ReverseLoginController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
