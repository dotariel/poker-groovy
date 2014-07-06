class FullHouse extends BaseRank {

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
    def p0 = h.sets.keySet()[0]
    def p1 = h.pairs.keySet()[0]

    [RANK] + val(p0) + val(p1) + 0 + 0 + 0
  }
}