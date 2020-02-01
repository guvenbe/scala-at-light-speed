package part2fp

object MapFlatmapFilterFor extends App {

  //List
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  //Map
  println(list.map(_ + 1))
  println(list.map(_ + "is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  //print all combination between two list
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  //List (a1, a2, a3, a4)

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  //Iterating
  val combinations2 = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(colors => "" + c + n + "-" + colors)))
  println(combinations2)

  //foreach
  list.foreach(println)

  //for comrehensions

  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
  }

  /*
    MyList support for comprehension
    map(f: A=> B) => MyList[B]
    filter(p: A => MyList[B]) => MyList[B]

    2) A small collection of at most ONE element - Maybe[+T]
   */



}
