class Pair extends BaseRank {

  @Override
  boolean evaluate(Hand hand) {
    hand.cards.groupBy { c -> c.value }.count { k,v -> v.size() == 2} == 1
  }

  @Override
  Hand resolveTie(Hand a, Hand b) {
    def p1 = a.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }
    def p2 = b.cards.groupBy { it.value }.find { k,v -> v.size() == 2 }

    if (Card.val(p1.key) < Card.val(p2.key)) return a
    if (Card.val(p1.key) > Card.val(p2.key)) return b

    super.resolveTie(a,b)
  }

  public String toString() {
    "Pair"
  }
}