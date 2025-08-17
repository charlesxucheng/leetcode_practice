import scala.annotation.tailrec



object BinaryTreeTraversal {

  def levelOrder(root: Option[TreeNode]): List[Int] = bfs(root)

  private def bfs(root: Option[TreeNode]): List[Int] = {
    @tailrec
    def bfsRec(queue: List[TreeNode], acc: List[Int]): List[Int] = {
      queue match {
        case Nil => acc.reverse
        case head :: tail =>
          val newAcc = head.value :: acc
          val newQueue = tail ::: List(head.left, head.right).flatten
          bfsRec(newQueue, newAcc)
      }
    }
    if root.isEmpty then List()
    else 
    bfsRec(List(root.get), List())
  }
}
