class ThreeOfAKind extends BaseRank {
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
      return true
    }
  }
}