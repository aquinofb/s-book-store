package com.felipe.routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{Directives, Route}

class HealthRoutes extends Directives{
  val routes: Route =
    path("health") {
      get {
        complete("Healthy")
      }
    }
}
