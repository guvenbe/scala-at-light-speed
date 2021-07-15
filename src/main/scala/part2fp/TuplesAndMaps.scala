package part2fp

import scala.annotation.tailrec

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists
  val aTupleV1 = new Tuple2(2, "hello scala") //Tuple2[Int, string] = (Int, String)
  val aTupleV2 = Tuple2(2, "hello scala")
  val aTupleV3 = (2, "hello scala")

  println(aTupleV1._1) // 2
  println(aTupleV1.copy(_2 = "goodbye Java"))
  println(aTupleV1.swap) //("hello scalla, 2)

  //Maps - Key -> values
  val aMap: Map[String, Int] = Map()
  val aPhoneBook1 = Map[String, Int]()
  val aPhoneBook = Map(("Jim", 555), ("JIM", 9000), "Daniel" -> 789).withDefaultValue(-1)
  //a->b is sugar for (a, b)
  println(aPhoneBook)
  println(aPhoneBook.contains("Jim"))
  println(aPhoneBook("Jim"))
  println(aPhoneBook("Marry"))
  //add paring
  val newPairing = "Marry" -> 678
  val newPhoneBook = aPhoneBook + newPairing;

  //functional om maps
  //map, flatMap, filter
  println(aPhoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  println(aPhoneBook)
  println(aPhoneBook.view.filterKeys(x => x.startsWith("J")).toMap)
  println(aPhoneBook.view.filterKeys(_.startsWith("J")).toMap)

  //mapValues
  println(aPhoneBook.view.mapValues(number => number * 10).toMap)
  println(aPhoneBook.view.mapValues(number => "0245" + number).toMap)

  //conversion to other collection
  println(aPhoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
      1. What would happen if I had two original entries "Jim" -> 555 and "JIM -> 900?
      !!! careful with mapping keys
      2. Over simplified social network based on maps
         Person = String
         - add a person to the networl
         - remove
         - friend (mutula)
         - unfriend

         - number of friends of a person
         - person with mosy friends
         - how many people have NO fiends
         - if there is a social connection two people (direct or not)
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA + b)) + (b -> (friendB + a))
  }

  def unFriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendA = network(a)
    val friendB = network(b)

    network + (a -> (friendA - b)) + (b -> (friendB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unFriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unFriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
  //network.view.filterKeys(k => network(k).size == 0).size
  //network.view.filterKeys(k=> network.isEmpty).size
  //network.filter(pair =>pair._2.isEmpty).size
    network.filter(_._2.isEmpty).size

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    //breadth search first
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))
}

