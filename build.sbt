name := "AkkaStream-abcd"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.4",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.4" % Test,
  "com.typesafe.akka" %% "akka-stream" % "2.5.4",
  //"com.lightbend.akka" %% "akka-stream-alpakka-sse" % "0.11",
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.16",
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.4" % Test
//
//"com.typesafe.akka" %% "akka-actor" % "2.4.18",
//"com.typesafe.akka" %% "akka-testkit" % "2.4.18" % Test,
//"com.typesafe.akka" %% "akka-stream" % "2.4.18",
////"com.lightbend.akka" %% "akka-stream-alpakka-sse" % "0.11",
//"com.typesafe.akka" %% "akka-stream-kafka" % "0.16",
//"com.typesafe.akka" %% "akka-stream-testkit" % "2.4.18" % Test,
//  "ch.qos.logback" % "logback-classic" % "1.1.3"

)
        