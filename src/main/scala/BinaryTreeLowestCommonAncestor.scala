/** LeetCode definition for a binary tree node - I think it sucks so not
  * following it.
  *
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode =
  * null) { var value: Int = _value var left: TreeNode = _left var right:
  * TreeNode = _right }
  */

object BinaryTreeLowestCommonAncestor {
  def lowestCommonAncestor(
      root: Option[MyTreeNode],
      p: Int,
      q: Int
  ): Option[MyTreeNode] = {
    root match {
      case None       => None
      case Some(node) =>
        if (node.value == p || node.value == q) root
        else {
          val left = lowestCommonAncestor(node.left, p, q)
          val right = lowestCommonAncestor(node.right, p, q)
          if (left.isEmpty && right.isEmpty) None
          else if (left.isEmpty) right
          else if (right.isEmpty) left
          else root
        }
    }
  }
}
