package hello.world.pages

import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html.div

import scala.scalajs.js

@react class NotFoundPage extends StatelessComponent {

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
    div("404")
  }
}
