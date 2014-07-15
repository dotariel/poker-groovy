class Straight implements IRank {

  boolean visit(Hand hand) {
    hand.isStraight()
  }

  List getStrength(Hand hand) {
    hand.cards.collect { it.value % 14 }.sort { a,b -> b <=> a }        
  }

  String toString() {
    "Straight"
  }
}
