class Straight implements Rank {
  boolean evaluate(Hand hand) {
    isConsecutive(hand.cards.collect { c -> Card.values.indexOf(c.value) })
  }

  boolean isConsecutive(List<Integer> values) {
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