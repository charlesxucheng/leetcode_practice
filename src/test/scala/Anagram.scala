object Anagram {
  def isAnagram(s: String, t: String): Boolean = {
    val map1 = s.toList.groupMapReduce(identity)(_ => 1)(_ + _)
    val map2 = t.toList.groupMapReduce(identity)(_ => 1)(_ + _)
    map1 == map2
  }
}
