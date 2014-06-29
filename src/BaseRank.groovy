abstract class BaseRank implements Rank {
  Hand compare(Hand a, Hand b) {
    int comp = a.compare(a.cards, b.cards)

    if (comp > 0) return a
    if (comp < 0) return b
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