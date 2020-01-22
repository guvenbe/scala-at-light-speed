package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
  //use the type A
    def add[B >: A](element: B): MyList[B] =  ???

  }

  class MyMAP[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //generic methods
  object MyList {
    def empty[A] :MyList[A] = ???
  }

  val empyListOfIntegers = MyList.empty[Int]

  //varienace problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ??? HARD QUESTION  => we return a list of animals

  //2. no= INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  //3. Hell no! Contravarience
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A<: Animal](animal: A)
  val cage = new Cage(new Dog)

  //expand MyList to ne generic


}
