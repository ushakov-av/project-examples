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

publishMavenStyle := true




  artifact in (Compile, assembly) := {
    val art = (artifact in (Compile, assembly)).value
    art.copy(`classifier` = Some("assembly"))
  }

addArtifact(artifact in (Compile, assembly), assembly)