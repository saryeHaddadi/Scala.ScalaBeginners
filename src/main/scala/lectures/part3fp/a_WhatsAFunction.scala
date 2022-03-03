package lectures.part3fp

object a_WhatsAFunction extends App{

  val doubler = new IMyFunction[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }
  println(doubler(2))

  // function types = Function1[1, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int)= new Function2[Int, Int, /*return type=Int*/ Int] {
    override def apply(a:Int, b:Int): Int = a + b
  }

  /*
  1.  a function which takes 2 strings and concatenates them
  2.  transform the MyPredicate and MyTransformer into function types
  3.  define a function which takes an int and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
 */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // this is called a Curried function



}

trait IMyFunction[A, B] {
  def apply(elem: A): B = ???
}















