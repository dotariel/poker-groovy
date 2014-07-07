class FourOfAKind implements Rank {

  private static int RANK = 7

  boolean visit(Hand hand) {
    if (hand.quads.size() == 1) {
      hand.setRank(this) { h ->
        def p = h.quads.collect { k,v -> v[0] }[0].value
        def q = h.cards.collect { it.value } - p

        [RANK] + p + q.sort { a,b -> b <=> a } + [0,0,0]
      }
      return true
    }
  }

  String toString() {
    "Four of a Kind"
  }
}