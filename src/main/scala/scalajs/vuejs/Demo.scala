package scalajs.vue.Demo

import org.scalajs.dom
import org.scalajs.dom._
import scala.scalajs.js
import scala.scalajs.js.Any._
import scala.scalajs.js.Dynamic.{literal, global => g}
import scala.scalajs.js.{Dynamic, JSApp}
import scala.scalajs.js.annotation.JSExport
import scalajs.vuejs.Vue

object Demo extends JSApp {

  //defines the type for the data in the main Vue instance
  @js.native
  trait Data extends Vue {
    var count: Int = js.native
    var on: Boolean = js.native
    var display: String = js.native
    var model: String = js.native
    var todos: js.Array[String] = js.native
  }

  //set type for Vue methods in main instance with no parameters
  type VueMethod=js.ThisFunction0[Data,_]

  //Title component
  Vue.component("sampler", literal(
    template = "<div><h1>Scala.js Vue.js Sampler</h1><hr/></div>"
    )
  )

  //Counter component
  Vue.component("counter", literal(
    data = () => {
      literal(
        count = 0
      )
    },
    methods = literal(
      increment = ((data:Data) =>
        data.count += 1
        ):VueMethod
    ),
    template = "<div><h3>Increment</h3> <p>{{count}}</p> " +
      "<button @click='increment'>Increment</button> " +
      "</div>"
  )
  )

  //Counter component
  Vue.component("toggle", literal(
    data = () => {
      literal(
        on = true,
        display = "On"
      )
    },
    methods = literal(
      toggle = ((data:Data) =>
        if(data.on == false) {
          data.on = true
        } else {
          data.on = false
        }
      ):VueMethod
    ),
    template = "<div><h3>Toggle</h3> <div v-if='on'><p>{{display}}</p></div> " +
      "<button @click='toggle'>Toggle</button> " +
      "</div>"
  )
  )

  //Bind component
  Vue.component("model", literal(
    data = () => {
      literal(
        model = ""
      )
    },
    template = "<div><h3>Model</h3>" +
      "<p>{{model}}</p> <input v-model='model'/> " +
      "</div>"
  )
  )

  //Loop component
  Vue.component("loop", literal(
    data = () => {
      literal(
        todos = js.Array("TODO 1", "TODO 2", "TODO 3")
      )
    },
    template = "<div><h3>Loop</h3>" +
      "<ol><li v-for='todo in todos'>{{todo}}</li></ol> " +
      "</div>"
  )
  )

  @JSExport
  def main() = {
    //main Vue instance to attach to #main
    val app = new Vue(
      literal(
        el = "#main"
      )
    )
  }
}

