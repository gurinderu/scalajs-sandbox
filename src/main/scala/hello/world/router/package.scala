package hello.world

import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.core._
import slinky.web.html.{*, a}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object router {

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

    case class Props(component: ReactComponentClass, path: String = null, exact: Boolean = false)

    override val component = ReactRouterDOM.Route
  }

  object BrowserRouter extends ExternalComponentNoPropsWithAttributes {

    override val component = ReactRouterDOM.BrowserRouter
  }

  @react object Router extends ExternalComponent {

    case class Props(children: ReactElement)

    override val component = ReactRouterDOM.Router
  }


  @react object NavLink extends ExternalComponentWithAttributes[a.tag.type] {

    case class Props(to: String)

    override val component = ReactRouterDOM.NavLink
  }

  @react object Link extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props(to: String)

    override val component = ReactRouterDOM.Link
  }

   object Switch extends ExternalComponentNoProps {
    override val component = ReactRouterDOM.Switch
  }

}
