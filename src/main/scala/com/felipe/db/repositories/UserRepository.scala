package com.felipe.db.repositories

import com.felipe.db.CoreDatabase.Database
import com.felipe.domain.accounts.User
import slick.lifted.TableQuery

import scala.concurrent.Future

case class UserRepository(implicit db: Database) {

  def all: Future[Seq[User]] = ???

//  private lazy val users = TableQuery[User]
}
