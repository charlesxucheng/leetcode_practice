import scala.collection.mutable

// https://leetcode.com/problems/3sum/description/
object ThreeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    require(nums.length >= 3 && nums.length <= 3000)

    if (nums.length == 3)
      return if (nums.sum == 0) List(List(nums(0), nums(1), nums(2)))
      else List()

    val results = mutable.Set.empty[List[Int]]
    // Stores the values that sum to the given key for each pair stored in the Map value
    val candidates = mutable.HashMap.empty[Int, mutable.Set[(Int, Int)]]

    for (i <- 0 until nums.length - 2) {
      for (j <- i + 1 until nums.length) {
        val currentValue = nums(j)
        if (candidates.contains(currentValue)) {
          candidates(currentValue).foreach { case (k, l) =>
            results += List(k, l, currentValue).sorted
          }
          candidates.remove(currentValue)
        }
        val key = -(nums(i) + currentValue)
        candidates.put(
          key,
          candidates
            .getOrElse(key, mutable.Set())
            .addOne(
              (
                nums(i),
                currentValue
              )
            )
        )
      }
      candidates.clear()
    }
    results.toList
  }
}

object ThreeSumSingleLoop {
  def treeSum(nums: Array[Int]): List[List[Int]] = {
    require(nums.length >= 3 && nums.length <= 3000)

    val sorted = nums.sorted
    val results = mutable.Set.empty[List[Int]]

    for (i <- 0 until sorted.length - 2) {
      var left = i + 1
      var right = sorted.length - 1
      while (left < right) {
        val sum = sorted(i) + sorted(left) + sorted(right)
        if (sum == 0) {
          results += List(sorted(i), sorted(left), sorted(right))
          left += 1
          right -= 1
        } else if (sum < 0) left += 1
        else right -= 1
      }
    }
    results.toList
  }
}
