class FourOfAKind extends BaseRank {

  private static int RANK = 7

  boolean visit(Hand hand) {
    if (hand.quads.size() == 1) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Four of a Kind"
  }

  private List<Integer> getStrength(Hand h) {
    def p = h.quads.keySet().first()
    def q = h.sort().cards.collect { it.value } - p

    [RANK] + val(p) + val(q) + 0 + 0 + 0
  }
}