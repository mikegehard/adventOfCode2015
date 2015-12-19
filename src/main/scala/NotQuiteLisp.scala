object NotQuiteLisp {
  def entersBasementAt(s: String) = s.map(valueFor).map {
    // this is a little magical but I believe it has to do
    // with closing over the mutable sum variable.
    var sum = 0; value => {
      sum += value; sum
    }
  }.indexOf(-1) + 1

  def floorFor(s: String) = s.map(valueFor).sum

  def valueFor(c: Char) = if (c == '(') 1 else -1
}
