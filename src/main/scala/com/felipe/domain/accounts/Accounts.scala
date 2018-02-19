package com.felipe.domain.accounts

import com.felipe.db.repositories.UserRepository

import scala.concurrent.Future

case class Accounts(implicit userRepository: UserRepository) {

  def getAllUsers: Future[Seq[User]] = userRepository.all
}
