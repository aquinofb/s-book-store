package com.felipe.app

import com.felipe.db.CoreDatabase
import org.flywaydb.core.{Flyway => CoreFlyway}

object Migrations {
  def run: Boolean = {
    Flyway(None).migrate()
    true
  }
}

object Flyway {
  def apply(databaseName: Option[String]): CoreFlyway = {
    val settings = CoreDatabase.settings(databaseName)
    val dbMigrationLocation = "classpath:db.migration"

    val flyway = new CoreFlyway

    flyway.setDataSource(settings.url, settings.user, settings.password)

    flyway.setSchemas(databaseName.get)
    flyway.setLocations(dbMigrationLocation)
    flyway
  }
}
