package lectures.part2oop



object Inheritence extends App {

  //single class inheritence
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends  Animal{
    def crunch = {
      eat
      println(" crunch, crunch")
    }
  }

  val cat = new Cat
  cat.eat

  //constructors
  class Person(name: String, age: Int){
    def this(name: String) =this(name, 0)

  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  //overrding
  class Dog(override val creatureType: String) extends Animal{
    //override val creatureType: String = "domestic"
    override def eat: Unit = {
      super.eat
      println("crunch crunch ")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //type substitution (Broad: polymorhism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //preventing overrides
  //1 - user final on member
  //2 - use final on the entire class
  //3 - seal the class = you extend classes in this file, prevent extesion in other files

  //overriding vs overloading
  //super

}




