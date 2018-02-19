package com.felipe.web

import akka.http.scaladsl.server.{Directives, Route}
import com.felipe.db.CoreDatabase.Database
import com.felipe.db.repositories.{BookRepository, CategoryRepository, UserRepository}
import com.felipe.domain.accounts.Accounts
import com.felipe.domain.bookshelf.Bookshelf
import com.felipe.web.routes.{BookRoutes, HealthRoutes}

import scala.concurrent.ExecutionContext

case class Router(implicit db: Database, executionContext: ExecutionContext) {
  import Directives._

  implicit lazy val bookRepository: BookRepository = new BookRepository
  implicit lazy val categoryRepository: CategoryRepository = new CategoryRepository
  implicit lazy val bookshelf: Bookshelf = new Bookshelf

  implicit lazy val userRepository: UserRepository = new UserRepository
  implicit lazy val accounts: Accounts = new Accounts

//TODO: create pipeline and namespace concept
  def routes: Route = {
    HealthRoutes().routes ~
      BookRoutes().routes
  }

}
