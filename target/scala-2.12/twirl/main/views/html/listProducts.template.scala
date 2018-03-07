
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import models.products.Category
/*2.2*/import models.products.Product
/*3.2*/import models.users.User

object listProducts extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[List[Product],List[Category],Long,String,User,play.api.Environment,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(products: List[Product], categories: List[Category], catId: Long, filter: String, user: User,env: play.api.Environment):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.122*/("""


"""),_display_(/*7.2*/main("Products",user)/*7.23*/ {_display_(Seq[Any](format.raw/*7.25*/("""

"""),format.raw/*9.1*/("""<p class="lead">Product Catalogue</p>
<br>
<div class="row">
  <div class="col-sm-2">
    <h4>Categories</h4>
    <div class="list-group">
      <a href=""""),_display_(/*15.17*/routes/*15.23*/.ProductCtrl.listProducts(0, filter)),format.raw/*15.59*/("""" class="list-group-item">All Categories</a>
      """),_display_(/*16.8*/for(c <- categories) yield /*16.28*/ {_display_(Seq[Any](format.raw/*16.30*/("""
        """),format.raw/*17.9*/("""<a href=""""),_display_(/*17.19*/routes/*17.25*/.ProductCtrl.listProducts(c.getId, filter)),format.raw/*17.67*/("""" class="list-group-item">"""),_display_(/*17.94*/c/*17.95*/.getName),format.raw/*17.103*/("""
          """),format.raw/*18.11*/("""<span class="badge">"""),_display_(/*18.32*/c/*18.33*/.getProducts.size()),format.raw/*18.52*/("""</span>
        </a>
      """)))}),format.raw/*20.8*/("""
    """),format.raw/*21.5*/("""</div>
  </div>
  <div class="col-sm-10">
      """),_display_(/*24.8*/if(flash.containsKey("success"))/*24.40*/ {_display_(Seq[Any](format.raw/*24.42*/("""
        """),format.raw/*25.9*/("""<div class="alert alert-success">
          """),_display_(/*26.12*/flash/*26.17*/.get("success")),format.raw/*26.32*/("""
        """),format.raw/*27.9*/("""</div>
      """)))}),format.raw/*28.8*/("""
      """),format.raw/*29.7*/("""<div id="actions">
        <form action=""""),_display_(/*30.24*/routes/*30.30*/.ProductCtrl.listProducts(catId)),format.raw/*30.62*/("""" method="GET">
          <input type="search" id="searchbox" name="filter" value=""""),_display_(/*31.69*/filter),format.raw/*31.75*/("""" placeholder="Filter by product name...">
          <input type="submit" id="searchsubmit" value="Filter by name" class="btn-md btn-primary">
        </form>
        
      </div>
    <table class="table table-bordered table-hover table-condensed">   
      <thead>
        <tr>
          <th></th>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Stock</th>
          <th>Price</th>   
        </tr>
      </thead>

      <tbody>
        """),_display_(/*49.10*/for(p<-products) yield /*49.26*/ {_display_(Seq[Any](format.raw/*49.28*/("""
          """),format.raw/*50.11*/("""<tr>
              """),_display_(/*51.16*/if(env.resource("public/images/productImages/thumbnails/" + p.getId + ".jpg").isDefined)/*51.104*/ {_display_(Seq[Any](format.raw/*51.106*/("""
                """),format.raw/*52.17*/("""<td><img src="/assets/images/productImages/thumbnails/"""),_display_(/*52.72*/(p.getId + ".jpg")),format.raw/*52.90*/(""""/></td>
            """)))}/*53.15*/else/*53.20*/{_display_(Seq[Any](format.raw/*53.21*/("""
                """),format.raw/*54.17*/("""<td><img src="/assets/images/productImages/thumbnails/noImage.jpg"/></td>
            """)))}),format.raw/*55.14*/("""
            """),format.raw/*56.13*/("""<td class="numeric">"""),_display_(/*56.34*/p/*56.35*/.getId),format.raw/*56.41*/("""</td>
            <td><a href=""""),_display_(/*57.27*/routes/*57.33*/.ProductCtrl.productDetails(p.getId)),format.raw/*57.69*/("""">
                """),_display_(/*58.18*/p/*58.19*/.getName),format.raw/*58.27*/("""</td>
               </a>     
            <td>"""),_display_(/*60.18*/p/*60.19*/.getDescription),format.raw/*60.34*/("""</td>
            <td  class="numeric">"""),_display_(/*61.35*/p/*61.36*/.getStock),format.raw/*61.45*/("""</td>
            <td  class="numeric">€ """),_display_(/*62.37*/("%.2f".format(p.getPrice))),format.raw/*62.64*/("""</td>
          
          </tr>
        """)))}),format.raw/*65.10*/("""
      """),format.raw/*66.7*/("""</tbody>

    </table>
  </div>
</div>
""")))}))
      }
    }
  }

  def render(products:List[Product],categories:List[Category],catId:Long,filter:String,user:User,env:play.api.Environment): play.twirl.api.HtmlFormat.Appendable = apply(products,categories,catId,filter,user,env)

  def f:((List[Product],List[Category],Long,String,User,play.api.Environment) => play.twirl.api.HtmlFormat.Appendable) = (products,categories,catId,filter,user,env) => apply(products,categories,catId,filter,user,env)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Mar 06 14:38:24 GMT 2018
                  SOURCE: /home/wdd/lab3/app/views/listProducts.scala.html
                  HASH: 375700020e365aa2c463bdd8f1792cd939fd7c4c
                  MATRIX: 651->1|690->34|728->66|1124->92|1340->212|1369->216|1398->237|1437->239|1465->241|1647->396|1662->402|1719->438|1797->490|1833->510|1873->512|1909->521|1946->531|1961->537|2024->579|2078->606|2088->607|2118->615|2157->626|2205->647|2215->648|2255->667|2313->695|2345->700|2420->749|2461->781|2501->783|2537->792|2609->837|2623->842|2659->857|2695->866|2739->880|2773->887|2842->929|2857->935|2910->967|3021->1051|3048->1057|3558->1540|3590->1556|3630->1558|3669->1569|3716->1589|3814->1677|3855->1679|3900->1696|3982->1751|4021->1769|4062->1792|4075->1797|4114->1798|4159->1815|4277->1902|4318->1915|4366->1936|4376->1937|4403->1943|4462->1975|4477->1981|4534->2017|4581->2037|4591->2038|4620->2046|4695->2094|4705->2095|4741->2110|4808->2150|4818->2151|4848->2160|4917->2202|4965->2229|5038->2271|5072->2278
                  LINES: 24->1|25->2|26->3|31->4|36->4|39->7|39->7|39->7|41->9|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17|49->17|49->17|49->17|49->17|50->18|50->18|50->18|50->18|52->20|53->21|56->24|56->24|56->24|57->25|58->26|58->26|58->26|59->27|60->28|61->29|62->30|62->30|62->30|63->31|63->31|81->49|81->49|81->49|82->50|83->51|83->51|83->51|84->52|84->52|84->52|85->53|85->53|85->53|86->54|87->55|88->56|88->56|88->56|88->56|89->57|89->57|89->57|90->58|90->58|90->58|92->60|92->60|92->60|93->61|93->61|93->61|94->62|94->62|97->65|98->66
                  -- GENERATED --
              */
          