class HighCard extends BaseRank {
  String toString() {
    "High Card"
  }

  boolean visit(Hand hand) {
    hand.rank = this
    true
  }
}