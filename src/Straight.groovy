class Straight extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
  }

  String toString() {
    "Straight"
  }

  boolean visit(Hand hand) {
    if (isStraight(hand)) {
      hand.rank = this
      return true
    }
  }
}
