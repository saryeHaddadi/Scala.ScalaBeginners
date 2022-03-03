package exercices

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl

abstract class MyList[+A] {
  /*
     head = first element of  the  list
     tail = remainder of the list
     isEmpty = is this list empty
     add(int) => new list with this element added
     toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // List concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] =  throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  // higher-order functions
  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  def map[B](transformer: A => B): MyList[B] =
    Cons(transformer((h)), t.map((transformer)))
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}




object ListTest extends App {
  // List basic tests
  val listOfInt = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfInt = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfInt = new Cons(4, new Cons(5, Empty))
  val listOfString= new Cons("a", new Cons("b", new Cons("c", Empty)))
  println(listOfInt.head)
  println(listOfInt.add(4).head)
  println(listOfInt.toString)
  println(listOfString.toString)

  // Map, flatMap, filter tests
  println(listOfInt.map( (element: Int) => element * 2).toString)

  println(listOfInt.filter( (element: Int) => element %2 == 0).toString)

  println(listOfInt ++ anotherListOfInt)
  println(listOfInt.flatMap( (elem: Int) => new Cons(elem, new Cons(elem + 1, Empty))))

  // Case classes
  println(cloneListOfInt == listOfInt)













}






















