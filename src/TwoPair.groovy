class TwoPair implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 2} == 2
  }
}