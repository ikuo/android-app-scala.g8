import sbt._
import Keys._
import AndroidKeys._

object General {
  val settings = Defaults.defaultSettings ++ Seq(
    name := "$name$",
    version := "$version$",
    versionCode := $versionCode$,
    scalaVersion := "$scalaVersion$",
    platformName := "android-$targetSdkVersion$",
    keyalias := "alias",
    useProguard := true
  )

  val resolvers = Seq(
    "Local Maven Repository" at ("file://" + Path.userHome.absolutePath + "/.m2/repository")
  )

  val libraryDependencies = Seq(
    "android.support" % "compatibility-v4" % "19.+",
    "android.support" % "compatibility-v7-appcompat" % "19.+"//,
    //apklib("android.support" % "compatibility-v7-appcompat" % "19.+")
  )

  val scalacOptions = Seq("-feature")

  val proguardSettings = Seq (
    useProguard in Android := true,
    proguardOption in Android := "-dontnote **"
  )

  lazy val fullAndroidSettings =
    General.settings ++
    AndroidProject.androidSettings ++
    TypedResources.settings ++
    proguardSettings ++
    AndroidManifestGenerator.settings ++
    AndroidMarketPublish.settings ++ Seq (
      keyalias in Android := "$keyalias$"
    )
}

object AndroidBuild extends Build {
  lazy val main = Project(
    "$name;format="normalize"$",
    file("."),
    settings = General.fullAndroidSettings
  )
}
