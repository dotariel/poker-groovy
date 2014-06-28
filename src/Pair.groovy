class Pair implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 2} == 1
  }

  public String toString() {
    "Pair"
  }
}