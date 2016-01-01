import java.security.MessageDigest

object AdventCoins {
  def smallestNumber(secretKey: String, numberOfZeros: Int) = {
    Stream.from(1).takeWhile(!md5Hash(secretKey, _).startsWith("0" * numberOfZeros)).last + 1
  }

  def md5Hash(key: String, number: Int): String = {
    val stringToHash = key ++ number.toString
    MessageDigest.getInstance("MD5").digest(stringToHash.getBytes()).map("%02X".format(_)).mkString
  }
}
