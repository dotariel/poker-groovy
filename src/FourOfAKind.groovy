class FourOfAKind implements Rank {

  private static int RANK = 7

  boolean visit(Hand hand) {
    if (hand.quads.size() == 1) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Four of a Kind"
  }

  private List<Integer> getStrength(Hand h) {
    def p = h.quads.collect { k,v -> v[0] }[0].value
    def q = h.cards.collect { it.value } - p

    [RANK] + p + q.sort().reverse() + 0 + 0 + 0
  }
}