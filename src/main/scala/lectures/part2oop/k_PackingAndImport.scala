package lectures.part2oop

import playground.{Cinderella, PrinceCharming}
import playground._ //{Cinderella, PrinceCharming}
//import playground.{Cinderella => Princess} // aliasing
//import java.util.Date
//import java.sql.Date
// notes:if you need both Date packages, either use fully qualified name, or aliasing.
// default import
// java.lang: String, Object, Exception
// scala: Int, Nothing, Function
// scala.Predef: println, ???

object k_PackingAndImport extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import
  val princess = new Cinderella

  // packages are in hierarchy,
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // import
  var prince = new PrinceCharming
}
