class FullHouse implements Rank {

  private static int RANK = 6

  boolean visit(Hand hand) {
    if (hand.sets.size() == 1 && hand.pairs.size() == 1) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Full House"
  }

  private List getStrength(Hand hand) {
    def p = hand.sets.collect { k,v -> v[0] }[0].value
    def q = hand.pairs.collect { k,v -> v[0] }[0].value

    [RANK] + p + q + [0,0,0]
  }
}