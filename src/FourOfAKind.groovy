class FourOfAKind extends BaseRank {
  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.quads, b.quads)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }
  
  String toString() {
    "Four of a Kind"
  }

  boolean visit(Hand hand) {
    if (hand.cards.groupBy { it.value }.count { k,v -> v.size() == 4 } == 1) {
      hand.rank = this
      return true
    }
  }
}