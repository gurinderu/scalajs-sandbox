package hello.world

import hello.world.components.material.{Colors, MuiThemeProvider, Styles}
import hello.world.components.router.BrowserRouter
import org.scalajs.dom
import slinky.hot
import slinky.web.ReactDOM

import scala.scalajs.LinkingInfo
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.Dynamic._

object Main {

  //make theme configurable
  private val theme = Styles.createMuiTheme(literal(
    palette = literal(
      primary = Colors.indigo,
      secondary = Colors.indigo
    )))

  @JSExportTopLevel("entrypoint.main")
  def main(): Unit = {
    if (LinkingInfo.developmentMode) {
      hot.initialize()
    }

    val container = Option(dom.document.getElementById("root")).getOrElse {
      val elem = dom.document.createElement("div")
      elem.id = "root"
      dom.document.body.appendChild(elem)
      elem
    }


    ReactDOM.render(MuiThemeProvider(theme = theme)(BrowserRouter(Layout())), container)
  }
}
