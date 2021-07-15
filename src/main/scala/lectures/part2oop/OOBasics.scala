package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  println(person.greet("Bora"))
  println(person.greet())
}

//Constructor
class Person(name: String, val age: Int) {
  //Body
  val x = 2
  println(1 + 3) //On instantiation this gets executed

  def greet(name: String): Unit = println(s"${this.name} says HI, $name")

  //overloading
  def greet(): Unit = println(s"Hi, Iam $name") //This implies this.name

  //Multiple constructor
  def this(name: String) = this(name, 0)


}

// class parameter are not fiels