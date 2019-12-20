package com.rockthejvm

object FunctionalProgramming extends App {

  //Scala is OO
  class Person(name: String){
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) //INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming
    - compose functions
    - pass functions as args
    - return functions as results

    Consclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementer = new Function1[Int,Int]{
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) //24
  simpleIncrementer(23)  // simpleIncrementer.apply(23)
  // define a functions!

  //ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  //Function with 2 arguments and a string return type String

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 +arg2
  }

  stringConcatenator("I love", " Scala")

  //syntax sugars

  val doubler: Function1[Int,Int] = (x:Int) =>2 * x

  doubler(4) //8

  //This is the same as

  /*
    val doubler: Function[int, Int] = new Function1[Int, Int] {
    override def apply (x: Int) = 2 * x
    }
  */

  //also
  val doubler2: Int => Int = (x: Int) => 2 * x
  val doubler3= (x: Int) => 2 * x

  // higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x +1) // HOF
  // same as : List[Int] = List(1,2,3).map(x => x +1) // HOF
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x=>List(x, 2 * x))
 // alternate syntax
  val aFlatMappedList2 = List(1,2,3).flatMap {
    x => List(x, 2 * x)
  }
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
  val aFilteredList2 = List(1,2,3,4,5).filter(_  <= 3)

  println(aFilteredList)

  val allPairs = List(1,2,3)
    .flatMap(number => List('a', 'b', 'c')
      .map(letter => s"$number-$letter"))
  println(allPairs)

  // For comprehensions

  val alternativepairs =  for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  //equivalent to the map/flatMap chain above

  println(alternativepairs)

  /**
   * Collections
   * */

  //list
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList //List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 //List(0,1,2,3,4,5,6)

  //Sequences
  val aSequence: Seq[Int] = Seq(1,2,3) //Seq,apply(1,2,3)
  val accessedElement = aSequence(1) //element at index 1: 2

  //vectors: fast Seq implementation
 val aVector = Vector(1,2,3,4,5)

  //sets = no duplicates
  val aSet = Set(1,2,3,4, 1,2,3) //Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val andAddedSet = aSet +5 //Set(1,2,3,4,5)
  val aRemovedSet = aSet -3 //Set(1,2,4)

  //Ranges

  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList //List(2,4,6,8,.....2000)

  //tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  //maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 6437812),
    ("Jane", 327285),
    ("Bora"->123456) //same as ("Bora", 123456)
  )


}
