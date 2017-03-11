package controllers

import com.google.inject.Inject
import models.User
import play.api.mvc.{Action, Controller}
import services.ReadWriteService


class SignUpController @Inject() (readWriteService: ReadWriteService) extends Controller{

  def signUp(name: String, username: String, password: String, repassword: String,
             gender: String, age: Int) = Action{
    val newUser = User(username, password, name, gender, age)
    if(!readWriteService.checkUser(username)){
      readWriteService.addUser(newUser)
      Ok(views.html.profile(newUser))
    }
    else{
      Ok(views.html.signUp("User already exists"))
    }
  }

}
