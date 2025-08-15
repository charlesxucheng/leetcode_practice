class KthLargestInStreamTest extends UnitSpec {
  "Finding the kth largest element in a stream" should {
    "return the expected result" in {
      val testData = Table(
        ("nums", "k", "added nums", "expected"),
        (Array.empty[Int], 1, Array(-3, -2, -4, 0, 4), Array(-3, -2, -2, 0, 4)),
        (Array(4, 5, 8, 2), 3, Array(3, 5, 10, 9, 4), Array(4, 5, 5, 8, 8)),
      )
      forAll(testData) { (nums, k, addedNums, expected) => {
        val kthLargest = new KthLargestInStream(k, nums)
        for (n <- addedNums) {
          kthLargest.add(n) mustBe expected(addedNums.indexOf(n))
        }
      }
      }
    }
  }
}
