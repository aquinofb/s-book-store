package com.felipe.web.routes

import akka.http.scaladsl.server.Route

trait BaseRoute {
  def routes: Route
}
