class FourOfAKind implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 4 } == 1
  }

  Hand resolveTie(Hand a, Hand b) {
    a
  }
  
  String toString() {
    "Four of a Kind"
  }
}