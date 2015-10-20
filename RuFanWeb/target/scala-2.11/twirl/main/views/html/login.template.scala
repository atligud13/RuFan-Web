
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object login_Scope0 {
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

class login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Form[is.rufan.user.domain.User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(signupForm: Form[is.rufan.user.domain.User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import helper._

Seq[Any](format.raw/*1.47*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(title = "Login", nav = "login")/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
    """),_display_(/*6.6*/helper/*6.12*/.form(action = routes.LoginController.login)/*6.56*/ {_display_(Seq[Any](format.raw/*6.58*/("""
        """),format.raw/*7.9*/("""<fieldset>
            <legend>Login details</legend>
            """),_display_(/*9.14*/inputText(
                signupForm("username"),
                '_label -> "Username",
                '_error -> signupForm.globalError
            )),format.raw/*13.14*/("""
            """),_display_(/*14.14*/inputPassword(
                signupForm("password"),
                '_label -> "Password"
            )),format.raw/*17.14*/("""
        """),format.raw/*18.9*/("""</fieldset>

        <div class="actions">
            <input type="submit" class="btn primary" value="Login">
            <a href=""""),_display_(/*22.23*/routes/*22.29*/.Application.index),format.raw/*22.47*/("""" class="btn">Cancel</a>
        </div>
    """)))}),format.raw/*24.6*/("""
""")))}))
      }
    }
  }

  def render(signupForm:Form[is.rufan.user.domain.User]): play.twirl.api.HtmlFormat.Appendable = apply(signupForm)

  def f:((Form[is.rufan.user.domain.User]) => play.twirl.api.HtmlFormat.Appendable) = (signupForm) => apply(signupForm)

  def ref: this.type = this

}


}

/**/
object login extends login_Scope0.login
              /*
                  -- GENERATED --
                  DATE: Tue Oct 20 14:50:10 GMT 2015
                  SOURCE: C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/app/views/login.scala.html
                  HASH: 038a9421f07ec4f351b5f4c382c65f018d99dfe2
                  MATRIX: 770->1|925->46|953->65|980->67|1024->103|1063->105|1094->111|1108->117|1160->161|1199->163|1234->172|1327->239|1501->392|1542->406|1669->512|1705->521|1865->654|1880->660|1919->678|1994->723
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|36->6|36->6|36->6|36->6|37->7|39->9|43->13|44->14|47->17|48->18|52->22|52->22|52->22|54->24
                  -- GENERATED --
              */
          