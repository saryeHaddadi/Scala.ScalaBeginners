package lectures.part2oop

object c_Objects {

  object Person {
    // static, class level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    def getBaby(mother: Person, father: Person, babyName: String): Person = new Person(babyName)

    def apply(mother: Person, father: Person, babyName: String): Person = new Person(babyName)
  }

  class Person(val name: String) {
    // instance level functionality
  }

  // Scala Application = a Scala object with a method
  // def main(args: Array[String]): Unit
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = a singleton instance
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    val bobbie1 = Person.getBaby(mary, john, "Bobbie")
    val bobbie2 = Person.apply(mary, john, "Bobbie")
    val bobbie3 = Person(mary, john, "Bobbie")


  }

}
