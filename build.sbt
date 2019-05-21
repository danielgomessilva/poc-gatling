import Dependencies._

enablePlugins(GatlingPlugin, AssemblyPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.8",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "gatling",
    libraryDependencies ++= gatling
  )
  .settings(
    inConfig(Test)(
      baseAssemblySettings ++ Seq(
        assemblyMergeStrategy in assembly := {
          case PathList(ps@_*) if ps.last endsWith "io.netty.versions.properties" => MergeStrategy.first
          case PathList(ps@_*) if ps.last endsWith "gatling-version.properties" => MergeStrategy.first
          case PathList(ps@_*) if ps.last endsWith "module-info.class" => MergeStrategy.first
          case other => (assemblyMergeStrategy in assembly).value(other)
        },
        mainClass in assembly := Some("io.gatling.app.Gatling"),
        assemblyJarName in assembly := name.value + "-test-" + version.value + ".jar"
      )
    )
  )
