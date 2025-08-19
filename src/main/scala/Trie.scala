import scala.collection.mutable

class Trie {
  private val children: mutable.Map[Char, Trie] = mutable.Map.empty
  private var isEnd: Boolean = false

  def insert(word: String): Unit = {
    if (word.isEmpty) isEnd = true
    else children.getOrElseUpdate(word.head, new Trie).insert(word.tail)
  }

  def search(word: String): Boolean =
    if (word.isEmpty) isEnd
    else children.get(word.head).exists(_.search(word.tail))

  def startsWith(word: String): Boolean =
    if (word.isEmpty) true
    else children.get(word.head).exists(_.startsWith(word.tail))
}

case class ImmutableTrie(
    children: Map[Char, ImmutableTrie],
    isEnd: Boolean
) {
  def insert(word: String): ImmutableTrie = {
    if (word.isEmpty) ImmutableTrie(Map.empty, true)
    else {
      val childToUpdate =
        children.getOrElse(word.head, ImmutableTrie(Map.empty, false))
      this.copy(children =
        children.updated(word.head, childToUpdate.insert(word.tail))
      )
    }
  }

  def search(word: String): Boolean = {
    if (word.isEmpty) isEnd
    else children.get(word.head).exists(_.search(word.tail))
  }

  def startsWith(word: String): Boolean = {
    if (word.isEmpty) true
    else children.get(word.head).exists(_.startsWith(word.tail))
  }
}
