name          := "kafkaProducer"
organization  := "any"
description   := "kafkaProducer"
version       := "1.0.0"
scalaVersion  := "2.11.11"
scalacOptions := Seq("-deprecation", "-unchecked", "-encoding", "utf8", "-Xlint")
excludeFilter in unmanagedSources := (HiddenFileFilter || "*-script.scala")
unmanagedResourceDirectories in Compile += baseDirectory.value / "conf"
unmanagedResourceDirectories in Test += baseDirectory.value / "conf"

//This is important for some programs to read input from stdin
connectInput in run := true

// Must run Spark tests sequentially because they compete for port 4040!
parallelExecution in Test := false

val sparkVersion   = "2.3.0"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.0",
  "org.apache.kafka" % "kafka-clients" % "2.0.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)