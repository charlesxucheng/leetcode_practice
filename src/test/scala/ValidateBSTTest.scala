class ValidateBSTTest extends UnitSpec {
  "Validating an empty tree" should {
    "return true" in {
      ValidateBST.isValidBST(None) mustBe true
    }
  }

  "Validating a single node tree" should {
    "return true" in {
      ValidateBST.isValidBST(Some(MyTreeNode(1, None, None))) mustBe true
    }
  }

  "Validating a valid tree" should {
    "return the expected result" in {
      val testData = Table(
        ("tree", "expected"),
        (
          MyTreeNode(
            2,
            Some(MyTreeNode(1, None, None)),
            Some(MyTreeNode(3, None, None))
          ),
          true
        ),
        (
          MyTreeNode(
            5,
            Some(MyTreeNode(1, None, None)),
            Some(MyTreeNode(6, None, None))
          ),
          true
        ),
        (
          MyTreeNode(
            5,
            Some(MyTreeNode(1, None, None)),
            Some(MyTreeNode(6, Some(MyTreeNode(3, None, None)), None))
          ),
          false
        ),
        (
          MyTreeNode(
            5,
            Some(MyTreeNode(1, None, None)),
            Some(
              MyTreeNode(
                4,
                Some(MyTreeNode(3, None, None)),
                Some(MyTreeNode(6, None, None))
              )
            )
          ),
          false
        )
      )

      forAll(testData) { (root, expected) =>
        ValidateBST.isValidBST(Some(root)) mustBe expected
      }
    }
  }

}
