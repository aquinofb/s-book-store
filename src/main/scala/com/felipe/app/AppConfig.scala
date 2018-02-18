package com.felipe.app

import com.typesafe.config.ConfigFactory

object AppConfig {
  private val config = ConfigFactory.load()

  object server {
    private val c = config.getConfig("server")
    val host = c.getString("host")
    val port = c.getInt("port")
  }

  object database {
    private val c = config.getConfig("database")
  }

}
