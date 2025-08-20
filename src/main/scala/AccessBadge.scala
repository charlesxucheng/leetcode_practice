import scala.collection.mutable

object AccessBadge {
  def mismatch(
      input: Vector[Vector[String]]
  ): (mutable.Set[String], mutable.Set[String]) = {
    val records, result1, result2 = mutable.Set.empty[String]

    input
      .map(x => (x.head, x.tail.head))
      .foreach(x => {
        if (records.contains(x._1))
          if (x._2 == "enter") result1.add(x._1)
          else records.remove(x._1)
        else // No entry found
          if (x._2 == "enter") records.add(x._1)
          else result2.add(x._1)
      })

    result1 ++= records
    (result1, result2)
  }
}
