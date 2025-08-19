class TrieTest extends UnitSpec {
  "Trie" should {
    "be able to find an exact word" in {
      val trie = Trie()
      trie.insert("apple")
      trie.search("apple") mustBe true
      trie.insert("app")
      trie.search("app") mustBe true
    }

    "not find a prefix but not a whole word" in {
      val trie = Trie()
      trie.insert("apple")
      trie.search("app") mustBe false
    }

    "find a prefix" in {
      val trie = Trie()
      trie.insert("apple")
      trie.startsWith("app") mustBe true
    }

    "find a prefix that is an empty string" in {
      val trie = Trie()
      trie.startsWith("") mustBe true
    }
  }
}
