
class BinaryTreeTraversalTest extends UnitSpec {
  "BFS traversal on a binary tree" should {
    "return the expected result" in {
      val testData = Table(
        ("tree", "expected"),
        (TreeNode(3, Some(TreeNode(9, None, None)), Some(TreeNode(20, Some(TreeNode(15, None, None)), Some(TreeNode(7, None, None))))), List(3, 9, 20, 15, 7)),
        (TreeNode(1, Some(TreeNode(2, Some(TreeNode(3, None, None)), None)), None), List(1, 2, 3)),
        (TreeNode(1, None, Some(TreeNode(2, None, Some(TreeNode(3, None, None))))), List(1, 2, 3)),
        (TreeNode(3, Some(TreeNode(9, None, None)), Some(TreeNode(20, Some(TreeNode(15, None, None)), Some(TreeNode(7, None, None))))), List(3, 9, 20, 15, 7)),
      )

      forAll(testData) { (root, expected) =>
        BinaryTreeTraversal.levelOrder(Some(root)) mustBe expected
      }
    }
  }

}
