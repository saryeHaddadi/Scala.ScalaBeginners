package lectures.part3fp

object c_HOFsCurries extends App {

  //val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(3))) = nTimes(f, 2, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  def plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 5, 0))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x // Identity function
    else (x:Int) => nTimesBetter(f, n-1)(f(x))

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(0))

  // Curried functions
  // usefull when you want to define helper functions that you will use on other values
  val superAdder: Int => (Int => Int) = (x: Int) => ((y: Int) => x + y)
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10))
  println(superAdder(3)(10))

  // Functions with multiple parameter lists
  // This function with multiple list parameters behaves like a curried function
  // Below, we create subfunction from the initial multiple param function.
  def curriedFormatter(c: String)(x: Double): String = c.format(x)
  var standardFormater: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormater:  (Double => String) = curriedFormatter("%10.8f")
  println(standardFormater(Math.PI))
  println(preciseFormater(Math.PI))

  /*
  1.  Expand MyList
      - foreach method A => Unit
        [1,2,3].foreach(x => println(x))

      - sort function ((A, A) => Int) => MyList
        [1,2,3].sort((x, y) => y - x) => [3,2,1]

      - zipWith (list, (A, A) => B) => MyList[B]
        [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]

      - fold(start)(function) => a value
        [1,2,3].fold(0)(x + y) = 6

  2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
      fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int

  3.  compose(f,g) => x => f(g(x))
      andThen(f,g) => x => g(f(x))
 */
}
