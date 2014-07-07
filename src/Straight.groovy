class Straight implements Rank {

  private static int RANK = 4

  boolean visit(Hand hand) {
    if (hand.isStraight()) {
      hand.rank = this
      hand.strength = getStrength(hand)
      return true
    }
  }

  String toString() {
    "Straight"
  }

  private List getStrength(Hand hand) {
    [RANK] + hand.cards.collect { it.value }.sort { a,b -> b <=> a }
  }
}
