import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object ParenthesisGeneration {
  def generateParenthesis(n: Int): List[String] = {
    @tailrec
    def generateParenthesisRec(
        workInProgress: List[(String, Int, Int)],
        completed: List[String]
    ): List[String] =
      workInProgress match {
        case Nil          => completed
        case head :: tail =>
          val (str, open, close) = head
          assert(open >= 0 && close >= 0)
          if (open == 0 && close == 0)
            generateParenthesisRec(tail, str :: completed)
          else {
            var newWorkInProgress = ListBuffer[(String, Int, Int)]()
            if (open > 0)
              newWorkInProgress =
                newWorkInProgress.append((str + "(", open - 1, close))
            if (close > 0 && open < close)
              newWorkInProgress =
                newWorkInProgress.append((str + ")", open, close - 1))
            generateParenthesisRec(tail ::: newWorkInProgress.toList, completed)
          }
      }

    if (n == 0) return List.empty
    generateParenthesisRec(List(("", n, n)), List.empty)
  }
}
