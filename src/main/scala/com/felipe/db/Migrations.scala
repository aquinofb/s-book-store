package com.felipe.db

import org.flywaydb.core.{Flyway => CoreFlyway}

object Flyway {
  def apply(databaseName: Option[String]): CoreFlyway = {
    val settings = CoreDatabase.settings(databaseName)
    val dbMigrationLocation = "classpath:db.migration"

    val flyway = new CoreFlyway

    flyway.setDataSource(settings.url, settings.user, settings.password)

    flyway.setSchemas(settings.dbName)
    flyway.setLocations(dbMigrationLocation)
    flyway
  }
}

object Migrations extends App {
  Flyway(None).migrate
}