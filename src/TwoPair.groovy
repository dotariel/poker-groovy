class TwoPair implements IRank {
  boolean visit(Hand hand) {
    hand.pairs.size() == 2
  }

  List getStrength(Hand hand) {
    def p0 = hand.pairs.collect { k,v -> v[0] }[0].value
    def p1 = hand.pairs.collect { k,v -> v[0] }[1].value
    def q = hand.cards.collect { it.value } - p0 - p1

    [p0, p1] + q.sort { a,b -> b <=> a } + [0,0]
  }

  String toString() {
    "Two Pair"
  }
}