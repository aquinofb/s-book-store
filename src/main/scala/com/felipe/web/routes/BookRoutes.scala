package com.felipe.web.routes

import akka.http.scaladsl.server.{Directives, Route}
import com.felipe.domain.bookshelf.Bookshelf
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

case class BookCreate(title: String, genre: String, year: String)

case class BookRoutes(implicit bookshelf: Bookshelf) extends BaseRoute {
  import Directives._
  import FailFastCirceSupport._
  import io.circe.generic.auto._

  def routes: Route =
    (pathPrefix("books") & pathEndOrSingleSlash) {
      index ~
        create
    }

  private val index: Route = {
    get {
      parameters('title.as[String].?, 'genre.as[String].?, 'year.as[Int].?) { (name, genre, year) =>
        complete(s"$name and $genre and $year")
      }
    }
  }

  private val create: Route = {
    (post & entity(as[BookCreate])) { bookCreate =>
      complete(s"${bookCreate.title}")
    }
  }
}
