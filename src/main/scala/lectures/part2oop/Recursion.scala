package lectures.part2oop

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorila of " + n + " - I first need a factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  }

  println(factorial(10))
  //println(factorial(5000))  //Thid gives stackOverFlow


  /*
  * anotherfactorial(10) =factHelper(10, 1)
  * = factHelper(9, 9 * 10 * 1
  * = factHelper(8, 8 * 9 * 10 *1)
  * = facthelper(7, 7 * 8 * 9 * 10 * 1)
  * = .......
  * = factHelper(2, 3 * 4 ....* 10 * 1)
  * = facthelper(1, 1* 2 * 3 * 4 *.... * 10)
  * = 1 * 2 * 3 * 4 * ... * 10
  *
   */

  def anotherfactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //TAIL RECURSION =use reursive call as the LAST expression

    factHelper(n, 1);
  }

  println(anotherfactorial(20000))
  // WHEN YOU NEED LOOPS USE TAIL RECURSION

  /*
   * 1 Concatinate a string n times
   * 2 IsPrime function tail recursive
   * 3 Fibonnaci function, tail recursive
   */

  def concatinateTailrec(s: String, n: Int): String = {
    @tailrec
    def concatHelper(t: Int, accumulator: String): String = {
      if (t <= 1) accumulator
      else concatHelper(t - 1, accumulator + " " + s)
    }

    concatHelper(n, s)
  }

  def concatinateBetterTailrec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatinateBetterTailrec(aString, n - 1, aString + accumulator)
  }

  println(concatinateTailrec("hello", 5))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(529))

  def fibbionaci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)


  }

  println(fibbionaci(8))
}
