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

  private List getStrength(Hand hand) {
    def p0 = hand.pairs.collect { k,v -> v[0] }[0].value
    def p1 = hand.pairs.collect { k,v -> v[0] }[1].value

    def q = hand.cards.collect { it.value } - p0 - p1

    [RANK] + p0 + p1 + q.sort { a,b -> b <=> a } + [0,0]
  }
}