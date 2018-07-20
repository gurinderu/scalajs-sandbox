package hello.world.components

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.{React, ReactElement}
import slinky.web.html.{*, a}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import js.|

object material {

  @JSImport("@material-ui/core", JSImport.Default)
  @js.native
  object Core extends js.Object {
    val CssBaseline: js.Object = js.native
    val Button: js.Object = js.native
    val Drawer: js.Object = js.native
    val AppBar: js.Object = js.native
    val Toolbar: js.Object = js.native
    val Typography: js.Object = js.native
    val Divider: js.Object = js.native
    val MenuItem: js.Object = js.native
    val IconButton: js.Object = js.native
    val Icon: js.Object = js.native
    val Hidden: js.Object = js.native
    val List: js.Object = js.native
    val ListItem: js.Object = js.native
    val ListItemText: js.Object = js.native
  }

  @JSImport("@material-ui/core/styles", JSImport.Default)
  @js.native
  object Styles extends js.Object {

    val MuiThemeProvider: js.Object = js.native

    def createMuiTheme(style: js.Object = null): js.Object = js.native

    def withTheme(): js.Function1[js.Object, js.Object] = js.native

    def withStyles(styles: js.Object | js.Function1[js.Object, js.Object], options: js.Object = null): js.Function1[js.Object, js.Object] = js.native
  }

  @JSImport("@material-ui/core/colors", JSImport.Default)
  @js.native
  object Colors extends js.Object {
    val indigo: js.Object = js.native
    val green: js.Object = js.native
  }

  @JSImport("@material-ui/icons", JSImport.Default)
  @js.native
  object Icons extends js.Object {
    val Menu: js.Object = js.native
  }


  object CssBaseline extends ExternalComponentNoProps {
    override val component = Styles.withTheme()(Core.CssBaseline)
  }

  @react object Button extends ExternalComponent {

    case class Props(color: String = "primary")

    override val component = Styles.withTheme()(Core.Button)
  }


  @react object Drawer extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props(anchor: String = "left", variant: String = "permanent", classes: js.Object = null, open: Boolean = false)

    override val component = Styles.withTheme()(Core.Drawer)
  }

  @react object AppBar extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props()

    override val component = Styles.withTheme()(Core.AppBar)
  }

  object Toolbar extends ExternalComponentNoProps {

    override val component = Styles.withTheme()(Core.Toolbar)
  }

  @react object Divider extends ExternalComponent {

    case class Props()

    override val component = Styles.withTheme()(Core.Divider)
  }

  @react object Typography extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props(variant: String = "title", color: String = "inherit")

    override val component = Styles.withTheme()(Core.Typography)

  }


  @react object IconButton extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props(color: String = "default", disabled: Boolean = false, onClick: () => Unit = () => ())

    override val component = Styles.withTheme()(Core.IconButton)

  }

  @react object MenuItem extends ExternalComponentWithAttributes[*.tag.type] {

    case class Props()

    override val component = Styles.withTheme()(Core.MenuItem)

  }

  @react object Hidden extends ExternalComponentWithAttributes[*.tag.type] {


    val mdUp = new CustomAttribute[Unit]("mdup")
    val smDown = new CustomAttribute[Unit]("smdown")

    case class Props(implementation: String = "js")

    override val component = Styles.withTheme()(Core.Hidden)

  }


  @react object MuiThemeProvider extends ExternalComponent {

    case class Props(theme: js.Object = null)

    override val component = Styles.MuiThemeProvider
  }

  @react object List extends ExternalComponent {

    case class Props(component: String = null)

    override val component = Styles.withTheme()(Core.List)
  }

  @react object ListItem extends ExternalComponentWithAttributes[a.tag.type] {

    case class Props(button: Boolean = false, component: String = null)

    override val component = Styles.withTheme()(Core.ListItem)
  }

  @react object ListItemText extends ExternalComponent {

    case class Props(primary: ReactElement = null)

    override val component = Styles.withTheme()(Core.ListItemText)
  }


  object Icon extends ExternalComponentNoProps {
    override val component = Styles.withTheme()(Core.Icon)
  }

  object MenuIcon extends ExternalComponentNoProps {
    override val component = Styles.withTheme()(Icons.Menu)
  }

}
