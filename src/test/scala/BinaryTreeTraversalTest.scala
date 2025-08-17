class BinaryTreeTraversalTest extends UnitSpec {
  "BFS traversal on a binary tree" should {
    "return the expected result" in {
      val testData = Table(
        ("tree", "expected"),
        (
          MyTreeNode(
            3,
            Some(MyTreeNode(9, None, None)),
            Some(
              MyTreeNode(
                20,
                Some(MyTreeNode(15, None, None)),
                Some(MyTreeNode(7, None, None))
              )
            )
          ),
          List(List(3), List(9, 20), List(15, 7))
        ),
        (
          MyTreeNode(
            1,
            Some(MyTreeNode(2, Some(MyTreeNode(3, None, None)), None)),
            None
          ),
          List(List(1), List(2), List(3))
        ),
        (
          MyTreeNode(
            1,
            None,
            Some(MyTreeNode(2, None, Some(MyTreeNode(3, None, None))))
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
