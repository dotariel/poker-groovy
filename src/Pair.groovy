class Pair implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 2} == 1
  }

  Hand resolveTie(Hand a, Hand b) {
    def p1 = a.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }
    def p2 = b.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }

    if (Card.val(p1.key) < Card.val(p2.key)) return a
    if (Card.val(p1.key) > Card.val(p2.key)) return b

    while (a.size() > 0) {
      def c1 = a.cards.pop()
      def c2 = b.cards.pop()

      if (Card.val(c1.value) < Card.val(c2.value)) return a
      if (Card.val(c1.value) > Card.val(c2.value)) return b
    }
  }

  public String toString() {
    "Pair"
  }
}