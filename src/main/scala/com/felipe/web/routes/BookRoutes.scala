package com.felipe.web.routes

import akka.http.scaladsl.server.{Directives, Route}
import com.felipe.domain.bookshelf.Bookshelf
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

case class BookRoutes(implicit bookshelf: Bookshelf) extends BaseRoute {
  import Directives._
  import FailFastCirceSupport._
  import io.circe.generic.auto._

  def routes: Route = index

  private val index: Route = {
    (get & path("books")) {
      complete(bookshelf.getAllBooks)
    }
  }
}
