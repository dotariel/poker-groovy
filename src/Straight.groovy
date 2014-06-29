class Straight extends BaseRank {
  Hand compare(Hand a, Hand b) {
    super.compare(a,b)
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
