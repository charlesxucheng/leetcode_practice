// https://leetcode.com/problems/swap-nodes-in-pairs/description/
object SwapNodePairsInList {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null) return null
    if (head.next == null) return head

    var p1 = head
    var p2 = head.next
    var previousP1: ListNode = null
    val newHead = p2
    while (p1 != null) {
      if (p2 == null) {
        previousP1.next = p1
        return newHead
      } else {
        val nextP1 = p2.next
        val nextP2 = if (nextP1 != null) nextP1.next else null
        p2.next = p1
        if (previousP1 != null) previousP1.next = p2
        previousP1 = p1
        p1 = nextP1
        p2 = nextP2
      }
    }
    previousP1.next = null
    newHead
  }
}
