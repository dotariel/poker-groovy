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

  private List<Integer> getStrength(Hand h) {
    [RANK] + h.sets.keySet()[0] + h.pairs.keySet()[0] + 0 + 0 + 0
  }
}