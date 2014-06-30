class Flush extends BaseRank {
  Hand compare(Hand a, Hand b) {
    super.compare(a,b)
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