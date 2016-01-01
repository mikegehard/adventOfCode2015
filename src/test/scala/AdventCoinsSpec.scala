import org.scalatest.FunSpec

class AdventCoinsSpec extends FunSpec {
  // These take ~2 min to complete. Is there a way to
  // make it more efficient?

  // Can we use a divide and conquer strategy to get an upper and lower bound for the number
  // and then just brute force that range?

  // Tried:
  // 1. Storing instance of message digest in val -> no difference


  it("can determine the answer for the key abcdef") {
    assert(AdventCoins.smallestNumber("abcdef", 5) == 609043)
  }

  it("can determine the answer for the key pqrstuv") {
    assert(AdventCoins.smallestNumber("pqrstuv", 5) == 1048970)
  }

  it("can determine the answer for the key ckczppom with 5 zeros") {
    assert(AdventCoins.smallestNumber("ckczppom", 5) == 117946)
  }

  it("can determine the answer for the key ckczppom with 6 zeros") {
    assert(AdventCoins.smallestNumber("ckczppom", 6) == 3938038)
  }
}
