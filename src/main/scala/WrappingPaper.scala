object WrappingPaper {
  def presentsFrom(input: String) = {
    input.split("\n").map(XMasPresent.apply)
  }

  def ribbonFor(present: XMasPresent) = {
    val dimensions = List(present.height,present.width,present.length)
    val smallestTwoDimensions = dimensions.sorted.take(2)
    val ribbon = smallestTwoDimensions.sum  * 2

    val bow = present.height * present.width * present.length

    ribbon + bow
  }

  def sqFeetFor(present: XMasPresent) = {
    val sides = List(
      present.length * present.width,
      present.width * present.height,
      present.height * present.length
    )
    2 * sides.sum + sides.min
  }
}

object XMasPresent {
  def apply(s: String) = {
    val dimensions = s.split("x").map(_.toInt)
    new XMasPresent(dimensions(0), dimensions(1), dimensions(2))
  }
}

case class XMasPresent(length: Int, width: Int, height: Int)
