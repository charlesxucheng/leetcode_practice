import scala.annotation.tailrec

object ValidateBST {
  def isValidBST(root: Option[MyTreeNode]): Boolean = {

    // Each queue item stores the node and the min/max values that the subtree starting from that node is allowed to have
    @tailrec
    def isValidBSTRec(
        queue: List[(MyTreeNode, Option[Int], Option[Int])]
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
      case None       => true
      case Some(node) => isValidBSTRec(List((node, None, None)))
    }
  }

}
