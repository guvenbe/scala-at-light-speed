package com.rockthejvm

object PatternMatching extends App {
  // switch expression
  val anInteger = 55

  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  //PM is an expression
  println(order)

  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43) //Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi my name is $n and I am $a year old"
  }

  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belong to the genre $genre"
    case _ => "I don't know what you are talking about"
  }

  println(bandDescription)

  val aList = List(1, 2, 3)
  val listDescription = aList match {
    case List(_, 2, _) => "List constains 2 in it's second position"
    case _ => "unknown list"
  }
  // if PM doesn't match anything, it will throw a match error
  // PM will try all cases in sequence
  println(listDescription)

}