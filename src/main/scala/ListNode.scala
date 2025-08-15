case class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object ListNode {
  def apply(x: Int, next: ListNode): ListNode = {
    val node = new ListNode(x)
    node.next = next
    node
  }
}
