package lectures.part1basics

object c_Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aPrepeatedFunction(aString: String, n:Int): String = {
    if (n==1) aString
    else aString + " " + aPrepeatedFunction(aString, n-1)
  }
  println(aPrepeatedFunction("hello", 3))


  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  def aBigFunction(n: Int): Int = {
    def sSmallerFunction(a: Int, b: Int): Int = a + b
    sSmallerFunction(n, n-1)
  }

  /* Exercises
  * 1. A greeting function (name, Age) => "Hi, my name is $name, I ma $age years old."
  * 2. Factorial Function 1*2*3*...*n
  * 3. Fibonacci function
  *   f(1) = 1
  *   f(2) = 1
  *   f(n) = f(n-1) + f(n-2)
  * 4. Test if number is prime
  */

  def greeting(name: String, age: Int): String =
    s"Hi, my name is $name and I am $age years old."
  println(greeting("David", 12))

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n-1)
  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  println(fibonacci(8)) // 1 1 2 3 5 8 13 21

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
  println(isPrime(1789))
  println(isPrime(559))
}
