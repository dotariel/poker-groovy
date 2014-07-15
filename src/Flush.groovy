class Flush implements IRank {

  boolean visit(Hand hand) {
    hand.isFlush()
  }

  List getStrength(Hand hand) {
    hand.cards.collect { it.value }.sort { a,b -> b <=> a }    
  }

  public String toString() {
    "Flush"
  }
}