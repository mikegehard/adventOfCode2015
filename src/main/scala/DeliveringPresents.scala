import scala.collection.immutable.IndexedSeq

object DeliveringPresents {
  def uniqueHousesWithRoboSanta(travelPattern: String): Int = {
    val santaPath = pathFor(offsets(travelPattern), evenIndex)
    val roboSantaPath = pathFor(offsets(travelPattern), oddIndex)

    val santaHousesVisited = housesVisited((0,0), santaPath)
    val roboSantaHousesVisited = housesVisited((0,0), roboSantaPath)

    uniqueHouses(santaHousesVisited ++ roboSantaHousesVisited)
  }

  def uniqueHousesSolo(travelPattern: String): Int = {
    uniqueHouses(housesVisited((0, 0), offsets(travelPattern)))
  }

  def uniqueHouses(houses: Seq[(Int, Int)]): Int = houses.distinct.length

  def pathFor(path: IndexedSeq[(Int, Int)], predicate: Int => Boolean): IndexedSeq[(Int, Int)] = {
    path.zipWithIndex.filter((element) => predicate(element._2)).map(_._1)
  }

  def offsets(travelPattern: String): IndexedSeq[(Int, Int)] = travelPattern.map(offsetFor)

  def evenIndex(index: Int) = index % 2 == 0
  def oddIndex(index: Int) = !evenIndex(index)

  def offsetFor(c: Char) = c match {
    case '^' => (0, 1)
    case '>' => (1, 0)
    case 'v' => (0, -1)
    case '<' => (-1, 0)
  }

  def housesVisited(startingCoordinate: (Int, Int), offsets: Seq[(Int, Int)]): Seq[(Int, Int)] = {
    offsets.foldLeft(List(startingCoordinate))((coordinates, nextOffset) => {
      coordinates :+(coordinates.last._1 + nextOffset._1, coordinates.last._2 + nextOffset._2)
    })
  }
}
