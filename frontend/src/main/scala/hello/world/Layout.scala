package hello.world

import hello.world.components.material._
import hello.world.router.{Link, Route, Switch}
import slinky.core.ComponentWrapper
import slinky.core.facade.ReactElement
import slinky.readwrite.{Reader, Writer}
import slinky.web.html._
import slinky.web.html.style
import scala.scalajs.js
import scala.scalajs.js.ConstructorTag
import scala.scalajs.js.Dynamic._

object Layout extends ComponentWrapper {

  type Props = Unit

  case class State(mobileOpen: Boolean)

  private val drawerWidth = 240

  trait JsProps extends js.Object {
    def classes: Classes

    def theme: Theme
  }

  trait Classes extends js.Object {
    def root: String

    def appBar: String

    def navIconHide: String

    def drawerPaper: String

    def content: String

    def toolbar: String

    def link: String
  }

  trait Theme extends js.Object {
    def breakpoints: Breakpoints

    def palette: Palette

    def spacing: Spacing

    def mixins: Mixins

    def direction: String
  }

  trait Mixins extends js.Object {
    def toolbar: js.Object
  }

  trait Spacing extends js.Object {
    def unit: Int
  }

  trait Palette extends js.Object {
    def background: Background
  }

  trait Background extends js.Object {
    def default: String
  }

  trait Breakpoints extends js.Object {
    def up(value: String): String
  }

  private val styles: js.Function1[Theme, js.Object] = (theme: Theme) =>
    literal(
      link = literal(textDecoration = "none"),
      root = literal(
        flexGrow = 1,
        zIndex = 1,
        overflow = "hidden",
        position = "relative",
        display = "flex",
        width = "100%",
        height = "100%"
      ),
      appBar = literal(
        "position" -> "absolute",
        "marginLeft" -> drawerWidth,
        theme.breakpoints.up("md") -> literal(
          width = s"calc(100% - ${drawerWidth}px)")
      ),
      navIconHide =
        literal(theme.breakpoints.up("md") -> literal(display = "none")),
      drawerPaper = literal(
        theme.breakpoints.up("md") -> literal(position = "relative"),
        "width" -> drawerWidth
      ),
      content = literal(
        flexGrow = 1,
        backgroundColor = theme.palette.background.default,
        padding = theme.spacing.unit * 3
      ),
      toolbar = theme.mixins.toolbar,
  )

  override def componentConstructor(
      implicit propsReader: Reader[Unit],
      stateWriter: Writer[Layout.State],
      stateReader: Reader[Layout.State],
      constructorTag: ConstructorTag[Def]): js.Object = {
    Styles.withStyles(styles, literal(withTheme = true))(
      super.componentConstructor(propsReader,
                                 stateWriter,
                                 stateReader,
                                 constructorTag))
  }

  class Def(jsProps: JsProps) extends Definition(jsProps) {

    private def handleDrawerToggle(): Unit = {
      this.setState(this.state.copy(mobileOpen = !this.state.mobileOpen))
    }

    override def render(): ReactElement = {
      val drawer = div(
        div(className := this.jsProps.classes.toolbar),
        Divider(),
        List(component = "nav")(
          div(
            Link(to = "/")(className := this.jsProps.classes.link)(
              ListItem(button = true)(ListItemText(primary = "Home"))),
            Link(to = "/page1")(className := this.jsProps.classes.link)(
              ListItem(button = true)(ListItemText(primary = "Page 1")))
          ))
      )

      div(className := this.jsProps.classes.root)(
        AppBar(AppBar.Props())(className := this.jsProps.classes.appBar)(
          Toolbar(
            IconButton(IconButton.Props(onClick = handleDrawerToggle))(
              className := this.jsProps.classes.navIconHide)(MenuIcon()),
            Typography(Typography.Props())("Header")
          )),
        Hidden(Hidden.Props())(Hidden.mdUp := Unit)(
          Drawer(
            variant = "temporary",
            classes = literal(paper = this.jsProps.classes.drawerPaper),
            open = this.state.mobileOpen,
            anchor =
              if (this.jsProps.theme.direction == "rtl") "right"
              else "left"
          )(drawer)),
        Hidden(implementation = "css")(Hidden.smDown := Unit)(
          Drawer(open = true,
                 classes = literal(
                   paper = this.jsProps.classes.drawerPaper
                 ))(drawer)),
        main(className := this.jsProps.classes.content)(
          div(className := this.jsProps.classes.toolbar),
          Switch(
            Route(path = "/", exact = true, component = HomePage),
            Route(path = "/page1", exact = true, component = PageOne),
            Route(component = NotFoundPage)
          )
        )
      )
    }

    override def initialState: State = State(mobileOpen = false)
  }

}
