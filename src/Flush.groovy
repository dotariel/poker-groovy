class Flush implements Rank {

  private static int RANK = 5

  boolean visit(Hand hand) {
    if (hand.isFlush()) {
      hand.assignStrength(this, getStrength(hand))
      return true
    }
  }

  public String toString() {
    "Flush"
  }

  private List getStrength(Hand h) {
    [RANK] + h.cards.collect { it.value }.sort { a,b -> b <=> a } 
  }
}