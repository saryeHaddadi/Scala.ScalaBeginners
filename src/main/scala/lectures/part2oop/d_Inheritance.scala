package lectures.part2oop

object d_Inheritance extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("miam")
    private def eat2 = println("miam")
    protected def eat3 = println("miam")
  }

  class Cat extends Animal {
    def crunch = {
      eat3
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.eat

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  // This is the correct way to extends a class with parameters
  class Adult1(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult2(name: String, age: Int, idCard: String) extends Person(name)

  // Overridding
  class Dog extends Animal {
    override val creatureType = "domestic"
    override def eat = println("crunch, crunch")
  }
  val dog = new Dog
  dog.eat
  println(dog.creatureType)

  class Dog2(override val creatureType: String) extends Animal {
    override def eat = println("crunch, crunch")
  }

  class Dog3(dogType: String) extends Animal {
    override val creatureType = dogType
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog3("canine")
  unknownAnimal.eat

  // Preventing overrides
  class Animal2 {
    val creatureType = "wild"
    final def eat = println("miam")
  }
  final class Animal3 {
    val creatureType = "wild"
    def eat = println("miam")
  }
}
