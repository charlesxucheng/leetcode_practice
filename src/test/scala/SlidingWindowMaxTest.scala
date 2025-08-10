import SlidingWindowMax.*

class SlidingWindowMaxTest extends UnitSpec {

  "SlidingWindowMax" should {
    "return the input list when k = 1" in {
      val testData = Table(
        ("input", "expected"),
        (Array(1), Array(1)),
        (Array(1, 2, 3, 4, 5), Array(1, 2, 3, 4, 5))
      )
      forAll(testData) { (input, expected) =>
        val actual = maxSlidingWindow(input, 1)
        actual mustBe input
      }
    }

    "return empty when k is larger than the input list" in {
      val input = Array(1, 2, 3, 4, 5)
      an[IllegalArgumentException] should be thrownBy {
        maxSlidingWindow(input, 6)
      }
    }

    "return the correct result when k is between 2 and the input list length - 1" in {
      val testData = Table(
        ("input", "windowSize", "expected"),
        (Array(1, 3, -1, -3, 5, 3, 6, 7), 3, Array(3, 3, 5, 5, 6, 7)),
        (Array(7, 2, 4), 2, Array(7, 4)),
        (
          Array(1, 3, 2, 6, 7, 10, 9, 12, 16, 15),
          4,
          Array(6, 7, 10, 10, 12, 16, 16)
        ),
        (Array(1,3,1,2,0,5), 3, Array(3,3,2,5))
      )
      forAll(testData) { (input, k, expected) =>
        val actual = maxSlidingWindow(input, k)
        actual mustBe expected
      }
    }

    "return IllegalArgumentException when windowSize is less than 1" in {
      val testData = Table(
        "windowSize",
        0,
        -1,
        -2,
        -3
      )
      forAll(testData) { windowSize =>
        {
          val input = Array(1, 2, 3, 4, 5)
          val actual = intercept[IllegalArgumentException] {
            maxSlidingWindow(input, windowSize)
          }
          actual.getMessage mustBe "requirement failed: Window size must be positive and less than the input size"
        }
      }
    }
  }
}
