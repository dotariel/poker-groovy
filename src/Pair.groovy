class Pair implements IRank {

  boolean visit(Hand hand) {
    hand.pairs.size() == 1
  }

  List getStrength(Hand hand) {
    def p = hand.pairs.collect { k,v -> v[0] }[0].value
    def q = hand.cards.collect { it.value } - p

    [p] + q.sort { a,b -> b <=> a } + [0]
  }

  public String toString() {
    "Pair"
  }
}