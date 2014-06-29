class TwoPair implements Rank {
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 2} == 2
  }
  
  Hand resolveTie(Hand a, Hand b) {
    a
  }

  String toString() {
    "Two Pair"
  }
}