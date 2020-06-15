import org.scalatest._

class WubTest extends FlatSpec with Matchers {

  val tests = List(
    ("AWUBBWUBC", "A B C", "WUB should be replaced by 1 space"),
    ("AWUBWUBWUBBWUBWUBWUBC", "A B C", "multiples WUB should be replaced by only 1 space"),
    ("WUBAWUBBWUBCWUB", "A B C", "heading or trailing spaces should be removed")
  )

  tests.foreach {
    case (input, expected, message) =>
      s"songDecoder($input)" should s"return $expected" in {
        withClue(message) { Wub.songDecoder(input) should be (expected) }
      }
  }
}