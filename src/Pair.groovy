class Pair extends BaseRank {

  private static int RANK = 1

  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.pairs, b.pairs)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }

  boolean visit(Hand hand) {
    if (hand.pairs.size() == 1) {
      hand.rank = this  // deprecate this
      hand.strength = getStrength(hand)
      true
    }
  }

  public String toString() {
    "Pair"
  }

  List<Integer> getStrength(Hand h) {
    def p = h.pairs.keySet().first()
    def q = h.sort().cards.collect { it.value } - p

    [RANK] + val(p) + val(q) + 0
  }
}