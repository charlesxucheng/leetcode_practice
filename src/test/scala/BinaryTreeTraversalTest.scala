class BinaryTreeTraversalTest extends UnitSpec {
  "BFS traversal on a binary tree" should {
    "return the expected result" in {
      val testData = Table(
        ("tree", "expected"),
        (
          TreeNode(
            3,
            Some(TreeNode(9, None, None)),
            Some(
              TreeNode(
                20,
                Some(TreeNode(15, None, None)),
                Some(TreeNode(7, None, None))
              )
            )
          ),
          List(List(3), List(9, 20), List(15, 7))
        ),
        (
          TreeNode(
            1,
            Some(TreeNode(2, Some(TreeNode(3, None, None)), None)),
            None
          ),
          List(List(1), List(2), List(3))
        ),
        (
          TreeNode(
            1,
            None,
            Some(TreeNode(2, None, Some(TreeNode(3, None, None))))
          ),
          List(List(1), List(2), List(3))
        )
      )

      forAll(testData) { (root, expected) =>
        BinaryTreeTraversal.levelOrder(Some(root)) mustBe expected
      }
    }
  }

}
