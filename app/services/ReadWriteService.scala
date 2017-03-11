package services

import models.User

trait ReadWriteService {

  def addUser(user: User): Boolean

  def checkUser(username: String): Boolean

  def getUser(username: String, password: String): User

}
