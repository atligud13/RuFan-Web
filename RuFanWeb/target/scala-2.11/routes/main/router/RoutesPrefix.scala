
// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Atli/Documents/HR/Haust2015/RuFan/RuFanWeb/conf/routes
// @DATE:Tue Oct 20 14:50:09 GMT 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
