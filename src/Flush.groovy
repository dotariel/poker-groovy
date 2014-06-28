class Flush implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.suit }.count { k,v -> v.size() == 5} == 1
  }
}