class ThreeOfAKind implements Rank {

  private static int RANK = 3

  boolean visit(Hand hand) {
    if (hand.sets.size() == 1) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Three of A Kind"
  }

  private List getStrength(Hand hand) {
    def p = hand.sets.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [RANK] + p + q.sort { a,b -> b <=> a } + [0,0]
  }
}