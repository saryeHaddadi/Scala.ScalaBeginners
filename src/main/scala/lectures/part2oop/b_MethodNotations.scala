package lectures.part2oop

import scala.language.postfixOps

object b_MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def isFriendWith(person: Person): String = s"${this.name} is friend with ${person.name}"
    def +(person: Person): String = s"${this.name} is friend with ${person.name}"
    def unary_! : String = s"$name, what the heck?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name, and I like $favoriteMovie"
  }

  /* Infix notation style ("syntactic sugar")
  */
  var mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  // Operators in Scala: all operators are methods in Scala!
  val tom = new Person("Tom", "Fight Club")
  println(mary isFriendWith tom)
  println(mary + tom)
  println(mary.+(tom))
  println(1 + 2)
  println(1.+(2))

  /* Prefix notation.
  * Prefix notation is all about unary operators
  * unary_ prefix only works with - + ~ !
  */
  val x = -1 // is equivalent to 1.unary_-
  val y = 1.unary_-
  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary()) // equivalent to the previous line

}
