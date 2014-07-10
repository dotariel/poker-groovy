class StraightFlush implements Rank {

  private static int RANK = 8

  boolean visit(Hand hand) {
    if (hand.isStraight() && hand.isFlush()) {
      hand.setRank(this) { h ->
        [RANK] + h.cards.collect { it.value }.sort { a,b -> b <=> a }
      }
      return true
    }
  }

  String toString() {
    "Straight Flush"
  }
}