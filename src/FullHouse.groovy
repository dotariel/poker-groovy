class FullHouse implements Rank {
  boolean evaluate(Hand hand) {
    new Pair().evaluate(hand) && new ThreeOfAKind().evaluate(hand)
  }

  Hand resolveTie(Hand a, Hand b) {
    a
  }
  
  String toString() {
    "Full House"
  }
}