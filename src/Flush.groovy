class Flush extends BaseRank {
  Hand compare(Hand a, Hand b) {
    throw new NotImplemented()
  }

  boolean visit(Hand hand) {
    if (isFlush(hand)) {
      hand.rank = this
      return true
    }
  }

  public String toString() {
    "Flush"
  }
}