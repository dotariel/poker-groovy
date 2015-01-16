class ThreeOfAKind implements IRank {

  boolean visit(Hand hand) {
    hand.sets.size() == 1
  }

  List getStrength(Hand hand) {
    def p = hand.sets.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [p] + q.sort { a,b -> b <=> a } + [0,0]
  }

  String toString() {
    "Three of A Kind"
  }
}