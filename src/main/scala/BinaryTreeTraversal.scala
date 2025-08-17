import scala.annotation.tailrec

object BinaryTreeTraversal {

  def levelOrder(root: Option[TreeNode]): List[List[Int]] = bfs(root)

  private def bfs(root: Option[TreeNode]): List[List[Int]] = {

    @tailrec
    // The pairs returned are (level, value)
    def bfsRec(
        queue: List[(Int, TreeNode)],
        acc: List[(Int, Int)]
    ): List[(Int, Int)] = {
      queue match {
        case Nil          => acc.reverse
        case head :: tail =>
          val currentLevel = head._1
          val newAcc = (currentLevel, head._2.value) :: acc
          val newQueue = tail ::: List(head._2.left, head._2.right).flatten
            .map((currentLevel + 1, _))
          bfsRec(newQueue, newAcc)
      }
    }
    if root.isEmpty then List()
    else
      bfsRec(List((1, root.get)), List())
        .groupBy(_._1)
        .map(_._2.map(_._2))
        .toList
  }
}
