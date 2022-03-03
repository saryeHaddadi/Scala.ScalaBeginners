package lectures.part2oop

object f_Generics extends App {

  class MyList[+A] {
    def add[B >: A](element: B): MyList[B] = ???
    /*
    * Example.
    * A = Cat
    * B = Animal
    */
  }

    // use the type A inside the class definition
    var listOfIntegers = new MyList[Int]
    var listOfStrings = new MyList[String]

    class MyMap[key, Value]

    // Generic methods
//    object MyList {
//      def empty[A]: Mylist[A] = ???
//    }
//    val emptyListOfIntegers = MyList.empty[Int]

    // Variable problem
    /* If Cat extends Animal, does a List[Cat] extends a List[Animal] ?
    * There are three answers to this question.
    * 1. Yes, List[Cat] extends List[Animal]. This is called a Co-variant List.
    * 2. No, a List[Cat] and List[Animal] are two different things. This is called an Invariant List.
    * 3. Not at all! This is called an Contravariant List.
    */
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. Covariant List
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // Can we add a new Dog to that list? It is not a trivial question.
    // Adding a Dog into a List[Cat], will transform it into a List[Animal], something more generic.
    // This is a small tast of the covariance problem that you need to solve,
    // when working with covariant collection.

    // 2. InvariantList
    class InvariantList[A]
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

    // 3. ContravariantList
    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]

    // Bounded types
    // Allows you to use your generic classes only for certain type that are either
    // a subclass of a different type, or a super class of a different type.
    // Ex: Cage accepts a type A, that is only a subtype of Animal
    class Cage[A <: Animal](animal: A)
    val cage = new Cage(new Dog)

    // The contrary, ie., a Cage accepts only something that is a supertype of Animal
    //class Cage_2[A : Animal](animal: A)

    // Bounded type solves a variance problem, which is very very annoying,
    // when we want to write covariant collections.

    //

}

















