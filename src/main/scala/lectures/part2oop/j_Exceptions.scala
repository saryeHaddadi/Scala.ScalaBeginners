package lectures.part2oop

object j_Exceptions extends App{

  // This methods when called, throws a NullPointerException,
  // and nobody is there to catch it.
//  val x: String = null
//  println(x.toString)

  // 1. Throw exceptions
  //val aWeidValue: String = throw new NullPointerException

  // 2. Catch exceptions
  def getInt(withException: Boolean): Int =
    if(withException) throw new RuntimeException("No int for you!")
    else 123

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: NullPointerException => println("Caught a NullPointerException")
    case e: RuntimeException => println("Caught a RuntimeException")
  } finally {
    println("finally is always executed")
  }

  // 3. Implement your own Exceptions
//  class MyException extends Exception
//  val exception = new MyException
//  throw exception



  /*
    1.  Crash your program with an OutOfMemoryError
    2.  Crash with StackOverflowError
    3.  PocketCalculator
        - add(x,y)
        - subtract(x,y)
        - multiply(x,y)
        - divide(x,y)

        Throw
          - OverflowException if add(x,y) exceeds Int.MAX_VALUE
          - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
          - MathCalculationException for division by 0
   */
  //  OOM
  //  val array = Array.ofDim(Int.MaxValue)

  //  SO
  //  def infinite: Int = 1 + infinite
  //  val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))




}
