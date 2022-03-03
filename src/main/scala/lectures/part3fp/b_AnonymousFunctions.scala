package lectures.part3fp

object b_AnonymousFunctions extends App {

  val doubler_old = new Function[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  // This is an anonymous function, also called lambda function
  val doubler_a = (x: Int) => x * 2
  val doubler_b: Int => Int =
    x => x * 2

  // lambda with multiple param
  val adder: (Int, Int) => Int = (a: Int, b:Int) => a + b

  // lambda with no param
  val justDoSomething: () => Int = () => 3
  println(justDoSomething) // the function itself
  println(justDoSomething()) // the function is called

  // lambda with curly braces
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x+1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a+b

  /*
  1.  MyList: replace all FunctionX calls with lambdas
  2.  Rewrite the "special" adder as an anonymous function
 */
  val superAdd = (x: Int) => ((y: Int) => x + y)
  println(superAdd(3)(4))
}
