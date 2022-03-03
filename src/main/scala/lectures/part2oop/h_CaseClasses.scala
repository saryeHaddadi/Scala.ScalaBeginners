package lectures.part2oop

object h_CaseClasses extends App {

    case class Person(name: String, age: Int)

    // 1. class parameters are promoted to fields
    val jim = new Person("Jim", 34)
    println(jim.name)

    // 2. sensible toString
    println(jim.toString)

    // 3. equals and hascode implemented out-of-the-box OOTB
    // which makes case classes especially important for use in collections
    val jim2 = new Person("Jim", 34)
    println(jim == jim2)

    // 4. cases classes have handy copy method
    val jim3 = jim.copy(age=45)
    println(jim3)

    // 5. case classes have companion objects
    val thePerson = Person

    // 6. reminder: the companion object apply method does the same thing as a constructor
    // so, no need to use the keyword new
    val mary = Person("mary", 23)

    // 7. case classes are serizable
    // this is important for distributed systems,
    // and makes you able to send instances of case classes through the network in between two JVMs
    // For instance, this is important when dealing with the Akka framework.
    // The Akka deals with sending serializable messages through the network,
    // and the message you send in practice, generally, case classes.

    // 8. case classes have extractor patterns, meaning, CCs can be used in Pattern Matching

    // note: we talked about case classes, there are also case objects.
    // Are the same, but do not have a companion object, given they themself are the Object.
    case object UnitedKingdom {
      def name: String = "The UK of GB and NI"
    }





}
