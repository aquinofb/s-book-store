package com.felipe.db

import org.flywaydb.core.Flyway

class Migrations(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val flyway = new Flyway()
  flyway.setDataSource(jdbcUrl, dbUser, dbPassword)

  def migrateDatabase = {
    flyway.migrate()
    this
  }

  def dropDatabase = {
    flyway.clean()
    this
  }

}
