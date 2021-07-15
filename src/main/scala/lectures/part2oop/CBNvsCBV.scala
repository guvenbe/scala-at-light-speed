package lectures.part2oop

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite() //cause stack overflow
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) //Stack overflow
  printFirst(34, infinite())

}
