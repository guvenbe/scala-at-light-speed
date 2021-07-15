package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  //"pseudo-colletions" : Option, Try

  def methodWhichCanReturnNull(): String = "hello scala"

  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, scala")
  //option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string: String) => s"I have obtained a valid string: $string"
    case None => "I have obtained nothing"
  }

  //map, flatmap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException

  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against this evil exception"
  }

  //Instead scala way
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collectio with either a value if the coce went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(vaildValue) => s"I have obtained a valid string: $vaildValue"
    case Failure(ex) => s"I have obtained an exception $ex"
  }

  /**
   * Evaluate something on another thread
   * (asyncronous programming
   **/


  val aFuture = Future { //Future.apply
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }

  Thread.sleep(2000)
  //future is a "collection which contains a value when it's evaluated
  //future is composable with map, flatmap and filter
  //monads

  /**
   * Implicits basics
   **/

  //#1: implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1

  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(myImplicitInt)

  //#2 implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23).isEven()
  //Use this carefully


}
