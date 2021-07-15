package lectures.part2oop

object Objects extends App {

  //SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALLITY (static)
  object Person { //type + it's only instance
    // "static"/"class: = level functionality
    val N_EYES = 2

    def canFly: Boolean = false

    //factory ,ethod
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    //instance level functionality
  }

  //COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = SINGLETON INSTANCE
  val marry = new Person("Marry")
  val john = new Person("John")
  println(marry == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)
  val bobbie = Person(marry, john)

  //Scala Applications = Scala object with
  //def main(arg: Array[String]): Unit
}
