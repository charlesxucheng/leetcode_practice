import scala.collection.mutable

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
class KthLargestInStream(k: Int, numbers: Array[Int]) {

  private val pqr = mutable.PriorityQueue
    .empty[Int](using Ordering[Int])
    .addAll(numbers)
    .take(k)

  def add(n: Int): Int = {
    pqr.enqueue(n)
    if (pqr.size > k) pqr.dequeue()
    pqr.head
  }
}
