
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object signup_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class signup extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[is.rufan.user.domain.UserRegistration],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signupForm: Form[is.rufan.user.domain.UserRegistration]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.59*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main("Signup", nav = "signup")/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
    """),_display_(/*6.6*/helper/*6.12*/.form(action = routes.SignupController.signup)/*6.58*/ {_display_(Seq[Any](format.raw/*6.60*/("""
        """),format.raw/*7.9*/("""<fieldset>
            <legend>Account information</legend>
            """),_display_(/*9.14*/inputText(
                signupForm("username"),
                '_label -> "Username",
                '_help -> "Please enter your username.",
                '_error -> signupForm.globalError
            )),format.raw/*14.14*/("""
            """),_display_(/*15.14*/inputText(
                signupForm("name"),
                '_label -> "Name",
                '_help -> "Please provide your first name.",
                '_error -> signupForm.globalError
            )),format.raw/*20.14*/("""
            """),_display_(/*21.14*/inputText(
                signupForm("email"),
                '_label -> "Email",
                '_help -> "Enter a valid email address."
            )),format.raw/*25.14*/("""
            """),_display_(/*26.14*/inputPassword(
                signupForm("password"),
                '_label -> "Password",
                '_help -> "A password must be at least 6 characters. "
            )),format.raw/*30.14*/("""
            """),_display_(/*31.14*/inputPassword(
                signupForm("repeatPassword"),
                '_label -> "Repeat password",
                '_help -> "Please repeat your password again.",
                '_error -> signupForm.globalError
            )),format.raw/*36.14*/("""
        """),format.raw/*37.9*/("""</fieldset>
        <fieldset>
        """),_display_(/*39.10*/checkbox(
            signupForm("accept"),
            '_label -> None, '_text -> "You agree to the Terms and conditions",
            '_showConstraints -> false
        )),format.raw/*43.10*/("""
        """),format.raw/*44.9*/("""</fieldset>

        <div class="actions">
            <input type="submit" class="btn btn-primary" value="Sign Up">
            <a href=""""),_display_(/*48.23*/routes/*48.29*/.Application.index),format.raw/*48.47*/("""" class="btn">Cancel</a>
        </div>
    """)))}),format.raw/*50.6*/("""
""")))}),format.raw/*51.2*/("""
"""))
      }
    }
  }

  def render(signupForm:Form[is.rufan.user.domain.UserRegistration]): play.twirl.api.HtmlFormat.Appendable = apply(signupForm)

  def f:((Form[is.rufan.user.domain.UserRegistration]) => play.twirl.api.HtmlFormat.Appendable) = (signupForm) => apply(signupForm)

  def ref: this.type = this

}


}

/**/
object signup extends signup_Scope0.signup
              /*
                  -- GENERATED --
                  DATE: Tue Oct 20 14:50:10 GMT 2015
                  SOURCE: C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/app/views/signup.scala.html
                  HASH: 0ab6a6618c307c087fadb5de076cd8d84fe57f57
                  MATRIX: 784->1|951->58|979->77|1006->79|1044->109|1083->111|1114->117|1128->123|1182->169|1221->171|1256->180|1355->253|1586->463|1627->477|1854->683|1895->697|2070->851|2111->865|2310->1043|2351->1057|2606->1291|2642->1300|2709->1340|2902->1512|2938->1521|3104->1660|3119->1666|3158->1684|3233->1729|3265->1731
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|36->6|36->6|36->6|37->7|39->9|44->14|45->15|50->20|51->21|55->25|56->26|60->30|61->31|66->36|67->37|69->39|73->43|74->44|78->48|78->48|78->48|80->50|81->51
                  -- GENERATED --
              */
          