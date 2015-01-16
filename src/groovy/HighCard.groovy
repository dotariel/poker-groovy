class HighCard implements IRank {

  boolean visit(Hand hand) {
    return true
  }

  List getStrength(Hand h) {
    h.cards.collect { it.value }.sort { a,b -> b <=> a }
  }

  String toString() {
    "High Card"
  }
}