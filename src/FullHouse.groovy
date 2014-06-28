class FullHouse implements Rank {
  boolean evaluate(Hand hand) {
    new Pair().evaluate(hand) && new ThreeOfAKind().evaluate(hand)
  }
}