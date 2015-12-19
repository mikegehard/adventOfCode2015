object NotQuiteLisp {
  def entersBasementAt(s: String) = s.map(valueFor).foldLeft(List[Int]())((acc, value) => {
    acc match {
      case Nil => acc :+ value
      case _ => acc :+ (acc.last + value)
    }
  }).indexOf(-1) + 1

  def floorFor(s: String) = s.map(valueFor).sum

  def valueFor(c: Char) = if (c == '(') 1 else -1
}
