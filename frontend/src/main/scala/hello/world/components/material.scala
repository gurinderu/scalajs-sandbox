package hello.world.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.{*, a}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

object material {

  @JSImport("@material-ui/core/styles", JSImport.Default)
  @js.native
  object Styles extends js.Object {

    val MuiThemeProvider: js.Object = js.native

    def createMuiTheme(style: js.Object = null): js.Object = js.native

    def withTheme(): js.Function1[js.Object, js.Object] = js.native

    def withStyles(
        styles: js.Object | js.Function1[js.Object, js.Object],
        options: js.Object = null): js.Function1[js.Object, js.Object] =
      js.native
  }

  @JSImport("@material-ui/core/colors", JSImport.Default)
  @js.native
  object Colors extends js.Object {
    val indigo: js.Object = js.native
    val green: js.Object = js.native
  }

  object CssBaseline extends ExternalComponentNoProps {
    @JSImport("@material-ui/core/CssBaseline", JSImport.Default)
    @js.native
    object Import extends js.Object

    override val component = Styles.withTheme()(Import)
  }

  @react object Button extends ExternalComponent {

    @JSImport("@material-ui/core/Button", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(color: String = "primary")

    override val component = Styles.withTheme()(Import)
  }
  @react object Drawer extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/Drawer", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(anchor: String = "left",
                     variant: String = "permanent",
                     classes: js.Object = null,
                     open: Boolean = false)

    override val component = Styles.withTheme()(Import)
  }

  @react object AppBar extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/AppBar", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props()

    override val component = Styles.withTheme()(Import)
  }

  object Toolbar extends ExternalComponentNoProps {

    @JSImport("@material-ui/core/Toolbar", JSImport.Default)
    @js.native
    object Import extends js.Object

    override val component = Styles.withTheme()(Import)
  }

  @react object Divider extends ExternalComponent {

    @JSImport("@material-ui/core/Divider", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props()

    override val component = Styles.withTheme()(Import)
  }

  @react object Typography extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/Typography", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(variant: String = "title", color: String = "inherit")

    override val component = Styles.withTheme()(Import)

  }
  @react object IconButton extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/IconButton", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(color: String = "default",
                     disabled: Boolean = false,
                     onClick: () => Unit = () => ())

    override val component = Styles.withTheme()(Import)

  }

  @react object MenuItem extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/MenuItem", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props()

    override val component = Styles.withTheme()(Import)

  }

  @react object Hidden extends ExternalComponentWithAttributes[*.tag.type] {

    @JSImport("@material-ui/core/Hidden", JSImport.Default)
    @js.native
    object Import extends js.Object

    val mdUp = new CustomAttribute[Unit]("mdup")
    val smDown = new CustomAttribute[Unit]("smdown")

    case class Props(implementation: String = "js")

    override val component = Styles.withTheme()(Import)

  }
  @react object MuiThemeProvider extends ExternalComponent {

    case class Props(theme: js.Object = null)

    override val component = Styles.MuiThemeProvider
  }

  @react object List extends ExternalComponent {

    @JSImport("@material-ui/core/List", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(component: String = null)

    override val component = Styles.withTheme()(Import)
  }

  @react object ListItem extends ExternalComponentWithAttributes[a.tag.type] {

    @JSImport("@material-ui/core/ListItem", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(button: Boolean = false, component: String = null)

    override val component = Styles.withTheme()(Import)
  }

  @react object ListItemText extends ExternalComponent {

    @JSImport("@material-ui/core/ListItemText", JSImport.Default)
    @js.native
    object Import extends js.Object

    case class Props(primary: ReactElement = null)

    override val component = Styles.withTheme()(Import)
  }

  object Icon extends ExternalComponentNoProps {

    @JSImport("@material-ui/core/Icon", JSImport.Default)
    @js.native
    object Import extends js.Object

    override val component = Styles.withTheme()(Import)
  }

  object MenuIcon extends ExternalComponentNoProps {

    @JSImport("@material-ui/icons/Menu", JSImport.Default)
    @js.native
    object Import extends js.Object

    override val component = Styles.withTheme()(Import)
  }

}
