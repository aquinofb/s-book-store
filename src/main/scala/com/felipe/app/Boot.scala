package com.felipe.app

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{HttpApp, Route}
import akka.stream.ActorMaterializer
import com.felipe.routes.HealthRoutes

import scala.concurrent.ExecutionContext

object Boot extends HttpApp with App {

  override protected def routes: Route = new HealthRoutes().routes

  implicit val system: ActorSystem = ActorSystem("s_book_store")
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)
  implicit val executionContext: ExecutionContext = system.dispatcher

  startServer(AppConfig.server.host, AppConfig.server.port)
}
