class Flush extends BaseRank {

  private static int RANK = 5

  boolean visit(Hand hand) {
    if (hand.isFlush()) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  public String toString() {
    "Flush"
  }

  private List<Integer> getStrength(Hand h) {
    [RANK] + h.sort().cards.collect { Card.getCardValue(it.value) }
  }
}