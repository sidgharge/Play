
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bridgeit/Sid/Play/project3/conf/routes
// @DATE:Fri Dec 01 18:53:37 IST 2017


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
