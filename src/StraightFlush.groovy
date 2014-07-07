class StraightFlush implements Rank {

  private static int RANK = 8

  boolean visit(Hand hand) {
    if (hand.isStraight() && hand.isFlush()) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Straight Flush"
  }

  private List getStrength(Hand hand) {
    [RANK] + hand.cards.collect { it.value }.sort { a,b -> b <=> a }
  }
}