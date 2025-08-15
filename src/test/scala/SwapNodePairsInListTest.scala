class SwapNodePairsInListTest extends UnitSpec {
  "Swapping node pairs in a linked list" when {
    "the list is empty" should {
      "return None" in {
        SwapNodePairsInList.swapPairs(null) mustBe null
      }
    }

    "the list has one node" should {
      "return the same node" in {
        val node = new ListNode(1)
        SwapNodePairsInList.swapPairs(node) mustBe node
      }
    }

    "the list has even number of nodes" should {
      "return the expected result" in {
        val testData = Table(
          ("list", "expected"),
          (
            ListNode(1, ListNode(2, ListNode(3, new ListNode(4)))),
            ListNode(2, ListNode(1, ListNode(4, new ListNode(3))))
          )
        )

        forAll(testData) { (list, expected) =>
          SwapNodePairsInList.swapPairs(list) mustBe expected
        }
      }
    }

    "the list has odd number of nodes" should {
      "return the expected result" in {
        val testData = Table(
          ("list", "expected"),
          (
            ListNode(1, ListNode(2, ListNode(3, ListNode(4, new ListNode(5))))),
            ListNode(2, ListNode(1, ListNode(4, ListNode(3, new ListNode(5)))))
          )
        )

        forAll(testData) { (list, expected) =>
          SwapNodePairsInList.swapPairs(list) mustBe expected
        }
      }
    }

  }
}
