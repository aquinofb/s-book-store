package com.felipe.web.routes

import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.server.{Directives, Route}

case class ProductRoutes() extends BaseRoute {
  import Directives._

  def routes: Route = index

  private val index: Route = {
    path("products") {
      get {
        complete("Products")
      }
    }
  }
}
