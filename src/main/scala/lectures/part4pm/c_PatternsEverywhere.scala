package lectures.part4pm

object c_PatternsEverywhere extends App {
  // big idea #1
  try {
    // some code
    // Catches are actually Matches!
  } catch {
    case e: RuntimeException => "runtime"
    case npt: NullPointerException => "npe"
    case _ => "smthing else"
  }

  // big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ?!
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, ...

  // big idea #3
  val tuple = (1,2,3)
  val (a, b, c) = tuple
  println(b)
  // multiple value definitions based on PATTERN MATCHING
  // ALL THE POWER

  val head :: tail = list
  println(head)
  println(tail)

  // big idea #4 - NEW
  // partial function based on PATTERN MATCHING
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal, is equivalent to the following:

  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }
  }
  println(mappedList)
}
