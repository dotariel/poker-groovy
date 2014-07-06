class HighCard extends BaseRank {

  private static int RANK = 0

  String toString() {
    "High Card"
  }

  boolean visit(Hand hand) {
    hand.rank = this  // Deprecate this in favor of strength
    hand.strength = getStrength(hand)
    true
  }

  private List<Integer> getStrength(Hand h) {
    [RANK] + h.sort().cards.collect { Card.getCardValue(it.value) }
  }
}