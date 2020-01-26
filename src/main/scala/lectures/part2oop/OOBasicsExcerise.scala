package lectures.part2oop

object OOBasicsExcerise extends App {
  val writerBora = new Writer("Bora", "Guven", 1966)

  println(writerBora.fullName())

  val novelScalaByBora = new Novel("Scala Book", 2014, writerBora)

  println(s"Author Age= " + novelScalaByBora.authorAge())
  println(novelScalaByBora.isWritenBy(writerBora))

  val novelScalaByBoraCopy = novelScalaByBora.copy(2020)

  println(s"copy = ${novelScalaByBoraCopy.Name}, ${novelScalaByBoraCopy.yearOfRelease} ${novelScalaByBoraCopy.author.fullName()}")

  val counter = new Counter

  counter.inc.print
  counter.inc(7).print


  counter.dec.print
  counter.dec(4).print
}

class Writer(val firstName: String
             , val surname: String
             , val year: Int) {

  def fullName(): String = {
    firstName + " " + surname
  }

}

class Novel(val Name: String
            , val yearOfRelease: Int
            , val author: Writer) {

  def authorAge(): Int = this.yearOfRelease - this.author.year

  def isWritenBy(author: Writer): Boolean =
    author.firstName == this.author.firstName &&
      author.surname == this.author.surname &&
      author.year == this.author.year

  def copy(newYear: Int): Novel = new Novel(this.Name, newYear, this.author)

}

class Counter(val count: Int = 0) {
  //immutabillity
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter =
    if (n <= 0) this
    else inc.inc(n - 1)

  def dec(n: Int): Counter =
    if (n <= 0) this
    else dec.dec(n - 1)

  def print = println(count)
}
