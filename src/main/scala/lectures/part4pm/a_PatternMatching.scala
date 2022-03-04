package lectures.part4pm

import lectures.part4pm.a_PatternMatching.show

import scala.util.Random

object a_PatternMatching extends App {

  // Pattern Matching = a switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "the SECOND"
    case 3 => "the THIRD"
    // If do default handling, and then no match, you get a scala.MatchError
    case _ => "SOMETHING ELSE"
  }


  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 23)
  val greeting = bob match {
    case Person(n, a) if a < 21=> s"Hi, my name is $n, and I am $a years old, and I am still studying"
    case Person(n, a) => s"Hi, my name is $n, and I am $a years old"
    case _ => "I don't know"
  }
  println(greeting)

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed bred")
  }


  // match everything
  val isEven = x match {
    case  n if n % 2 == 0 => true
    case _ => false
  }
  // WHY?!
  val isEvenCond = if (x % 2 == 0) true else false // ?!
  val isEvenNormal = x % 2 == 0

  /*
    Exercise
    simple function uses PM
     takes an Expr => human readable form

     Sum(Number(2), Number(3)) => 2 + 3
     Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
     Prod(Sum(Number(2), Number(1)), Number(3)) = (2 + 1) * 3
     Sum(Prod(Number(2), Number(1)), Number(3)) = 2 * 1 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show_sarye(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => "(" + show(e1) + "+" + show(e2) + ")"
    case Prod(e1, e2) => show(e1) + "*" + show(e2)
  }

  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
    case Prod(e1, e2) => {
      // If there is an expression of lower priority, add parenthesis
      def maybeShowParentheses(exp: Expr) = exp match{
        case Number(_) => show(exp)
        case Prod(_, _) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + "*" + maybeShowParentheses(e2)
    }
  }



  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4)))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))



}
