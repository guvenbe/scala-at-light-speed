package lectures.part2oop


import playground.{PrinceCharming, Cinderella => Princess}
import java.util.Date
import java.sql.{Date => SqlDate}

object PakagingAndImports extends App {

  //package members are accessible byu their simple name

  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  //import the package
  //ma
  val cinderell = new Princess

  //packages are in hierarchy
  //matching folder structure

  //package object
  sayHello
  println(SPEED_OF_LIGHT)


  //imports
  val prince = new PrinceCharming

  val date = new Date()
  val sqlDate = new SqlDate(2018, 5, 5)

  //  default imports
  //java.lang - String, object, exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???


}
