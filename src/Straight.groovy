class Straight implements Rank {

  private static int RANK = 4

  boolean visit(Hand hand) {
    if (hand.isStraight()) {
      hand.setRank(this) { h ->
        [RANK] + h.cards.collect { it.value % 14 }.sort { a,b -> b <=> a }    
      }
      return true
    }
  }

  String toString() {
    "Straight"
  }
}
