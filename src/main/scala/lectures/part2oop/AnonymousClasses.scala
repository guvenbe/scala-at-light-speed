package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  //anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahahaha")
  }
  /*
   queivalent with
   class AnonymousClasses$$anon$1 extends Animal
   override def eat: Unit = println("ahahahahahahahaha")

   val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"hi my name is $name, hos can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"hi my name is Jim, hos can of service?")
  }
}
