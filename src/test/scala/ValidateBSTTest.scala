class ValidateBSTTest extends UnitSpec {
  "Validating an empty tree" should {
    "return true" in {
      ValidateBST.isValidBST(None) mustBe true
    }
  }

  "Validating a single node tree" should {
    "return true" in {
      ValidateBST.isValidBST(Some(TreeNode(1, None, None))) mustBe true
    }
  }

  "Validating a valid tree" should {
    "return the expected result" in {
      val testData = Table(
        ("tree", "expected"),
        (TreeNode(2, Some(TreeNode(1, None, None)), Some(TreeNode(3, None, None))), true),
        (TreeNode(5, Some(TreeNode(1, None, None)), Some(TreeNode(6, None, None))), true),
        (TreeNode(5, Some(TreeNode(1, None, None)), Some(TreeNode(6, Some(TreeNode(3, None, None)), None))), false),
        (TreeNode(5, Some(TreeNode(1, None, None)), Some(TreeNode(4, Some(TreeNode(3, None, None)), Some(TreeNode(6, None, None))))), false)
      )

      forAll(testData) { (root, expected) =>
        ValidateBST.isValidBST(Some(root)) mustBe expected
      }
    }
  }

}
