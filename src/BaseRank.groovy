abstract class BaseRank implements Rank {
  Hand compare(Hand a, Hand b) {
    a.sort()
    b.sort()

    def aCards = a.cards.reverse().clone()
    def bCards = b.cards.reverse().clone()

    while (aCards.size() > 0 && bCards.size() > 0) {
      def c1 = aCards.pop()
      def c2 = bCards.pop()

      if (Card.val(c1.value) < Card.val(c2.value)) return a
      if (Card.val(c1.value) > Card.val(c2.value)) return b
    }
  }

  boolean visit(Hand hand) {
    return true
  }

  protected boolean hasPair(Hand hand) {
    hand.cards.groupBy { it.value }.count { k,v -> v.size() == 2 } == 1
  }

  protected boolean hasSet(Hand hand) {
    hand.cards.groupBy { it.value }.count { k,v -> v.size() == 3 } == 1
  }

  protected boolean isStraight(Hand hand) {
    isConsecutive(hand.cards.collect { Card.values.indexOf(it.value) })
  }

  protected boolean isFlush(Hand hand) {
    hand.cards.groupBy { it.suit }.count { k,v -> v.size() == 5 } == 1
  }

  protected boolean isConsecutive(List<Integer> values) {
    def sorted = values.sort()
    for (int i=0; i<sorted.size(); i++) {
      if (sorted[i+1]) {
        if (sorted[i+1] != sorted[i]+1) 
          return false  
      }
    }

    return true
  }
}