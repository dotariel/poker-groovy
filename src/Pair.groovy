class Pair extends BaseRank {

  Hand compare(Hand a, Hand b) {
    def p1 = a.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }
    def p2 = b.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }

    if (Card.val(p1.key) < Card.val(p2.key)) return a
    if (Card.val(p1.key) > Card.val(p2.key)) return b

    super.compare(a,b)
  }

  boolean visit(Hand hand) {
    if (hasPair(hand)) {
      hand.rank = this
      return true
    }
  }

  public String toString() {
    "Pair"
  }
}