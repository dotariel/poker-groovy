class TwoPair extends BaseRank {

  private static int RANK = 2

  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.pairs, b.pairs)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }

  String toString() {
    "Two Pair"
  }

  boolean visit(Hand hand) {

    if (hand.pairs.size() == 2) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  private List<Integer> getStrength(Hand h) {
    def p0 = h.pairs.keySet()[0]
    def p1 = h.pairs.keySet()[1]
    def q = h.sort().cards.collect { it.value } - p0 - p1

    [RANK] + val(p0) + val(p1) + val(q) + 0 + 0
  }
}