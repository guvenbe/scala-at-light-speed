package part2fp

object WhatsAFunction extends App {
  // DREAM: use functions as first class elements
  // problem: oop
  val doubler = new MyFunction[Int, Int]{
    override def apply(element: Int): Int = element*2
  }

  println(doubler(2))

  //funtion types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder:((Int,Int) =>Int) =  new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int):Int = a+b
  }
  // Function types Function2[A,B,R] == (A, B) => R
  //All scala functions are objects
  /*
   1. define a function which takes 2 strings and concatinates them
   2. transfom the MyPredicate and MyTransformer into function types
   3 define function which takes an int and returns another function whichj takes an int and return an int
     - what's the type of this function
     - how to do it
   */
}

trait MyFunction[A,B] {
  def apply(element: A): B

  def strConcat: (String, String) =>String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(strConcat("asdf", "qwer" ))

  //Finction1[Int, Function1[Int, Int]]

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]]{
    override def apply(x: Int): Int => Int = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println("cuuried=" + superAdder(3)(4)) //curried functions


  val superAdder2 = (x: Int) =>(y:Int)=>x + y
  println(superAdder2(2)(3))
}

