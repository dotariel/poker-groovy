class Flush implements Rank {

  private static int RANK = 5

  boolean visit(Hand hand) {
    if (hand.isFlush()) {
      hand.setRank(this) { h ->
        [RANK] + h.cards.collect { it.value }.sort { a,b -> b <=> a } 
      }
      return true
    }
  }

  public String toString() {
    "Flush"
  }
}