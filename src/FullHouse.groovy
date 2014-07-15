class FullHouse implements IRank {

  boolean visit(Hand hand) {
    hand.sets.size() == 1 && hand.pairs.size() == 1
  }

  List getStrength(Hand hand) {
    def p = hand.sets.collect { k,v -> v[0] }[0].value
    def q = hand.pairs.collect { k,v -> v[0] }[0].value

    [p, q, 0,0,0]
  }

  String toString() {
    "Full House"
  }
}