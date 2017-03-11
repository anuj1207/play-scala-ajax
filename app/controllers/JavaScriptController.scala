package controllers


import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter


class JavaScriptController extends Controller{

  def javascriptRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.HomeController.index,
        routes.javascript.HomeController.signUpForm,
        routes.javascript.HomeController.signInForm,
        routes.javascript.SignUpController.signUp,
        routes.javascript.SignInController.signIn
      )
    ).as("text/javascript")
  }

}
