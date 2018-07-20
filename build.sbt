enablePlugins(ScalaJSBundlerPlugin)
addCompilerPlugin("org.scalameta" % "paradise" % "3.0.0-M11" cross CrossVersion.full)

name := "test"
scalaVersion := "2.12.6"

npmDependencies in Compile += "react" -> "16.4.1"
npmDependencies in Compile += "react-dom" -> "16.4.1"
npmDependencies in Compile += "react-proxy" -> "1.1.8"

npmDevDependencies in Compile += "file-loader" -> "1.1.11"
npmDevDependencies in Compile += "style-loader" -> "0.21.0"
npmDevDependencies in Compile += "css-loader" -> "1.0.0"
npmDevDependencies in Compile += "html-webpack-plugin" -> "3.2.0"
npmDevDependencies in Compile += "copy-webpack-plugin" -> "4.5.2"
npmDevDependencies in Compile += "webpack-merge" -> "4.1.3"
npmDevDependencies in Compile += "@material-ui/core" -> "1.4.0"
npmDevDependencies in Compile += "@material-ui/icons" -> "1.1.0"

libraryDependencies += "me.shadaj" %%% "slinky-web" % "0.4.3"
libraryDependencies += "me.shadaj" %%% "slinky-hot" % "0.4.3"
libraryDependencies += "me.shadaj" %%% "slinky-scalajsreact-interop" % "0.4.3"
libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.5" % Test

scalacOptions += "-P:scalajs:sjsDefinedByDefault"

version in webpack := "4.16.1"
version in startWebpackDevServer:= "3.1.4"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack-opt.config.js")

webpackConfigFile in Test := Some(baseDirectory.value / "webpack-core.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()

requiresDOM in Test := true
