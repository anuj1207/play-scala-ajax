package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.ReadWriteService


class SignInController @Inject() (readWriteService: ReadWriteService) extends Controller{

  def signIn(username: String, password: String) = Action{
    if(readWriteService.checkUser(username)){
      try {
        val user = readWriteService.getUser(username, password)
        Ok(views.html.profile(user))
      }
      catch{
        case ex: Exception => Ok(views.html.signIn(ex.getMessage))
      }
    }
    else{
      Ok(views.html.signIn("User Not Found"))
    }
  }

}
