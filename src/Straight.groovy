class Straight implements Rank {

  private static int RANK = 4

  boolean visit(Hand hand) {
    if (hand.isStraight()) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Straight"
  }

  private List<Integer> getStrength(Hand h) {
    [RANK] + h.cards.collect { it.value }.sort().reverse()
  }
}
