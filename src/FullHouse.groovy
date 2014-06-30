class FullHouse extends BaseRank {
  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.sets, b.sets)
    
    if (comp > 0) return a
    if (comp < 0) return b

    comp = a.compare(a.pairs, b.pairs)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }
  
  String toString() {
    "Full House"
  }

  boolean visit(Hand hand) {
    if (hasPair(hand) && hasSet(hand)) {
      hand.rank = this
      return true
    }
  }
}