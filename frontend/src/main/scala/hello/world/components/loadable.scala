package hello.world.components

import slinky.core.facade.ReactElement

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("react-loadable", JSImport.Default)
@js.native
object loadable extends js.Object {
  val loadable: js.Function1[js.Object, ReactElement] = js.native
}
