package lectures.part1basics

object CBNvsCBV extends App {

  def callByValue(x: Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  def callByName(x: => Long): Unit = {
    println(s"by value: $x")
    println(s"by value: $x")
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirstKO(x: Int, y: Int) = println(x)
  //printFirstKO(34, infinite())
  def printFirstOK(x: Int, y: => Int) = println(x)
  printFirstOK(34, infinite())


}
