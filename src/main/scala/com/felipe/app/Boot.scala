package com.felipe.app

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{HttpApp, Route}
import akka.stream.ActorMaterializer
import com.felipe.db.CoreDatabase
import com.felipe.db.CoreDatabase.Database
import com.felipe.web.Router

import scala.concurrent.ExecutionContext

object Boot extends HttpApp with App {
  implicit val system: ActorSystem = ActorSystem("bookstore")
  implicit val materializer: ActorMaterializer = ActorMaterializer.create(system)
  implicit val executionContext: ExecutionContext = system.dispatcher

//  Migrations.run

  implicit lazy val db: Database = CoreDatabase()
  override protected def routes: Route = Router().routes

  startServer(Config.server.host, Config.server.port)
}
