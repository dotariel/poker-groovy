class StraightFlush implements Rank {
  boolean evaluate(Hand hand) {
    new Straight().evaluate(hand) && new Flush().evaluate(hand)
  }

  String toString() {
    "Straight Flush"
  }
}