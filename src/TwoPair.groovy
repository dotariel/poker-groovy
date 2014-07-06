class TwoPair implements Rank {

  private static int RANK = 2

  boolean visit(Hand hand) {
    if (hand.pairs.size() == 2) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Two Pair"
  }

  private List<Integer> getStrength(Hand h) {
    def p0 = h.pairs.collect { k,v -> v[0] }[0].value
    def p1 = h.pairs.collect { k,v -> v[0] }[1].value

    def q = h.cards.collect { it.value } - p0 - p1

    [RANK] + p0 + p1 + q.sort().reverse() + 0 + 0
  }
}