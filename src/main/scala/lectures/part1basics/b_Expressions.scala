package lectures.part1basics

object b_Expressions extends App {
  val x = 1+2
  println(x)
  println((2+3)* 4)
  println(x == 1)
  println(!(x == 1))

  // Instruction (do) vs. Expression (value)
  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  print(aConditionedValue)

  // Loop
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Unit (= void)
  var aVariable = 4
  val aWeidValue = (aVariable = 3)
  println(aWeidValue)
  i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "Hello" else "goodbye"
  }

  /*
  * Exercise
  * - what is the type of "hello": String
  * - what is the type of println("hello"): it is a side-effect, thus of type Unit (void).
  */








}
