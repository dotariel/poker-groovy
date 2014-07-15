class StraightFlush implements IRank {

  boolean visit(Hand hand) {
    hand.isStraight() && hand.isFlush()
  }

  List getStrength(Hand hand) {
    hand.cards.collect { it.value }.sort { a,b -> b <=> a }
  }

  String toString() {
    "Straight Flush"
  }
}