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

//    val sorted = nums.sorted
    for (i <- 0 until nums.length - 2) {
      for (j <- i + 1 until nums.length) {
        val currentValue = nums(j)
//        println("Processing pair " + nums(i) + " " + currentValue)
        if (candidates.contains(currentValue)) {
          candidates(currentValue).foreach { case (k, l) =>
            results += List(k, l, currentValue).sorted
          }
          candidates.remove(currentValue)
        }
        val key = -(nums(i) + currentValue)
        candidates.put(
          key,
          candidates.getOrElse(key, mutable.Set()).addOne((
            nums(i),
            currentValue
          )
        ))
//        println(results)
//        println(candidates)
      }
      candidates.clear()
    }
    results.toList
  }
}
