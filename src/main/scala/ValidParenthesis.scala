import scala.annotation.tailrec

object Solution {

  def isValid(s: String): Boolean = {
    val stack = collection.mutable.Stack[Char]()
    isValidRec(s, stack)
  }

  @tailrec
  private def isValidRec(s: String, stack: collection.mutable.Stack[Char]): Boolean = {
    if (s.isEmpty) stack.isEmpty
    else {
      s.head match {
        case '(' | '{' | '[' => isValidRec(s.tail, stack.push(s.head))
        case ')' => if (stack.isEmpty || stack.pop() != '(') false
        else isValidRec(s.tail, stack)
        case '}' => if (stack.isEmpty || stack.pop() != '{') false
        else isValidRec(s.tail, stack)
        case ']' => if (stack.isEmpty || stack.pop() != '[') false
        else isValidRec(s.tail, stack)
      }
    }
  }
}
