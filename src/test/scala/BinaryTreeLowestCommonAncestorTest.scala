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
        val root = MyTreeNode(1, None, Some(MyTreeNode(2, None, None)))
        val tree = Some(root)
        BinaryTreeLowestCommonAncestor.lowestCommonAncestor(
          tree,
          1,
          2
        ) mustBe tree

        val root2 = MyTreeNode(2, Some(MyTreeNode(1, None, None)), None)
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
