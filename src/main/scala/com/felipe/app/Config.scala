package com.felipe.app

import com.typesafe.config.ConfigFactory

object Config {
  private val config = ConfigFactory.load()

  object server {
    private val c = config.getConfig("server")
    val host = c.getString("host")
    val port = c.getInt("port")
  }

  object database {
    private val c = config.getConfig("database")

    val driver: String = c.getString("driver")
    val host: String = c.getString("host")
    val name: String = c.getString("properties.name")
    val user: String = c.getString("properties.user")
    val password: String = c.getString("properties.password")
  }

}
