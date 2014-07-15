class FourOfAKind implements IRank {

  boolean visit(Hand hand) {
    hand.quads.size() == 1
  }

  List getStrength(Hand hand) {
    def p = hand.quads.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [p] + q.sort { a,b -> b <=> a } + [0,0,0]
  }

  String toString() {
    "Four of a Kind"
  }
}