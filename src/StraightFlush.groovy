class StraightFlush implements Rank {
  boolean evaluate(Hand hand) {
    new Straight().evaluate(hand) && new Flush().evaluate(hand)
  }

  Hand resolveTie(Hand a, Hand b) {
    a
  }

  String toString() {
    "Straight Flush"
  }
}