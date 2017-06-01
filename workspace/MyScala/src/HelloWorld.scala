object HelloWorld {
  def main(args: Array[String]): Unit = {
    /* Expressions */
    println(1) // 1
    println(1 + 1) // 2
    println("Hello!") // Hello!
    println("Hello, World!")
    println("Hello," + " world!") // Hello, world!

    /* Values */
    // You can name results of expressions with the val keyword
    // val x = 1 + 1
    // x = 3 // Referencing a value does not re-compute it. Values cannot be re-assigned. So, this does not compile.
    val x: Int = 1 + 1 // Types of values can be inferred, but you can also explicitly state the type
    println(x) // 2

    /* Variables */
    // Variables are like values, except you can re-assign them. You can define a variable with the var keyword.
    var y = 1 + 1
    y = 3 // This compiles because "x" is declared with the "var" keyword.
    println(y * y) // 9

    /* Blocks */
    // You can combine expressions by surrounding them with {}. We call this a block
    // The result of the last expression in the block is the result of the overall block, too.
    println({
      val x = 1 + 1
      x + 1
    }) // 3

    /* 
     * Functions
     * Functions are expressions that take parameters.
     */ 
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3

    /* 
     * Methods
     * Methods look and behave very similar to functions, but there are a few key differences between them.
     * Methods are defined with the def keyword. def is followed by a name, parameter lists, a return type, and a body.
     */
    def sum(x: Int, y: Int): Int = x + y
    println(sum(1, 2)) // 3
    // Notice how the return type is declared after the parameter list and a colon : Int.
    // Methods can take multiple parameter lists.
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9
    // Or no parameter lists at all.
    def name: String = System.getProperty("name")
    println("Hello, " + name + "!")
    // Methods can have multi-line expressions as well.
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString()
    }
    println(getSquareString(2.5))

    /*
     * Classes
     * You can define classes with the class keyword followed by its name and constructor parameters.
     */
    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit =
        println(prefix + name + suffix)
    }
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer") // Hello, Scala developer!

    /*
     * Case Classes
     * Scala has a special type of class called a “case” class.
     * By default, case classes are immutable and compared by value. You can define case classes with the case class keywords.
     */
    case class Point(x: Int, y: Int)
    // You can instantiate case classes "without" new keyword.
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)
    // And they are compared by value.
    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    }
    // Point(1,2) and Point(1,2) are the same.
    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    }
    // Point(1,2) and Point(2,2) are different.

    /*
     * Objects
     * Objects are single instances of their own definitions.
     * You can think of them as singletons of their own classes.
     */
    // You can define objects with the object keyword.
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    // You can access an object by referring to its name.
    val newId: Int = IdFactory.create()
    println(newId) // 1
    val newerId: Int = IdFactory.create()
    println(newerId) // 2

    /*
     * Traits
     * Traits are types containing certain fields and methods. Multiple traits can be combined.
     */
    // You can define traits with trait keyword.
    /*
    trait Greeter {
      def greet(name: String): Unit
    }*/
    // Traits can also have default implementations.
    trait MyGreeter {
      def greet(name: String): Unit =
        println("Hello, " + name + "!")
    }
    // You can extend traits with the extends keyword and override an implementation with the override keyword.
    class DefaultGreeter extends MyGreeter
    class CustomizableGreeter(prefix: String, postfix: String) extends MyGreeter {
      override def greet(name: String): Unit = {
        println(prefix + name + postfix)
      }
    }
    val myGreeter = new DefaultGreeter()
    myGreeter.greet("Scala developer") // Hello, Scala developer!
    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer") // How are you, Scala developer?
    // Here, DefaultGreeter extends only a single trait, but it could extend multiple traits

    /*
     * Main Method
     * The main method is an entry point of a program.
     * The Java Virtual Machine requires a main method to be named main and take one argument, an array of strings.
     */
    /*
    object Main {
      def main(args: Array[String]): Unit =
        println("Hello, Scala developer!")
    }*/
  }
}