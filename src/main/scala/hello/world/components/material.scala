package hello.world.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object material {

  @JSImport("@material-ui/core", JSImport.Default)
  @js.native
  object Core extends js.Object {
    val CssBaseline: js.Object = js.native
    val Button: js.Object = js.native
  }


  object CssBaseline extends ExternalComponentNoProps {
    override val component = Core.CssBaseline
  }

  object Button extends ExternalComponent {

    case class Props(children: ReactElement,color:String="primary")

    override val component = Core.Button
  }

}
