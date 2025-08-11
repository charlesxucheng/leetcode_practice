class BinaryTreeLowestCommonAncestorTest extends UnitSpec {
  "Finding the lowest common ancestor" when {
    "the tree is empty" should {
      "return None" in {
        BinaryTreeLowestCommonAncestor.lowestCommonAncestor(
          None,
          1,
          2
        ) mustBe None
      }
    }

    "when the tree has exactly these two nodes" should {
      "return root note" in {
        val root = TreeNode(1, None, Some(TreeNode(2, None, None)))
        val tree = Some(root)
        BinaryTreeLowestCommonAncestor.lowestCommonAncestor(
          tree,
          1,
          2
        ) mustBe tree

        val root2 = TreeNode(2, Some(TreeNode(1, None, None)), None)
        val tree2 = Some(root2)
        BinaryTreeLowestCommonAncestor.lowestCommonAncestor(
          tree2,
          1,
          2
        ) mustBe tree2
      }
    }
  }
}
