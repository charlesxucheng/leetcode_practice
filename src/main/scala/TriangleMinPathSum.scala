//https://leetcode.com/problems/triangle/
object TriangleMinPathSum {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val minSum = triangle.last.toArray
    for (i <- triangle.length - 2 to 0 by -1)
      for (j <- triangle(i).indices)
        minSum(j) = triangle(i)(j) + minSum(j).min(minSum(j + 1))
    minSum(0)
  }
}