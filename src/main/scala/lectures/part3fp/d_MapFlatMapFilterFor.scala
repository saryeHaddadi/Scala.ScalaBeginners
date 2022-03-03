package lectures.part3fp

object d_MapFlatMapFilterFor extends App {

  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // Exo. Print all combination between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")
  val colors = List("black", "white")
  // result = List("a1", "a2", ...)

  def concatElem(char: String, list: List[Int]): List[String] =
    list.map(x => char.concat(x.toString))
  println(concatElem("a", numbers))
  println(chars.flatMap(concatElem(_, numbers)))

  // "Interating"
  val combination = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combination)
  val combination2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + color)))
  println(combination2)
  val combination3 = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + color)))
  println(combination3)

  // for-comprehension
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + color
  println(forCombinations)

  for {
    n <- numbers
  } println((n))

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1.  MyList supports for comprehensions?
        map(f: A => B) => MyList[B]
        filter(p: A => Boolean) => MyList[A]
        flatMap(f: A => MyList[B]) => MyList[B]
    2.  A small collection of at most ONE element - Maybe[+T]
        - map, flatMap, filter
   */



}
