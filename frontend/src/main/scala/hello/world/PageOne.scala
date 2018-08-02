package hello.world

import slinky.core._
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.div

import scala.scalajs.js


@react class PageOne extends StatelessComponent {

  trait Classes extends js.Object {}

  type Props = Unit


  trait Theme extends js.Object {
    def breakpoints: Breakpoints

    def classes: Classes
  }

  trait Breakpoints extends js.Object {
    def up(value: String): js.Object
  }


  def render(): ReactElement = {
    div("Page one")
  }
}

