class FullHouse extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
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