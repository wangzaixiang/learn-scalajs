enablePlugins(ScalaJSPlugin)

name := "Scala.js Tutorial"

scalaVersion := "2.11.8"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.0"

libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.0"

libraryDependencies += "org.scala-lang.modules" %% "scala-async" % "0.9.5"

jsDependencies += RuntimeDOM

scalaJSUseRhino in Global := false