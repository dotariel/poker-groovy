class ThreeOfAKind extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
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