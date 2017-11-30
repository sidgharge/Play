
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bridgeit/Sid/Play/project3/conf/routes
// @DATE:Thu Nov 30 18:57:02 IST 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def updateTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.updateTask",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:6
    def getTasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getTasks",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + """"})
          }
        
        }
      """
    )
  
    // @LINE:18
    def getTaskById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getTaskById",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:45
    def imgBig: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.imgBig",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "imgbig"})
        }
      """
    )
  
    // @LINE:24
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteTask",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Integer]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:39
    def imgDownloadWithoutAsync: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.imgDownloadWithoutAsync",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "imgNoAsync"})
        }
      """
    )
  
    // @LINE:21
    def addTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tasks"})
        }
      """
    )
  
    // @LINE:42
    def imgSmall: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.imgSmall",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "imgsmall"})
        }
      """
    )
  
    // @LINE:30
    def simpleAsync: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.simpleAsync",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "async"})
        }
      """
    )
  
    // @LINE:36
    def imgDownload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.imgDownload",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img"})
        }
      """
    )
  
    // @LINE:48
    def readFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.readFile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "read"})
        }
      """
    )
  
    // @LINE:33
    def failureAsync: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.failureAsync",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "async/failed"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
