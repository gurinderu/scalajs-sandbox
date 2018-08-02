package hello.world.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{*, a}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object router {

  @JSImport("react-router-dom", JSImport.Default)
  @js.native
  object ReactRouterDOM extends js.Object {
    val Route: js.Object = js.native
    val BrowserRouter: js.Object = js.native
    val Router: js.Object = js.native
    val NavLink: js.Object = js.native
    val Link: js.Object = js.native
    val Switch: js.Object = js.native
  }

  @react object Route extends ExternalComponent {

    @JSImport("react-router-dom", "Route")
    @js.native
    object Import extends js.Object

    case class Props(component: ReactComponentClass,
                     path: String = null,
                     exact: Boolean = false)

    override val component = Import
  }

  object BrowserRouter extends ExternalComponentNoPropsWithAttributes {

    @JSImport("react-router-dom", "BrowserRouter")
    @js.native
    object Import extends js.Object

    override val component = Import
  }

  @react object Router extends ExternalComponent {

    @JSImport("react-router-dom", "Router")
    @js.native
    object Import extends js.Object

    case class Props(children: ReactElement)

    override val component = Import
  }
  @react object NavLink extends ExternalComponentWithAttributes[a.tag.type] {

    @JSImport("react-router-dom", "NavLink")
    @js.native
    object Import extends js.Object

    case class Props(to: String)

    override val component = Import
  }

  @react object Link extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("react-router-dom", "Link")
    @js.native
    object Import extends js.Object

    case class Props(to: String)

    override val component = Import
  }

  object Switch extends ExternalComponentNoProps {

    @JSImport("react-router-dom", "Switch")
    @js.native
    object Import extends js.Object

    override val component = Import
  }

}
