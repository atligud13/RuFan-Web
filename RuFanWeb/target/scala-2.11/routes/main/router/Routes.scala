
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/conf/routes
// @DATE:Tue Oct 20 14:50:09 GMT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_2: controllers.Application,
  // @LINE:7
  SignupController_3: controllers.SignupController,
  // @LINE:9
  LoginController_1: controllers.LoginController,
  // @LINE:15
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_2: controllers.Application,
    // @LINE:7
    SignupController_3: controllers.SignupController,
    // @LINE:9
    LoginController_1: controllers.LoginController,
    // @LINE:15
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_2, SignupController_3, LoginController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_2, SignupController_3, LoginController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.SignupController.blank()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.SignupController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.blank()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_2.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_SignupController_blank1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_SignupController_blank1_invoker = createInvoker(
    SignupController_3.blank(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignupController",
      "blank",
      Nil,
      "GET",
      """""",
      this.prefix + """signup"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_SignupController_signup2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_SignupController_signup2_invoker = createInvoker(
    SignupController_3.signup(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SignupController",
      "signup",
      Nil,
      "POST",
      """""",
      this.prefix + """signup"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LoginController_blank3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_blank3_invoker = createInvoker(
    LoginController_1.blank(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "blank",
      Nil,
      "GET",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_LoginController_login4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login4_invoker = createInvoker(
    LoginController_1.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LoginController_logout5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout5_invoker = createInvoker(
    LoginController_1.logout(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "GET",
      """""",
      this.prefix + """logout"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_2.index())
      }
  
    // @LINE:7
    case controllers_SignupController_blank1_route(params) =>
      call { 
        controllers_SignupController_blank1_invoker.call(SignupController_3.blank())
      }
  
    // @LINE:8
    case controllers_SignupController_signup2_route(params) =>
      call { 
        controllers_SignupController_signup2_invoker.call(SignupController_3.signup())
      }
  
    // @LINE:9
    case controllers_LoginController_blank3_route(params) =>
      call { 
        controllers_LoginController_blank3_invoker.call(LoginController_1.blank())
      }
  
    // @LINE:10
    case controllers_LoginController_login4_route(params) =>
      call { 
        controllers_LoginController_login4_invoker.call(LoginController_1.login())
      }
  
    // @LINE:11
    case controllers_LoginController_logout5_route(params) =>
      call { 
        controllers_LoginController_logout5_invoker.call(LoginController_1.logout())
      }
  
    // @LINE:15
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_0.versioned(path, file))
      }
  }
}