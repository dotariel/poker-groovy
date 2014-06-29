class TwoPair extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
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