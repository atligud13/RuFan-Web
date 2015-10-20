
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String = "Welcome!"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
import play.api.Play.current

Seq[Any](format.raw/*1.30*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main(title)/*5.13*/ {_display_(Seq[Any](format.raw/*5.15*/("""

    """),format.raw/*7.5*/("""<h2>Welcome to RuFan</h2>

    """),_display_(/*9.6*/if(session.get("username"))/*9.33*/ {_display_(Seq[Any](format.raw/*9.35*/("""

        """),format.raw/*11.9*/("""<div class="jumbotron">
            <h1>RuFan - Daily Fantasy Sport</h1>
            <p>Good to see you again """),_display_(/*13.39*/{session.get("displayName")}),format.raw/*13.67*/("""!</p>
            <a href="#" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-search"></span> Tournaments</a>
        </div>

    """)))}/*17.7*/else/*17.12*/{_display_(Seq[Any](format.raw/*17.13*/("""
        """),format.raw/*18.9*/("""<image src=""""),_display_(/*18.22*/routes/*18.28*/.Assets.versioned("/images/RuFan-FrontPageLogo.png")),format.raw/*18.80*/(""""/>
    """)))}),format.raw/*19.6*/("""
""")))}))
      }
    }
  }

  def render(title:String): play.twirl.api.HtmlFormat.Appendable = apply(title)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (title) => apply(title)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Tue Oct 20 14:50:10 GMT 2015
                  SOURCE: C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/app/views/index.scala.html
                  HASH: 2fec2e9f74c6b71068e80df8cb037bcec9e6feaf
                  MATRIX: 745->1|896->29|924->61|951->63|970->74|1009->76|1041->82|1098->114|1133->141|1172->143|1209->153|1347->264|1396->292|1558->437|1571->442|1610->443|1646->452|1686->465|1701->471|1774->523|1813->532
                  LINES: 27->1|32->1|34->4|35->5|35->5|35->5|37->7|39->9|39->9|39->9|41->11|43->13|43->13|47->17|47->17|47->17|48->18|48->18|48->18|48->18|49->19
                  -- GENERATED --
              */
          