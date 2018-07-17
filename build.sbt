name := "book-store"

version := "0.1"

scalaVersion := "2.12.4"

resolvers += Resolver.bintrayRepo("hseeberger", "maven")

val library = new {

  object Version {
    val akkaHttp = "10.0.11"
    val slick = "3.2.1"
    val flyway = "3.2.1"
    val postgresql = "9.4-1206-jdbc41"
    val scalatest = "3.0.5"
    val circe = "0.9.1"
    val akkaCirce = "1.19.0"
  }

  val akkaHttp = "com.typesafe.akka" %% "akka-http" % Version.akkaHttp
  val circeCore = "io.circe" %% "circe-core" % Version.circe
  val circeGeneric = "io.circe" %% "circe-generic" % Version.circe
  val circeParser = "io.circe" %% "circe-parser" % Version.circe
  val circeTesting = "io.circe" %% "circe-testing" % Version.circe % Test
  val akkaCirce = "de.heikoseeberger" %% "akka-http-circe" % Version.akkaCirce
  val slick = "com.typesafe.slick" %% "slick" % Version.slick
  val flyway = "org.flywaydb" % "flyway-core" % Version.flyway
  val postgresql = "org.postgresql" % "postgresql" % Version.postgresql
  val scalatest = "org.scalatest" %% "scalatest" % Version.scalatest % Test
}


libraryDependencies ++= Seq(
  library.akkaHttp,
  library.slick,
  library.flyway,
  library.postgresql,
  library.scalatest,
  library.akkaCirce,
  library.circeCore,
  library.circeGeneric,
  library.circeParser,
  library.circeTesting
)
