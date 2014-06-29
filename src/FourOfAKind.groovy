class FourOfAKind extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
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