package lectures.part2oop

import javax.management.PersistentMBean

object i_Enums {

  enum Permission {
    // This will define the only possible instances of the Type
    case READ, WRITE, EXECUTE, NONE

    // Add fields/methods
    def openDocument(): Unit =
      if(this == READ) println("opening document...")
      else println("reading not allowed")
  }
  val somePermission: Permission = Permission.READ


  enum PermissionWithBit(bits: Int) {
    case READ extends PermissionWithBit(4) // 100
    case WRITE extends PermissionWithBit(2) // 010
    case EXECUTE extends PermissionWithBit(1) // 001
    case NONE extends PermissionWithBit(0) // 000
  }

  // Factory
  // You can use a companion object for an enum,
  // as a source for factory methods
  object PermissionWithBit {
    def fromBits(bits: Int): PermissionWithBit = //whatever
      PermissionWithBit.NONE
  }

  // Standard API for enum
  // - the ability to inspect the index, or ordinal,
  // at which that particular enum was defined.
  val somePermissionOrdinal = somePermission.ordinal
  // - the ability to iterate, or get a hold,
  // of all the possible values of an enums
  val allPermissions = PermissionWithBit.values // array of all possible values
  val readPremission: Permission = Permission("READ") // Permission.READ

  def main(args: Array[String]): Unit = {
    somePermission.openDocument()
    println(somePermissionOrdinal)
  }

}
