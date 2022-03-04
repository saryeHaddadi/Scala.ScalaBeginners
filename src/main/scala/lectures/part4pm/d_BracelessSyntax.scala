package lectures.part4pm

object d_BracelessSyntax extends App {

  // 1. if - expression
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  // java style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    } else {
    "smaller"
  }

  // compact
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  // Scala 3 exclusif
  val anIfExpression_v4 =
    if (2 > 3) then
      "bigger" // high indentation that the if part
    else
      "smaller"
  val anIfExpression_v5 =
    if (2 > 3) then
      val result = "bigger" // high indentation that the if part
      result
    else
      "smaller"


  // 2. for-comprehension
  val aForComprehension = for {
    n <- List(1, 2, 3) // foreach
    s <- List("black", "white") // foreach
  } yield s"$n$s"
  println(aForComprehension)

  // scala 3
  val aForComprehension_v2 =
    for
      n <- List(1, 2, 3) // foreach
      s <- List("black", "white") // foreach
    yield s"$n$s"

  // pattern matching
  val aNumber = 123
  val aPatternMatching = aNumber match {
    case 1 => "one"
    case 2 => "two"
    case _ => "smthing else"
  }
  val aPatternMatching_v2 = aNumber match
    case 1 => "one"
    case 2 => "two"
    case _ => "smthing else"

  // 3. methods without brace
  def aFunction(arg: Int): Int = {
    var partialResult = 40

            partialResult + 2
  }
  def aFunction_v2(arg: Int): Int =
    var partialResult = 40
    partialResult + 2

  // 4. Class with Indentation
  class Animal:
    def eat(): Unit =
      println("eat")

    def grow(): Unit =
      println("grow")
    end grow
  end Animal // you can add an 'end' statement at the end of class, methods, if, for, enums, object, ...

  // anonymous classes
  val aSpeialAnimal = new Animal:
    override def eat(): Unit = println("I'am special")

  // Definition of Indentation
  // Any indentation that is strictly larger than the previous indentation, that's it!



}
