import scala.annotation.tailrec

/** LeetCode definition for a binary tree node - I think it sucks so not
  * following it.
  *
  * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode =
  * null) { var value: Int = _value var left: TreeNode = _left var right:
  * TreeNode = _right }
  */

case class TreeNode(value: Int, left: Option[TreeNode], right: Option[TreeNode])

object ValidateBST {
  def isValidBST(root: Option[TreeNode]): Boolean = {

    // Each queue item stores the node and the min/max values that the subtree starting from that node is allowed to have
    @tailrec
    def isValidBSTRec(
        queue: List[(TreeNode, Option[Int], Option[Int])]
    ): Boolean = {
      queue match {
        case Nil                      => true
        case (node, min, max) :: tail =>
          if (min.exists(_ > node.value) || max.exists(_ < node.value)) false
          else {
            val newQueue = tail
              ++ node.left.map((_, min, Some(node.value)))
              ++ node.right.map((_, Some(node.value), max))
            isValidBSTRec(newQueue)
          }
      }
    }
    
    root match {
      case None => true
      case Some(node) => isValidBSTRec(List((node, None, None)))
    }
  }

}
