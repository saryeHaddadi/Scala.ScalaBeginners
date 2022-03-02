package lectures.part2oop

object e_AbstractDataTypes extends App {

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    // override is not necessary, because the extended class is abstract itself
    def eat: Unit = println("miam")
  }

  // Interface (named Trait in Scala)
  trait ICarnivor {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }
  trait IColdBlooded

  class Crocodile extends Animal with ICarnivor with IColdBlooded {
    override val creatureType: String = "Crocodile"
    def eat: Unit = println("croc croc croc")
    def eat(animal: Animal): Unit = println(s"I'am a croc, and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

}
