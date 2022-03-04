package lectures.part4pm

import exercices.{MyList, Cons, Empty}

object b_AllThePatterns extends App {
  // 1. Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "the true"
    case b_AllThePatterns => "A singleton object"
  }

  // 2. match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 match a variable
  val matchAVariable = x match {
    case something => s"I have found $something"
  }

  // 3. tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) => "aaa"
    case(something, 2) => s"I have found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => "aaaa"
  }

  // 4. Case classes, constructor patter
  // This is the biggest example of pattern matching
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => "aaaa"
    case Cons(head, Cons(subhead, subtail)) => "bbb"
  }

  // 5. List patterns
  var aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "a"// extractor (advanced topic)
    case List(1, _*) => "b" // list of arbitrary length (advanced topic)
    case 1 :: List(_) => "c" //infix pattern
    case List(1, 2, 3) :+ 42 => "d" //infix pattern
  }

  // 6. Type Specifiers
  val unknwon: Any = 2
  val unknownMatch = unknwon match {
    case list: List[Int] => "a" // explicit type specifier
    case _ => "b"
  }

  // 7. Name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => "a" // name binding => use the name latter (here)
    case Cons(1, rest @ Cons(2, _)) => "a" // name binding inside nested patterns
  }

  // 8. multy-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => "a" // compound pattern (multi-pattern)
    case _ => ""
  }

  // 9. if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => "a"
  }

  // That's ALL folks!

  /*
    Question.
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    // This is what the JVM sees
//    case listOfStrings: List => "a list of strings"
//    case listOfNumbers: List => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)
  // JVM trick question
  // It returns "a list of strings" ! Why?
  // Java is compatible with all version.
  // To make Java 5 compatible with Java 1,
  // Java erase all generis types after type checking, which
  // make the JVM absolutely oblivious to generic types.





}
