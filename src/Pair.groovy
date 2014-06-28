class Pair implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.size() == 4
  }
}