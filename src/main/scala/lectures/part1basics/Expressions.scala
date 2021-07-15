package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 //Expressio
  println(x)

  // Precidence + - * / & | ^ << >> >>>(right shift with zero extension
  println(2 + 4 * 4) //expression

  // precedence == !=  => < <=
  println(1 == x)

  println(!(1 == x))

  //also works shift
  var aVariable = 2
  aVariable += 3 //also works with -= *- /= ........side effects
  println(aVariable)

  //Instruction (DO) imperitive  vs Expression (VALUE)

  // IF expression

  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 //IF Expression
  println(aConditionedValue)

  println(if (aCondition) 5 else 3)

  //Loops are discouraged

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //NEVER WRITE THIS AGAIN...That IS imperitive programming
  //  EVERYTHING IN SCALA is a expression
  val awierValue = (aVariable = 3) //Unit == void
  println(awierValue) //Rerturns scala "()"

  // side effects are println, whiles, reassignment

  //Codel blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  //1. difference between "hello world"  <= is a value of string
  // vs
  // println("hello world")    <= return side effect unit

  //2)
  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
