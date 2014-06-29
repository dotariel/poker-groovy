class Pair extends BaseRank {

  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.pairs, b.pairs)
    
    if (comp > 0) return a
    if (comp < 0) return b

    super.compare(a,b)    
  }

  boolean visit(Hand hand) {
    if (hasPair(hand)) {
      hand.rank = this
      return true
    }
  }

  public String toString() {
    "Pair"
  }
}