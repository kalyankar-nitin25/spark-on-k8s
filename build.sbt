
name := "spark-on-k8s"

version := "3.1.2"

scalaVersion := "2.12.14"

val sparkVersion = "3.1.2"

assemblyMergeStrategy in assembly := {
  case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case "application.conf" => MergeStrategy.concat
  case x => MergeStrategy.first
}

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion //% "provided"
)