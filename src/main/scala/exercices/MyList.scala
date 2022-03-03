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

  // more HOF
  def foreach(f: (A => Unit)): Unit
  def sort(comparison: ((A, A) => Int)): MyList[A]
  def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C]
  def fold[B](initializer: B)(combinationFunction: (B, A) => B): B
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

  // more HOF
  def foreach(f: (Nothing => Unit)): Unit = () // () is the Unit value, void
  def sort(comparison: ((Nothing, Nothing) => Int)): MyList[Nothing] = Empty
  def zipWith[B, C](list: MyList[B], f: (Nothing, B) => C): MyList[C] =
    if (!list.isEmpty) throw new RuntimeException("List do not have the same length")
    else Empty
  def fold[B](initializer: B)(combinationFunction: (B, Nothing) => B): B = initializer
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

  // higher-order functions
  def map[B](transformer: A => B): MyList[B] =
    Cons(transformer((h)), t.map((transformer)))
  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  // more HOF
  def foreach(f: (A => Unit)): Unit =
    f(h)
    t.foreach(f)

  def sort(compare: ((A, A) => Int)): MyList[A] = {
    def insert(x:A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C] =
    if (list.isEmpty) throw new RuntimeException("List do not have the same length")
    else new Cons(f(h, list.head), t.zipWith(list.tail, f))

  def fold[B](initializer: B)(combinationFunction: (B, A) => B): B =
    t.fold(combinationFunction(initializer, h))(combinationFunction)
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

  // More HOF
  listOfInt.foreach(println)
  println(listOfInt.sort((x, y) => y-x))
  //println(listOfInt.zipWith(anotherListOfInt, _ + " " + _)) // should fail, because not same lenght
  //println(listOfInt.zipWith[String, String](cloneListOfInt, _ + "-" + _))
  println(listOfInt.zipWith(cloneListOfInt, _ + "-" + _))
  println(listOfInt.fold(0)(_ + _))


  // for-comprehensions
  val combinations = for {
    n <- listOfInt
    string <- listOfString
  } yield n + "-"
  println(combinations)

  println(for {
    n <- listOfInt
    string <- listOfString
  } yield n + "-")





}






















