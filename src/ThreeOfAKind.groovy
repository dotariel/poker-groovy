class ThreeOfAKind extends BaseRank {

  private static int RANK = 3

  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.sets, b.sets)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }

  String toString() {
    "Three of A Kind"
  }

  boolean visit(Hand hand) {
    if (hasSet(hand)) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  private List<Integer> getStrength(Hand h) {
    def p = h.sets.keySet()[0]
    def q = h.sort().cards.collect { it.value } - p

    [RANK] + val(p) + val(q) + 0 + 0
  }
}