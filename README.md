
#Getting Started With Scala.js for the JavaScript Developer (Part 1 | Setup & Vue.js)

##What you’re getting into: A very detailed guide to getting started with Scala.js as well as using Vue and React with Scala.js. This is part…

##Getting Started With Scala.js for the JavaScript Developer (Part 1 | Setup & Vue.js)

![](https://medium2.global.ssl.fastly.net/max/6600/1*iQXW2fK8X-ViU4lLHOs2dA.png)**

*What you’re getting into:* A very detailed guide to getting started with Scala.js as well as using Vue and React with Scala.js. This is part 1 of the series which will cover getting started with Scala.js and Scala.js with Vue.js.

*What you’re not getting into: *A personal review of Scala.js. A detailed overview of the Scala language. A detailed explanation of Vue.js. A detailed explanation of React.js.

*Who this if for: *This article is slightly bent to be described to an existing JavaScript developer. However, this is a good introduction for anyone to get started with Scala.js. When we get to working with Vue and React, I will not be explaining these at a beginner-level. Nevertheless, the examples might be clear and obvious to follow along.

*My teaching methodology: *I would much rather err by saying too much than saying too little. I try my best to practical and beginner-friendly. For these reasons, I might be going into detail about something that may be obvious to you.

##Prerequisites:

[Install Node.js](https://nodejs.org/en/)

[Install Scala](https://www.scala-lang.org/download/)

[Install JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Install IntelliJ IDEA](https://www.jetbrains.com/idea/) → IDE for our Scala.js with React project

[Install SBT](http://www.scala-sbt.org/) → The Scala Build Tool

[Add the Scala plugin to IDEA](https://www.jetbrains.com/help/idea/2017.1/creating-and-running-your-scala-application.html)

[Briefly read about Scala](https://www.scala-lang.org/)

[Briefly read about Scala.js](https://www.scala-js.org/)

##Why Scala.js?

Scala.js allows you to write Scala code that compiles to efficient JavaScript. The scope of this article is to review Scala.js, however, I will list the benefits that Scala.js as they present it:

1. Support of types

1. Strong type system

1. IDE Support

##Up and Running With Scala.js

To start, we will go through creating a simple Scala.js project from scratch to get familiar with what we are working with.

###Creating a New Project

1. Open **IntelliJ IDEA**

1. Select **Create New Project**

1. In the **New Project** window, select **Scala **and **SBT **then hit **Next**

![New Project Window](https://medium2.global.ssl.fastly.net/max/2000/1*gUcSkojJVXilMMd9dLvAcQ.png)*New Project Window*

4. Create a folder called **Scala Starter **locally

5. Select this folder as location for our new project

6. Name your project **Scala Starter**

7. Leave all the settings to the default and hit **finish**. (**Note:** If you have not already specified the JDK you have installed, you will need to point to it in the **JDK **field.)

###Setting Up the Build

Cool! We should now have a Scala project with SBT loaded in the IDE.

![Scala Project in IntelliJ IDEA](https://medium2.global.ssl.fastly.net/max/2000/1*QhfDqn6DPRCJ5Mv32aYXUg.png)*Scala Project in IntelliJ IDEA*

The next thing we want to do is the setup of SBT for Scala.js. As we complete this, we’ll note what is going on since I won’t assume you have prior knowledge of SBT.

1. Right click on **project **and select **New → File**

1. Create a file called **plugins.sbt**. This file will include SBT plugins. SBT plugins are used to extend the default build definition.

1. We need to add a plugin to extend our build definition to work with Scala.js. To do this, add the following to the plugins.sbt we just created:

    addSbtPlugin(“org.scala-js” % “sbt-scalajs” % “0.6.15”)

For our plugins in SBT, we have a url, name, and version separated by a *%*.

Next, let’s go ahead and take a look at the **build.properties** file which is already created for us under **project**.

Here, we should see the follow:

    sbt.version = 0.13.15

As we can see, this file is specifying our current version of SBT which we want to keep as 0.13.15.

Now, let’s take a look at **build.sbt **which is in the root of our project directory.

If you are coming from a JavaScript background like me, you can think of build.sbt as your package.json. In **build.sbt **we will enable plugins, define the name, version, and scalaVersion, and add dependencies.

Currently, we should just see the name, version, and scalaVersion. We need to enable the plugin we added earlier by adding the following:

    **enablePlugins(ScalaJSPlugin)**

    *name *:= "Scala Starter"
    
    *version *:= "1.0"
    
    *scalaVersion *:= "2.12.2"

We also need to add one more line that will let the build system know we are using an application that will have a main method:

    //everything from previous here

    **scalaJSUseMainModuleInitializer := true**

###Hello Scala.js

Sweet! We have set up SBT. Next, we are going to create a simple “Hello Scala.js” application.

All of our code is going to be under **src/main**.

Our *Scala* code will go under **src/main/scala **which already there for us. Let’s add another directory after this by right clicking on the **scala** directory and selecting **New → Directory** and name it **Hello**.

Now, let’s right click on **Hello **and add a new file called **HelloScalaJs.scala**.

You might see the following alert that says *No Scala SDK in module*:

![No Scala SDK warning](https://medium2.global.ssl.fastly.net/max/2856/1*zES_I8Soe_xuVjlA8XV50A.png)*No Scala SDK warning*

Don’t fret!

1. Simply click on **Setup Scala SDK**.

1. Click **Create**

1. Then, click **Download**

1. Make sure Scala 2.12.2 is selected as the version and click **OK**.

1. Hit **OK **until you are back at the file which should have no alert.

We are now all set to write the code for our Hello Scala.js mini app.

First, we define our package which is the name of the directory after src/main/scala. In our case, we will have:

    **package **Hello

Next, we need to import Scala.js so we this code compiles as JavaScript:

    **package **Hello**
    import** scala.scalajs.js.**JSApp**

Then, we will go ahead an write the skeleton of our app which is an [*object](http://docs.scala-lang.org/tutorials/tour/basics.html#objects).*

    object HelloScalaJs **extends JSApp** {
     
      //add stuff here

    }

Notice, we also have *extends JSApp.*

JSApp is a *trait*. [Traits](http://docs.scala-lang.org/tutorials/tour/basics.html#traits) in Scala are types containing certain fields and methods. We can add traits to an object using *extends*.

Therefore, we are essentially saying “this object is going to be used as a JSApp”.

Next, we will add a main function.

    object TutorialApp extends JSApp {
     ** def main(): Unit = {
       
      }**
    }

This might look a bit odd but *def *is the same as *function*. The *: Unit *is just defining the type of this function which is Unit (the equivalent of undefined in JS).

The last thing we will add is just a simple printing of “Hello Scala.js”:

    object TutorialApp extends JSApp {
      def main(): Unit = {
        **println("Hello Scala.js")**
      }
    }

This can be easily inferred but we are printing a line with the text “Hello Scala.js”. When we open our app in the browser, we will see this message in the console.

Our very simple app is complete! Now, we just need to add compile this to JS and include the compiled code in an HTML file.

To compile the Scala code, let’s open up our terminal/command prompt.

1. cd (change directory) into the root of our project

1. Type **sbt **to fire up our app

1. Type **fastOptJS **(this compiles our Scala code and produces a file with the JS code)

Success! Now, we just need to create an HTML file and include the file that was just created.

Under src/main, create a new directory called **Web**.

Next, right click on **Web** → **New → HTML File**. Name it **index.html**.

To include the created JS file, go to the project root and find **scala-starter-fastopt.js **under target/scala-2.12. Then, we can simply drag the file into the index.html file to create the script tag. Alternatively, we could write it out.

Either way, we should now have the following right before the end of our *</body> *tag:

    <script src="../../../target/scala-2.12/scala-starter-fastopt.js"></script>

Let’s see if it worked!

Right click **index.html** and select **Run index.html**.

This will open up the file in our browser.

Since we have no HTML, we should just see a blank page. However, if our Scala code compiled correctly, we should see “Hello Scala.js” in our console.

![Hello Scala.js in Console](https://medium2.global.ssl.fastly.net/max/2000/1*a6n301j1ver7Ci0aM_M8IQ.png)*Hello Scala.js in Console*

Cool! We have set up and ran our very first Scala.js app!

However, nobody wants to see a blank page…

Let’s render something to the [DOM](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model).

To be able to do this, we need to add a library dependency called *scala-js dom*.

To add this dependency, go back to **build.sbt **and add the following and hit save:

    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"

**Note:** This is standard syntax with adding dependencies in Scala with just one exception. %%% after the url refers to a Scala.js dependency while a Scala dependency is usually just %%.

Whenever we save a change to the build.sbt file, we need to refresh the project in IntelliJ. IntelliJ prompts the option for us to do this by default:

![build.sbt Refresh Project](https://medium2.global.ssl.fastly.net/max/2466/1*Rj7usAL5WSt5CXWGOkP2ew.png)*build.sbt Refresh Project*

After you refresh the project, we also need to run another command in SBT to notify it to reload the project (cd into the root and run sbt in case you closed out of your command prompt/terminal). Simply type in **reload**.

With our project reloaded, we need to adjust our *HelloScalaJS* file to make use of the scala-js dom dependency for rendering stuff to the DOM.

To do this, open **HelloScalaJS.scala **and add the following imports after the one import line:

    **import** org.scalajs.dom 
    **import** dom.document

Next, let’s add another function to our Object called **appendHello**:

    def appendHello(targetNode: dom.Node, text: String): Unit = {
      
    }

Here, we have defined a function and two parameters (targetNode and text). Next to these parameters are the types for each. This is standard for defining parameters in Scala.

Before we move on with *appendHello*, let’s write out the call to this function from *main*.

    appendHello(document.body, "Hello Scala.js")

Here, we passed document.body as the dom.Node (the location to inject to the DOM). We also passed a string of “Hello Scala.js”.

Ok. Now, we have to write the rest of *appendHello* to render our text to the DOM.

    def appendHello(targetNode: dom.Node, text: String): Unit = {
      val titleNode = document.createElement("h1")
      val textNode = document.createTextNode(text)
      titleNode.appendChild(textNode)
      targetNode.appendChild(titleNode)
    }

The code does the following:

1. Creates an H1 element

1. Takes our text and creates a text node

1. Appends our text to the H1 element stored in titleNode (equivalent: <h1>Hello Scala.js</h1>

1. Appends the H1 element with our text into our targetNode (the body)

Essentially, we have given instructions to render the following using Scala:

    <body>

      <h1>Hello Scala.js</h1>

    </body>

To run this, we just have to type **fastOptJS **again.

Run the index.html file and we should see our hello.

![Hello Scala.js](https://medium2.global.ssl.fastly.net/max/2000/1*0ZUK4XJKZwzLNbl6daYaYQ.png)*Hello Scala.js*

Cool beans!

##Brief Explanation Facades for JavaScript Libraries

Even though we didn’t do much, I think it is appropriate to move onto using a JavaScript framework.

Scala.js allows us to use JavaScript libraries like Vue.js and React.js. We will go through an example of each in this series.

Before we do that, however, we must examine how JavaScript libraries can be used in Scala.js.

Keep in mind that one of the major differences with working with Scala.js that it enforces type safety. For that reason, JavaScript facades have to be written to wrap existing JavaScript libraries so that they will work with Scala’s type safety.

I am not going to go into more than this basic explanation. You can [read this write up for more information](https://www.scala-js.org/doc/interoperability/facade-types.html) on how facades work and how to write your own.

[Here’s a full list of existing facades.](https://www.scala-js.org/libraries/facades.html)

One last thing to note before we move on. These facades are not officially maintained and not all of them give you the full functionality of the original JavaScript libraries.

For instance, the Vue facade which we will look at next does not include Vuex and Vue Router support. React, on the other hand, has much better support and functionality including examples, tutorials, React Router, etc.

Nevertheless, we will take a look at Vue with Scala.js next. Reason being, Vue is easier to get started with in Scala.js and is a great place to begin if you are a beginner to JavaScript frameworks. Once we complete that, we will take an in-depth look at React with Scala.js in another post.

##Getting Started With Vue.js in Scala.js

First, let’s go ahead and add the following script for Vue right above our script for the compiled JS code.

    <script src="https://unpkg.com/vue"></script>

This is just the standard Vue.js CDN.

We have to add the Scala.js Vue facade. Before we do that, let’s clean up our project.

We can go ahead and delete **HelloScalaJs.scala**. Let’s also rename the **Hello **directory to **scalajs **(right click → refactor → rename → scalajs).

Then, let’s go ahead and add another directory after *scalajs* called **vuejs**.

Once this is done, create a new file in the newly created *vuejs* directory and name it **Vue.scala**.

Next, we can paste in the facade via [Github](https://github.com/fancellu/scalajs-vue/blob/master/src/main/scala/com/felstar/scalajs/vue/Vue.scala) and update the package to reflect our project structure:

    **package **scalajs.vuejs.Vue

    import scala.scalajs.js
    import org.scalajs.dom
    import org.scalajs.dom._

    import js.annotation.JSName
      
      [@js](http://twitter.com/js).native
       class Vue extends js.Object {
        def this(obj: js.Any) = this()   
         // instance properties
        val $el:raw.Element =js.native
        val $data:js.Dynamic =js.native
        val $options:js.Dynamic =js.native
        val $parent:Vue =js.native
        val $root:Vue =js.native
        val $children:js.Array[Vue] =js.native
        val $:js.Dynamic =js.native
        val $$:js.Dynamic =js.native
        val $index:Int =js.native
        val $key:js.Any =js.native
        val $value:js.Any =js.native
          // Data
        type Callback=js.Function2[_,_,Unit]
        def $watch(expOrFn:js.Any,callback:Callback):Unwatch=js.native
        def $watch(expOrFn:js.Any,callback:Callback,options:js.Any):Unwatch=js.native
        def $get(exp:String):js.Any=js.native
        def $set(target:js.Any,key:js.Any, value:js.Any):Unit=js.native
        def $delete(target:js.Any,key:js.Any):Unit=js.native
        def $add(key:String,value:js.Any):Unit=js.native
        def $eval(exp:String):js.Any=js.native
        def $interpolate(templateString:String):js.Any=js.native

    // Events
        def $dispatch(event:String):Unit=js.native
        def $dispatch(event:String,args:js.Any):Unit=js.native
        def $broadcast(event:String):Unit=js.native
        def $broadcast(event:String,args:js.Any):Unit=js.native
        def $emit(event:String):Unit=js.native
        def $emit(event:String,args:js.Any):Unit=js.native
        def $on(event:String,callback:js.Function):Unit=js.native
        def $once(event:String,callback:js.Function):Unit=js.native
        def $off():Unit=js.native
        def $off(event:String):Unit=js.native
        def $off(event:String,callback:js.Function):Unit=js.native
          // DOM
        def $appendTo(elementOrSelector:js.Any):Unit=js.native
        def $appendTo(elementOrSelector:js.Any,callback:js.Function):Unit=js.native
        def $before(elementOrSelector:js.Any):Unit=js.native
        def $before(elementOrSelector:js.Any,callback:js.Function):Unit=js.native
        def $after(elementOrSelector:js.Any):Unit=js.native
        def $after(elementOrSelector:js.Any,callback:js.Function):Unit=js.native
        def $remove():Unit=js.native
        def $remove(callback:js.Function):Unit=js.native
        def $nextTick(callback:js.Function):Unit=js.native
          // Lifecycle
        def $mount(elementOrSelector:js.Any):Vue=js.native
        def $destroy(destroy:Boolean=false):Unit=js.native
        def $compile(element:raw.Element):js.Function=js.native
        def $addChild():Unit=js.native
        def $addChild(options:js.Any):Unit=js.native
        def $addChild(options:js.Any,constructor:js.Function):Unit=js.native
        def $addChild(constructor:js.Function):Unit=js.native
      }

    [@js](http://twitter.com/js).native
       class Unwatch extends js.Object {
        def unwatch:Unit =js.native      
       }

    [@js](http://twitter.com/js).native
        object Vue extends js.Object{
         def config:js.Dynamic=js.native
         def extend(obj:js.Any):Vue=js.native
         def nextTick(func:js.Function):Unit=js.native
         def directive(id:String,definition:js.ThisFunction):Unit=js.native     
         def directive(id:String,definition:js.Any):Unit=js.native
         def elementDirective(id:String,definition:js.ThisFunction):Unit=js.native     
         def elementDirective(id:String,definition:js.Any):Unit=js.native
         def filter(id:String):js.Any=js.native
         def filter(id:String,func:js.Function):js.Any=js.native
         def component(id:String):js.Any=js.native
         def component(id:String,definition:js.Function):js.Any=js.native
         def component(id:String,definition:js.Any):js.Any=js.native
         def transition(id:String):js.Any=js.native
         def transition(id:String,definition:js.Any):js.Any=js.native
         def partial(id:String):js.Any=js.native
         def partial(id:String,template:String):js.Any=js.native
         def use(plugin:js.Any):js.Any=js.native
         def use(plugin:js.Any,args:js.Any*):js.Any=js.native
         def set(target:js.Any,key:js.Any, value:js.Any):Unit=js.native
         def delete(target:js.Any,key:js.Any):Unit=js.native
        }

    [@js](http://twitter.com/js).native
       class Directive extends js.Object {
        val name:String =js.native
        val rawName:String =js.native
        val value:String =js.native
        val expression:String =js.native
        val modifiers:js.Any =js.native
        val `def`:js.Any =js.native
       }

In this same directory, let’s create a new file named **Counter.scala **where we will create a simple counter app using Vue.

Before we start writing the counter app, let’s first try to do a “Hello Scala.js” via Vue.

Here is the package and all the imports:

    **package **scalajs.vue.Counter
    
    **import **org.scalajs.dom
    **import **org.scalajs.dom._
    **import **scala.scalajs.js
    **import **scala.scalajs.js.Any._
    **import **scala.scalajs.js.Dynamic.{literal, global => g}
    **import **scala.scalajs.js.{Dynamic, JSApp}
    **import **scala.scalajs.js.annotation.JSExport
    **import **scalajs.vuejs.Vue

Then, we write our Counter object that extends JSApp like in our first example:

    object Counter extends JSApp {

    }

Inside this object, we will write a basic Vue instance using Scala.js:

    @JSExport
    **def **main() = {
      //main Vue instance to attach to #main
      **val **app = **new **Vue(
        literal(
          **el** = "#main",
          **data** = literal(
            **message** = "Hello Scala.js"
          )
        )
      )
    }

This is equivalent to the following in standard Vue:

    const app = new Vue({
      el: "#main",
      data: {
        message: "Hello Scala.js"
      }
    })

You’ll notice some differences. We need to use @JSExport to specify to export our *def main *as JavaScript.

*val *is equivalent of *const *in JavaScript.

*literal(…) *is wrapped around in any place where we’d have the following format in standard JavaScript:

    el: ,
    data:
    //etc

We also replace **: **with **=**

You might be thinking it’s time to try to run this. Well, we haven’t specified types for our data so it won’t work just yet.

We define the types for our data in a trait that extends our Vue facade like this:

    //defines the type for the data in the main Vue instance
    [@js](http://twitter.com/js).native
    trait Data extends Vue {
      var message: String = js.native
    }

A trait definition with Native JS types should be annotated with **@js.native **as can be seen above. We also have to specify **= js.native** after each type.

Now, we should have a type-safe mini Vue app in Scala.js.

Let’s head over to our index.html and add the following in our body:

    <div id="main">{{message}}</div>

This is nothing specific to Scala.js. We are adding a div that is “attached” to our Vue instance and we are injecting our message using the double curly braces.

Finally, we can type the fastOptJS command and run the index.html file.

We should now have the Hello Scala.js working:

![Hello Scala.js Using Vue Facade](https://medium2.global.ssl.fastly.net/max/2000/1*Z_fdjSl9TpfVZs-Ap8h_pQ.png)*Hello Scala.js Using Vue Facade*

Cool!

##Counter App With Vue

Now that we have this working, it is time to write our Counter app. The Counter app will simply update a count on a click.

Let’s start by changing *message *to count in our *Data* trait and Vue instance (*app*):

**Data Trait**

    **trait **Data **extends **Vue {
     ** **var** count**: **Int** = js.native
    }

**Vue Instance**

    **val **app = **new **Vue(
      literal(
        el = "#main",
        data = literal(
          **count** = 0
        )
      )
    )

Now, we want to add methods where we can place functions to manipulate data:

    **val **app = **new **Vue(
      literal(
        el = "#main",
        data = literal(
          count = 0
        ),
        **methods = literal(
    **      
        **)**
      )
    )

Before we define the function, we will define a type for our function. By doing this, both the data and methods will be type safe.

    //set type for Vue methods in main instance with no parameters
    type VueMethod=js.ThisFunction0[Data,_]

The code above might look weird at first. I’m just going to describe this in the laymen terms that makes sense to me.

The syntax for a type of a JavaScript function that is usually accessed by *this *is:

js.ThisFunction*number of parameters* [*trait for our data*, *types of paramaters separated by a comma*, _]

In our case, we defined a function with no parameters in normal JavaScript but due to Scala needing a trait for the type of the data we will manipulate, the trait is Data.

If we want to define a type for a method with one Int parameter, we would do:

    js.ThisFunction1[Data,Int,_]

You can read the technical details [here](https://www.scala-js.org/doc/interoperability/types.html).

Let’s move forward and write a method called **increment**.

    methods = literal(
      **increment** = ((data: Data) =>
        data.count += 1 //++ won't work
      ):VueMethod
    )

First off, the use of the fat arrow in this function is not exclusive to Scala.js. It is similar to the following in ES6:

    **const** f = (x, y) => x + y;

    //in scala.js
    //val f = (x: Double, y: Double) => x + y

In this ES6 example, x and y are parameters. In Scala, the type has to be specified.

Still the data: Data and data.count may seem strange. Essentially, we are just saying “we want to manipulate the count whose type is defined in Data”.

To wrap this up, we need to write the HTML:

    <div id="main">
        {{count}}
        <button @click="increment">Increment</button>
    </div>

Again, there is nothing here in our HTML code that is unique to Scala.js.

Let’s run fastOptJS and run index.html to see if this works.

![Counter App](https://medium2.global.ssl.fastly.net/max/2000/1*PkBUoEHuNo47DGF4ttM_Sg.png)*Counter App*

Sweet! It is indeed working!

Let’s make some improvements before we wrap up the Counter app.

Ideally, we want to encapsulate the HTML we wrote for the count and button in a component.

In normal Vue.js, we would have a component like this for our counter app:

**JS**

    //counter component
    **const Counter** = {
      data: function () {
       return {
         count: 0
        }
      },
      methods: {
       increment: function () {
         this.count++ //or this.count += 1
        }
      },
      template: `<div>
      {{count}}
      <button [@click](http://twitter.com/click)="increment">Increment</button>
      </div>`
    }

    //main instance
    const main = new Vue({
      el: "#main",
      components: {
        **'counter': Counter
    **  }
    })

**HTML**

    <div id="main">
      <counter></counter>
    </div>

[Here are some more examples with Vue components](https://jsfiddle.net/mikemangialardi94/33tognck/) if you aren’t familiar with this.

This is a much more modular and clean approach. So, how can we do the same with Vue in Scala.js?

    //Counter as component
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
      template = "<div> {{count}} " +
        "<button @click='increment'>Increment</button> " +
        "</div>"
     )
    )

Within Vue.component, we first specify “counter” so everything that follows will be encapsulated in <counter></counter>

Just like with normal Vue, [data has to be a function](https://vuejs.org/v2/guide/components.html#main) when using a component. We use the fat arrow syntax in this example.

The increment method is exactly the same as the previous example.

Defining the template works just like in normal Vue. **Note: use all single quotes within a template as seen in the button**

Remove the previous HTML code with this:

    <div id="main">
      <counter></counter>
    </div>

Run fastOptJS and run index.html.

![Counter App Via Component](https://medium2.global.ssl.fastly.net/max/2000/1*PkBUoEHuNo47DGF4ttM_Sg.png)*Counter App Via Component*

It works via component, cool!

[Here’s the full code](https://gist.github.com/michaelmang/f036a3dd2a9b374cf95f3d4b61c2a496).

##Adding More Complexity

One place to look for a more complex example is in the GitHub repo of the Scala.js Vue facade we are using which you can find [here](https://github.com/fancellu/scalajs-vue/blob/master/src/main/scala/example/Todo.scala). (**Note:** there is a slightly different approach, but you should get the gist of it)

I hope to be a crash test dummy for writing Scala.js apps that use Vue and include them in here. For now, I have a simple app that showcases some more functionalities of Vue.js to demo out. This repo also serves as a Scalajs Vue Starter Kit.

Demo: [https://github.com/michaelmang/Scalajs-Vue-Starter-Kit](https://github.com/michaelmang/Scalajs-Vue-Starter-Kit)

##Room for Improvement

While the Vue facade works for basic examples, it does not seem very reliable for anything on a larger scale. There’s still a lot of room for improvement.

The Scala.js community seems to have done a lot of work in React with Vue being uncharted territory. I’m a big fan of Vue and hope to see the facade and more documentation come through.

Nevertheless, I hope this was a helpful article. Please make sure to click the heart and drop a comment.

You can reach me here on Twitter: [https://twitter.com/michaelmangial1](https://twitter.com/michaelmangial1)


