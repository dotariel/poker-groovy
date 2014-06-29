class HighCard implements Rank {
  boolean evaluate(Hand hand) {
    return true
  }

  Hand resolveTie(Hand a, Hand b) {
    a.sort()
    b.sort()

    a.cards = a.cards.reverse()
    b.cards = b.cards.reverse()

    while (a.size() > 0) {
      def c1 = a.cards.pop()
      def c2 = b.cards.pop()

      if (Card.val(c1.value) < Card.val(c2.value)) return a
      if (Card.val(c1.value) > Card.val(c2.value)) return b
    }
  }

  String toString() {
    "High Card"
  }
}