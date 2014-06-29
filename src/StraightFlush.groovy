class StraightFlush extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
  }

  String toString() {
    "Straight Flush"
  }

  boolean visit(Hand hand) {
    if (isStraight(hand) && isFlush(hand)) {
      hand.rank = this
      return true
    }
  }
}