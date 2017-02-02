package fdietze.scalajs.react.component

import org.scalajs.dom.raw.HTMLElement

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

abstract class Playground[_Props <: AnyRef](componentName: String = "Playground") {
  type Props = _Props
  type Scope = BackendScope[Props, Unit]

  class Backend($: Scope) {
    def render(p: Props) = <.div(^.ref := "component")

    var playground: Environment = null
    def init() {
      val node = Ref[HTMLElement]("component")($).get
      playground = environmentFactory(node)
    }
  }

  abstract class Environment {
    def setProps(p: Props)
    def propsUpdated(oldProps: Props) {}
    // def cleanup() {}
  }
  val environmentFactory: HTMLElement => Environment

  protected val component = ReactComponentB[Props](componentName)
    .renderBackend[Backend]
    .componentDidMount(c => Callback {
      c.backend.init()
      c.backend.playground.setProps(c.props)
    })
    .componentWillReceiveProps(c => Callback {
      if (c.nextProps ne c.currentProps) {
        c.$.backend.playground.setProps(c.nextProps)
        c.$.backend.playground.propsUpdated(c.currentProps)
      }
    })
    .shouldComponentUpdate(_ => false) // let our custom code handle the update instead
    // .componentWillUnmount(c => Callback { c.backend.playground.cleanup() })
    .build

  def apply(p: Props) = component(p)
}
