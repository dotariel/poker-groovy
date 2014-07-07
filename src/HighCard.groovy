class HighCard implements Rank {

  private static int RANK = 0

  boolean visit(Hand hand) {
    hand.rank = this
    hand.strength = getStrength(hand)
    true
  }

  String toString() {
    "High Card"
  }

  private List getStrength(Hand hand) {
    [RANK] + hand.cards.collect { it.value }.sort { a,b -> b <=> a }
  }
}