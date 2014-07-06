class Pair implements Rank {

  private static int RANK = 1

  boolean visit(Hand hand) {
    if (hand.pairs.size() == 1) {
      hand.rank = this
      hand.strength = getStrength(hand)
      true
    }
  }

  public String toString() {
    "Pair"
  }

  private List<Integer> getStrength(Hand h) {
    def p = h.pairs.keySet().first()
    def q = h.cards.collect { it.value } - p

    [RANK] + p + q.sort().reverse() + 0
  }
}