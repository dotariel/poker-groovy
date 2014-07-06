class StraightFlush extends BaseRank {

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

  private List<Integer> getStrength(Hand h) {
    [RANK] + h.sort().cards.collect { Card.getCardValue(it.value) }
  }
}