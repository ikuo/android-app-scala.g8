import sbt._
import Keys._
import sbtandroid.AndroidPlugin._

object General {
  val baseSettings = {
    name := "$name$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    platformName := "android-$targetSdkVersion$",
    keyalias := "$keyalias$",
    useProguard := true
  }

  val resolvers = Seq(
    "Local Maven Repository" at ("file://" + Path.userHome.absolutePath + "/.m2/repository")
  )

  val libraryDependencies = Seq(
    "android.support" % "compatibility-v4" % "19.+",
    "android.support" % "compatibility-v7-appcompat" % "19.+",
    apklib("android.support" % "compatibility-v7-appcompat" % "19.+")
  )

  val scalacOptions = Seq("-feature")

  val proguardOptions = Seq(
    "-keep class android.support.v4.app.** { *; }",
    "-keep interface android.support.v4.app.** { *; }",

    "-keep class android.support.v7.app.** { *; }",
    "-keep interface android.support.v7.app.** { *; }",
    "-keep class android.support.v7.appcompat.** { *; }",
    "-keep interface android.support.v7.appcompat.** { *; }"
  )
}

object AndroidBuild extends Build {
  lazy val main = AndroidProject(
    id       = "$name;format="normalize"$",
    base     = file("."),
    settings = General.baseSettings ++ Seq(
      resolvers           ++= General.resolvers,
      libraryDependencies ++= General.libraryDependencies,
      scalacOptions       ++= General.scalacOptions,
      proguardOptions     :=  General.proguardOptions
    )
  )
}
