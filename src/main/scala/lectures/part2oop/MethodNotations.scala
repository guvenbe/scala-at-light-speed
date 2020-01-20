package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(nickName: String): Person = new Person(s"$name ($nickName)", favoriteMovie)

    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age+1)

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(times: Int):String = s"$name watched $favoriteMovie $times times"

    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala:String = learns("scala")

  }

  val marry = new Person("Marry", "Inception")
  println(marry.likes("Inception"))
  println(marry likes "Inception") //infix notation = operator notation (syntactic sugar)

  // Operator in scala
  val tom = new Person("Tom", "Fight Club", 45)
  println(marry + tom)
  println(marry.+(tom))

  println(1 + 2)
  println(1.+(2))

  //ALL OPERATOR ARE METHODS
  //Akka actors have ! ?

  //prefix notation
  val x = -1 //equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!marry)
  println(marry.unary_!)

  // postfix notation
  println(marry.isAlive)
  println(marry isAlive)

  // apply
  println(marry.apply())
  println(marry())

  println((marry + "the rockstar") ())
  println((marry + "the rockstar").apply())
  println((+ marry).age)
  println(marry learnsScala)
  println(marry(10))



}
