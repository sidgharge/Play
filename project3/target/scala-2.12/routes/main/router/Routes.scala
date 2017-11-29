
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bridgeit/Sid/Play/project3/conf/routes
// @DATE:Wed Nov 29 13:05:39 IST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.getTasks()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks""", """controllers.HomeController.getTasks()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """id<[^/]+>""", """controllers.HomeController.getTaskById(id:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks""", """controllers.HomeController.addTask()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """id<[^/]+>""", """controllers.HomeController.deleteTask(id:Integer)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tasks/""" + "$" + """id<[^/]+>""", """controllers.HomeController.updateTask(id:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """async""", """controllers.HomeController.asyncTask()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_getTasks0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_getTasks0_invoker = createInvoker(
    HomeController_0.getTasks(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getTasks",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_HomeController_getTasks2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks")))
  )
  private[this] lazy val controllers_HomeController_getTasks2_invoker = createInvoker(
    HomeController_0.getTasks(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getTasks",
      Nil,
      "GET",
      this.prefix + """tasks""",
      """Get all tasks""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_HomeController_getTaskById3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_getTaskById3_invoker = createInvoker(
    HomeController_0.getTaskById(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getTaskById",
      Seq(classOf[Integer]),
      "GET",
      this.prefix + """tasks/""" + "$" + """id<[^/]+>""",
      """Get task by id""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_HomeController_addTask4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks")))
  )
  private[this] lazy val controllers_HomeController_addTask4_invoker = createInvoker(
    HomeController_0.addTask(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addTask",
      Nil,
      "POST",
      this.prefix + """tasks""",
      """Add task""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_deleteTask5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_deleteTask5_invoker = createInvoker(
    HomeController_0.deleteTask(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteTask",
      Seq(classOf[Integer]),
      "DELETE",
      this.prefix + """tasks/""" + "$" + """id<[^/]+>""",
      """Delete task""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_updateTask6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tasks/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_updateTask6_invoker = createInvoker(
    HomeController_0.updateTask(fakeValue[Integer]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "updateTask",
      Seq(classOf[Integer]),
      "PUT",
      this.prefix + """tasks/""" + "$" + """id<[^/]+>""",
      """Update task""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_HomeController_asyncTask7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("async")))
  )
  private[this] lazy val controllers_HomeController_asyncTask7_invoker = createInvoker(
    HomeController_0.asyncTask(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "asyncTask",
      Nil,
      "GET",
      this.prefix + """async""",
      """Async test""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_getTasks0_route(params@_) =>
      call { 
        controllers_HomeController_getTasks0_invoker.call(HomeController_0.getTasks())
      }
  
    // @LINE:9
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_HomeController_getTasks2_route(params@_) =>
      call { 
        controllers_HomeController_getTasks2_invoker.call(HomeController_0.getTasks())
      }
  
    // @LINE:18
    case controllers_HomeController_getTaskById3_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_getTaskById3_invoker.call(HomeController_0.getTaskById(id))
      }
  
    // @LINE:21
    case controllers_HomeController_addTask4_route(params@_) =>
      call { 
        controllers_HomeController_addTask4_invoker.call(HomeController_0.addTask())
      }
  
    // @LINE:24
    case controllers_HomeController_deleteTask5_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_deleteTask5_invoker.call(HomeController_0.deleteTask(id))
      }
  
    // @LINE:27
    case controllers_HomeController_updateTask6_route(params@_) =>
      call(params.fromPath[Integer]("id", None)) { (id) =>
        controllers_HomeController_updateTask6_invoker.call(HomeController_0.updateTask(id))
      }
  
    // @LINE:30
    case controllers_HomeController_asyncTask7_route(params@_) =>
      call { 
        controllers_HomeController_asyncTask7_invoker.call(HomeController_0.asyncTask())
      }
  }
}
