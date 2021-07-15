package lectures.part2oop

object CaseClasses extends App {

  /*
  equals hascode toString
   */

  case class Person(name: String, age: Int)

  // 1 class parameters are fileds
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)
  println(jim)

  //3 equals and hascode
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4 CC have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  //5 CC have companion object
  val thePerson = Person
  val mary = Person("Mary", 23)

  //6 CC are serializable
  //Akka

  //7 CC have extract patterns - CC can be used in PATTERN MATCHING

  //8 Also can have case objects //The don't get companion objects
  case object UnitedKingDom {
    def name: String = "The UK of GB and NI"
  }


}
