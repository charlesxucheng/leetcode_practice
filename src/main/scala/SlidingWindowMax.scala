import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object SlidingWindowMax {
  def maxSlidingWindow(numbers: Array[Int], k: Int): Array[Int] = {
    require(
      k > 0 && k <= numbers.length,
      "Window size must be positive and less than the input size"
    )
    if (k == 1) return numbers

    val q = mutable.ArrayDeque.empty[Int]
    val result = mutable.ArrayBuffer.empty[Int]

    processFirstWindow(numbers, k, q, result)

    processRemainingValues(numbers, k, q, result)

    result.toArray
  }

  private def processRemainingValues(numbers: Array[Int], k: Int, q: mutable.ArrayDeque[Int], result: ArrayBuffer[Int]): Unit = {
    for (i <- k until numbers.length) {
      while (q.nonEmpty && q.head <= i - k) {
        q.removeHead()
      }

      purgeSmallerValuesAndAppend(q, i, numbers)

      result += numbers(q.head)
    }
  }

  private def processFirstWindow(numbers: Array[Int], k: Int, q: mutable.ArrayDeque[Int], result: ArrayBuffer[Int]) = {
    for (i <- 0 until k) {
      purgeSmallerValuesAndAppend(q, i, numbers)
    }

    result += numbers(q.head)
  }

  private def purgeSmallerValuesAndAppend(
      q: mutable.ArrayDeque[Int],
      i: Int,
      numbers: Array[Int]
  ) = {
    while (q.nonEmpty && numbers(q.last) < numbers(i)) {
      q.removeLast()
    }
    q.append(i)
  }

}
