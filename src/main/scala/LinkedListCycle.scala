import scala.annotation.tailrec

// https://leetcode.com/problems/linked-list-cycle/description/
object LinkedListCycle {
  def hasCycle(head: ListNode): Boolean = {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow == fast) return true
    }
    false
  }

//  https: //leetcode.com/problems/linked-list-cycle-ii/
  def detectCycle(head: ListNode): ListNode = {
    @tailrec
    def detectCycleRec(head: ListNode, visited: Set[ListNode]): ListNode = {
      if (head == null) null
      else if (visited.contains(head)) head
      else detectCycleRec(head.next, visited + head)
    }
    detectCycleRec(head, Set.empty)
  }

}

