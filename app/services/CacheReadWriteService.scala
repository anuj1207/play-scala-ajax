package services
import javax.inject.Inject
import models.User
import play.api.cache.CacheApi


class CacheReadWriteService @Inject() (cache: CacheApi) extends ReadWriteService{

  override def checkUser(username: String): Boolean = {
    cache.get[User](username) match{
      case Some(_) => true
      case None => false
    }
  }

  override def addUser(user: User): Boolean = {
    cache.set(user.username,user)
    true
  }

  override def getUser(username: String, password: String): User = {
    cache.get[User](username) match {
      case Some(user) =>
        if(user.password == password) user else throw new Exception("Password incorrect")
      case None => throw new Exception("User not found")
    }
  }

}
