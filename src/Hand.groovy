class Hand {

  List cards = []
  List strength = []
  Rank rank

  private Hand() { }

  public Hand(List cardList) {
    if (cardList.size() != 5)
      throw new InvalidHand()

    cardList.each { s -> cards << new Card(s[0] + s[1]) }
  }

  public void sort() {
    this.cards = cards.sort { a,b -> b.value <=> a.value } as List
  }

  public int size() {
    this.cards.size()
  }

  public String toString() {
    sort()
    getString(this.rank)
  }

  public void assignStrength(Rank rank, List strength) {
    this.rank = rank
    this.strength = strength
  }

  private String getString(Rank rank) {
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
    isConsecutive(cards.collect { it.value })
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

  public static Hand mockHighCard() {
    new Hand(['9H', 'JC', 'KC', '2S', 'TD'])
  }

  public static Hand mockPair() {
    new Hand(['9H', 'JC', 'KC', '2S', '9D'])
  }

  public static Hand mockTwoPair() {
    new Hand(['AH', 'AD', 'KC', '2S', '2D'])
  }

  public static Hand mockThreeOfAKind() {
    new Hand(['AH', 'AD', 'KC', 'AS', '9D'])
  }

  public static Hand mockStraight() {
    new Hand(['4H', '5D', '6C', '7S', '8D'])
  }

  public static Hand mockFlush() {
    new Hand(['2H', '4H', '6H', '8H', 'TH'])
  }

  public static Hand mockFullHouse() {
    new Hand(['2H', '2D', '2S', '7D', '7H'])
  }

  public static Hand mockFourOfAKind() {
    new Hand(['2H', '2D', '2S', '2C', '7H'])
  }

  public static Hand mockStraightFlush() {
    new Hand(['4H', '5H', '6H', '7H', '8H'])
  }
}