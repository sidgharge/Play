
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bridgeit/Sid/Play/project3/conf/routes
// @DATE:Thu Nov 30 18:57:02 IST 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def updateTask(id:Integer): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:6
    def getTasks(): Call = {
    
      () match {
      
        // @LINE:6
        case ()  =>
          
          Call("GET", _prefix)
      
      }
    
    }
  
    // @LINE:18
    def getTaskById(id:Integer): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:45
    def imgBig(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "imgbig")
    }
  
    // @LINE:24
    def deleteTask(id:Integer): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "tasks/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Integer]].unbind("id", id)))
    }
  
    // @LINE:39
    def imgDownloadWithoutAsync(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "imgNoAsync")
    }
  
    // @LINE:21
    def addTask(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tasks")
    }
  
    // @LINE:42
    def imgSmall(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "imgsmall")
    }
  
    // @LINE:30
    def simpleAsync(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "async")
    }
  
    // @LINE:36
    def imgDownload(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "img")
    }
  
    // @LINE:48
    def readFile(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "read")
    }
  
    // @LINE:33
    def failureAsync(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "async/failed")
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
