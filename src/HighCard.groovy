class HighCard implements Rank {
  boolean evaluate(Hand hand) {
    return true
  }

  Hand resolveTie(Hand a, Hand b) {
    a.sort()
    b.sort()

    while (a.size() > 0) {
      def c1 = a.cards.pop()
      def c2 = b.cards.pop()

      if (c1.value > c2.value) {
        return a
      }

      if (c1.value < c2.value) {
        return b
      }
    }
  }

  String toString() {
    "High Card"
  }
}