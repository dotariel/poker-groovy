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

  private List getStrength(Hand hand) {
    def p = hand.quads.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [RANK] + p + q.sort { a,b -> b <=> a } + [0,0,0]
  }
}