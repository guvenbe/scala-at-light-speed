package part2fp

object AnonymousFunctions extends App {
  //  val doubler = new Function[Int, Int] {
  //    override def apply(x: Int): Int = x * 2
  //  }

  //Anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2

  //multiple lambda parameters
  val adder = (a: Int, b: Int) => a + b

  //no params
  val justDoSomething = () => 3
  println(justDoSomething) //function itself
  println(justDoSomething()) //call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  val niceIncrementer2: Int => Int = x => x + 1
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x=> x + 1

  val niceAdder: (Int, Int) => Int = (a, b) => a + b
  val niceAdder2: (Int, Int) => Int = _ + _ //equivalent to (a, b) => a + b

  /*
  1) Mylist: replace all FunctionX calls woth lambdas
  2) rewrite the special adder as ab anonymous function
   */
}
