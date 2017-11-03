lazy val root = (project in file(".")).
  settings(
    name := "SBT_Example",
    scalaVersion := "2.11.4"
  )

publishTo := {
  if (isSnapshot.value)
    Some("Artifactory Snapshots" at "http://artifactory-systems-private-1a/artifactory/libs-snapshot")
  else
    Some("Artifactory Nexus" at "http://artifactory-systems-private-1a/artifactory/libs-release")
}

//publishTo := Some("Artifactory Nexus" at "http://artifactory-systems-private-1a/artifactory/libs-release")

credentials += Credentials(new File("credentials.properties"))

libraryDependencies += "org.apache.derby" % "derby" % "10.4.1.3"
