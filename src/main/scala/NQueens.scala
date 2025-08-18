import scala.collection.mutable.ListBuffer

object NQueens {
  def solveNQueens(n: Int): List[List[(Int, Int)]] = {
    val result = ListBuffer.empty[List[(Int, Int)]]

    def placeQueen(
        row: Int,
        placements: List[(Int, Int)],
        colsOccupied: Array[Int],
        diagonalOccupied: Array[Int],
        antiDiagonalOccupied: Array[Int]
    ): Unit = {
      if (row == n) {
        result += placements
        return
      }
      (0 until n)
        .filter(col =>
          !(colsOccupied.contains(col) || diagonalOccupied
            .contains(row - col) || antiDiagonalOccupied.contains(row + col))
        )
        .foreach { col =>
          val newColsOccupied = colsOccupied :+ col
          val newDiagonalOccupied = diagonalOccupied :+ (row - col)
          val newAntiDiagonalOccupied = antiDiagonalOccupied :+ (row + col)
          placeQueen(
            row + 1,
            placements :+ (row, col),
            newColsOccupied,
            newDiagonalOccupied,
            newAntiDiagonalOccupied
          )
        }
    }

    placeQueen(0, List(), Array.empty[Int], Array.empty[Int], Array.empty[Int])
    result.foreach(printBoard)
    result.toList
  }

  private def printBoard(queens: List[(Int, Int)]): Unit = {
    val n = queens.length
    val board = Array.fill(n, n)('.')
    queens.foreach { case (row, col) =>
      board(row)(col) = 'Q'
    }
    board.map(_.mkString).foreach(println)
    println()
  }
}
