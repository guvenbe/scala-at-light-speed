package com.rockthejvm

object ObjectOrientation extends App {
  class Animal{
    //define fields
    val age: Int =0
    //define methods
    def eat() = println("I'm eating as an Animal")

  }

  val anAnimal = new Animal
  class Dog extends Animal

  class Dog2(val name: String) extends Animal{
    override def eat(): Unit = println("I'm eating as a dog")
  }
  val aDog = new Dog2("Lassie")

  //Constructor argument are not fields: need to put a val before the constructor argument
  aDog.name

  // subtype polymorphism

  val aDeclaredAnimal: Animal = new Dog2("Hachi")
  aDeclaredAnimal.eat() //The most derived method will be called runtime

  //abstract class

  abstract class WalkingAnimal {
    val hasLegs =true //by default public can restrict by adding protected(class and all it's decendents have access or private(only class has access)
    def walk() : Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  // single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I'm eating you, animal")

    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")

  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with one argument
  aCroc ?! "What if we could fly"

  //operators in scala are actually methods
  val basicMath= 1 + 2
  val anotherBasicMath = 1.+(2)

  //anonymous

  val dinasour = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can pretty much aeat anyting")
  }


/*
//   Same as above: what you tell the compiler
   class Carnivore_Anonymous_35728 extends Carnivore{
    override def eat(animal: Animal): Unit = println("I am a dinosaur I can pretty much eat anything")

  }

  val dinosour = new Carnivore_Anonymous_35728
  */


  // Singleton object
  object MySingleton {
    // the only instance of the MySingleton type
    val mySpecialValue = 53278
    def mySpecialMethod() : Int=5327
    def apply(x: Int): Int= x+1 //S[ecial method

  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) //Calls apply equivalent to MySingleton.apply(65)

  object Animal{
    //Companions can access each other'sprivate field/methods
    //singleton Animal and instances of Animals are diferent things
    val canLiveIndefinetly = false
  }

  val animalsCanLiveForEver = Animal.canLiveIndefinetly  //"static" fields methods

  /*
    case class - lightweight data structures with some biolerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    - pattern matching
  */

  case class Person(name: String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) //Person.apply("Bob", 54)

  // exceptions

  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  }finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T]{
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3) //List.apply(1,2,3)
  val first = aList.head //Int
  val rest = aList.tail
  val  aStringList = List("hello", "Scala")
  val firstString = aStringList.head

  //Point #1: in scala we usually operate with IMMUTABLE values
  //Any modification to an object must return ANOTHER object
  /*
    1) work miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse //Retruns a new list

  // Point #2 Scala is closest to the OO ideal

}
