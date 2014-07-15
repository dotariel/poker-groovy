class Hand {

  List cards = []
  HandType type

  private Hand() { 
  }

  public Hand(List cardList) {
    if (cardList.size() != 5)
      throw new InvalidHand()

    cardList.each { s -> cards << new Card(s[0] + s[1]) }
    sort()
  }

  public void sort() {
    this.cards = cards.sort { a,b -> b.value <=> a.value } as List
  }

  public int size() {
    this.cards.size()
  }

  public void assignRank() {
    def rank = HandType.firstMatchingRank { it.visit(this) }
    this.type = HandType.findByRank(rank)
  }

  public List getStrength() {
    [type?.value] + type?.rank?.getStrength(this)
  }

  public int compareTo(Hand hand) {
    for (int i=0; i<this.strength.size(); i++) {
      if (this.strength[i] > hand.strength[i]) return 1
      if (this.strength[i] < hand.strength[i]) return -1
    }

    return 0
  }

  public String toString() {
    getString(this.type?.rank)
  }

  private String getString(IRank rank) {
    "${cards} (${rank})" 
  }

  private String getString(HighCard rank) {
    cards.collect { it.toString() }.join(' ') + " (High Card: ${highCard.face})"
  }

  private String getString(Pair rank) {
    cards.collect { it.toString() }.join(' ') + " (Pair: ${pairs.keySet().first()})"
  }

  private Card getHighCard() {
    cards.max { it.value }
  }

  private Map getPairs() {
    getGroup(2)
  }

  private Map getSets() {
    getGroup(3)
  }

  private Map getQuads() {
    getGroup(4)
  }

  private Map getGroup(int count) {
    cards.groupBy { it.face }.findAll { k,v -> v.size() == count }  
  }

  protected boolean isStraight() {
    isConsecutive(cards.collect { it.value }) || 
    isConsecutive(cards.collect { it.value == 14 ? 1 : it.value })
  }

  protected boolean isFlush() {
    cards.groupBy { it.suit }.count { k,v -> v.size() == 5 } == 1
  }

  private boolean isConsecutive(List values) {
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