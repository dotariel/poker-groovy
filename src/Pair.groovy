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

  private List getStrength(Hand hand) {
    def p = hand.pairs.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [RANK] + p + q.sort { a,b -> b <=> a } + [0]
  }
}