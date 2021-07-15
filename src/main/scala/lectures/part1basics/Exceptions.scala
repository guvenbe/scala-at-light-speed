package lectures.part1basics

object Exceptions extends App {

  val x: String = null
  //  println(x.length)

  //println(x.length) ^^ wil crash with a NPE

  // 1 throwing and catching exceptions

  //  val aWierdValue: String  = throw new NullPointerException
  // throwable classes extend the Throwable class
  // Exception and Error are the majoer Throwable subtypes

  // 2 how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    //code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("caught an runtime exception")
  } finally {
    //copde that will get excecuted NO MATTER WHAT
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("finally")
  }

  //How to define your own excpetions
  class MyException extends Exception

  val exceptions = new MyException

  //throw exceptions

  /*
    1 crash your program with an OutOfMemoryError
    2 crash with SOError
    3 pocket Calculator
        -add(x,y)
        -subtract(x,y)
        -multiply(x,y)
        -divide(x,y)

        Throw
        -overflowException if ad(x,y) exceed Int.MAX_VALUE
        -underflowException if substract(x,y) exceeds Int.MIN_VALUE
        -MathCalculationException for division by 0
   */

  //OOM
  //val array= Array.ofDim(Int.MaxValue)

  //SO
  //  def infinite: Int = 1+ infinite
  //  val noLimit =infinite

  class OverFlowException extends RuntimeException

  class UnderFlowException extends RuntimeException

  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverFlowException()
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result

    }

    def substract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else if (x < 0 && y > 0 && result > 0) throw new OverFlowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  //  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))


}


