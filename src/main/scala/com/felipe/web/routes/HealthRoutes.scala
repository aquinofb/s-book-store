package com.felipe.web.routes

import akka.http.scaladsl.server.{Directives, Route}
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport

case class HealthRoutes() extends BaseRoute {
  import Directives._
  import FailFastCirceSupport._
  import io.circe.generic.auto._

  def routes: Route = index

  private val index: Route = {
    (get & path("health")) {
      complete("Healthy")
    }
  }
}
