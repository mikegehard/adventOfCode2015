object DeliveringPresents {
  def uniqueHouses(travelPattern: String) = {
    housesVisited((0, 0), travelPattern.map(offsetFor)).distinct.length
  }

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
