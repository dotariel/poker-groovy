class ThreeOfAKind extends BaseRank {

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

  private List<Integer> getStrength(Hand h) {
    def p = h.sets.keySet()[0]
    def q = h.sort().cards.collect { it.value } - p

    [RANK] + val(p) + val(q) + 0 + 0
  }
}