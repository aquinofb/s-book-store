package com.felipe.db

import com.felipe.app.Config.database
import slick.jdbc.{JdbcProfile, PostgresProfile}
import slick.jdbc.PostgresProfile.api.Database
import slick.util.AsyncExecutor

case class DbSettings(url: String, user: String, password: String, dbName: String, driver: String)

object CoreDatabase {
  lazy val profile: PostgresProfile = slick.jdbc.PostgresProfile
  type Database = profile.backend.Database

  def settings(databaseName: Option[String]): DbSettings = {
    val dbName = databaseName.getOrElse(database.name)

    DbSettings(
      s"jdbc:postgresql://${database.host}/$dbName",
      database.user,
      database.password,
      dbName,
      database.driver
    )
  }

  def apply(databaseName: Option[String] = None): profile.backend.Database = {
    val dbSettings = settings(databaseName)
    profile.backend.Database.forURL(
      url = dbSettings.url,
      user = dbSettings.user,
      password = dbSettings.password,
      executor = AsyncExecutor.default()
    )
  }
}
