scalaVersion := "2.12.6"

lazy val frontend = project
  .in(file("frontend"))
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    name:="scalajs-sandbox-frontend",
    npmDependencies in Compile ++= Seq(
      "react" -> "16.4.1",
      "react-dom" -> "16.4.1",
      "react-proxy" -> "1.1.8",
      "@material-ui/core" -> "1.4.0",
      "@material-ui/icons" -> "1.1.0",
      "react-router-dom" -> "4.3.1",
      "react-loadable" -> "5.4.0"
    ),
    npmDevDependencies in Compile ++= Seq(
      "file-loader" -> "1.1.11",
      "style-loader" -> "0.21.0",
      "css-loader" -> "1.0.0",
      "html-webpack-plugin" -> "3.2.0",
      "copy-webpack-plugin" -> "4.5.2",
      "webpack-merge" -> "4.1.3",
      "webpack-bundle-analyzer" -> "2.13.1",
      "scalajs-friendly-source-map-loader" -> "0.1.3"
    ),
    libraryDependencies ++= Seq(
      "me.shadaj" %%% "slinky-web" % "0.4.3",
      "me.shadaj" %%% "slinky-hot" % "0.4.3",
      "me.shadaj" %%% "slinky-scalajsreact-interop" % "0.4.3",
      compilerPlugin("org.scalameta" % "paradise" % "3.0.0-M11" cross CrossVersion.full)
    ),
    libraryDependencies in Test ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.0.5"
    ),
    version in webpack := "4.16.1",
    version in startWebpackDevServer := "3.1.4",
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    webpackConfigFile in fastOptJS := Some(
      baseDirectory.value / "webpack-fastopt.config.js"),
    webpackConfigFile in fullOptJS := Some(
      baseDirectory.value / "webpack-opt.config.js"),
    emitSourceMaps in fullOptJS := false,
    emitSourceMaps in fastOptJS := true,
    webpackConfigFile in Test := Some(
      baseDirectory.value / "webpack-core.config.js"),

    webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot"),
    webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()
  )







