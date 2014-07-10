class HighCard implements Rank {

  private static int RANK = 0

  boolean visit(Hand hand) {
    hand.setRank(this) { h ->
      [RANK] + h.cards.collect { it.value }.sort { a,b -> b <=> a }
    }
    return true
  }

  String toString() {
    "High Card"
  }
}