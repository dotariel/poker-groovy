class Pair implements Rank {

  private static int RANK = 1

  boolean visit(Hand hand) {
    if (hand.pairs.size() == 1) {
      hand.setRank(this) { h ->
        def p = h.pairs.collect { k,v -> v[0] }[0].value
        def q = h.cards.collect { it.value } - p

        [RANK] + p + q.sort { a,b -> b <=> a } + [0]
      }
      return true
    }
  }

  public String toString() {
    "Pair"
  }
}