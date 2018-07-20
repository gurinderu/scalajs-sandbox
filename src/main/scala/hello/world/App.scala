package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("css/App.css", JSImport.Default)
@js.native
object AppCSS extends js.Object

@JSImport("images/logo.svg", JSImport.Default)
@js.native
object ReactLogo extends js.Object

@react class App extends StatelessComponent {
  type Props = Unit

  private val css = AppCSS

  def render(): ReactElement = {
    div(className := "App")(
      header(className := "App-header")(
        img(src := ReactLogo.asInstanceOf[String], className := "App-logo", alt := "logo"),
        h1(className := "App-title")("Welcome to React (with Scala.js!)")
      ),
      p(className := "App-intro")(
        "To get started, edit ", code("App.scala"), " and save to reload."
      ),
      p(className := "Azazaa")(
        "zazaaza"
      )
    )
  }
}
