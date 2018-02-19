name := "book-store"

version := "0.1"

scalaVersion := "2.12.4"

val library = new {

  object Version {
    val akkaHttp = "10.0.11"
    val slick = "3.2.1"
    val flyway = "3.2.1"
  }

  val akkaHttp = "com.typesafe.akka" %% "akka-http" % Version.akkaHttp
  val slick = "com.typesafe.slick" %% "slick" % Version.slick
  val flyway = "org.flywaydb" % "flyway-core" % Version.flyway
}


libraryDependencies ++= Seq(
  library.akkaHttp,
  library.slick,
  library.flyway
)
