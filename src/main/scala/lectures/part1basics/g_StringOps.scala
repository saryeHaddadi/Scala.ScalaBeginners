package lectures.part1basics

object g_StringOps extends App {
  var str: String = "Hello, I am learning Scala"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(s"a: ${aNumberString}z")

  // Scala specific string interpolators
  // s-interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, I am $name, I am $age years old, I will be turning ${age+1} in cha Allah"

  // f-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  // %2.2f = at least 2 characters, with 2 decimals precision.

  // raw-interpolator
  println(raw"This is a\n newline")
  val escaped = "This is a\n newline"
  println(raw"$escaped")
}
