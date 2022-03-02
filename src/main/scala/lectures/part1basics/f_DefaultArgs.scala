package lectures.part1basics

object f_DefaultArgs extends App{

  //
  def trFact(n: Int, acc: Int = 1): Int =
    if (n < 1) acc
    else trFact(n-1, n*acc)
  val fact10 = trFact(10)

  //
  def savePicture(format: String = "jpg", width:Int, height: Int): Unit = println("saving picture")
  savePicture(width = 800, height = 600)
  /*
  * 1. Either you pass in every leading argument
  * 2. name the arguments
  */
}
