class TwoPair extends BaseRank {
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
    if (hand.cards.groupBy { it.value }.count { k,v -> v.size() == 2} == 2) {
      hand.rank = this
      return true
    }
  }
}