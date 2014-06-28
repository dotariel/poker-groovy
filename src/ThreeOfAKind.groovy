class ThreeOfAKind implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 3} == 1
  }
}