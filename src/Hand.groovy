class Hand {

  List<Card> cards = []
  List<Integer> strength = []
  Rank rank

  private Hand() {
  }

  public Hand(List<String> str) {
    if (str.size() != 5)
      throw new InvalidHand()

    str.each { s -> cards << new Card(s[0] + s[1]) }
  }

  public Hand sort() {
    this.cards = cards.sort { c -> Card.values.indexOf(c.value) } as List<Card>
    this
  }

  public int size() {
    cards.size()
  }

  public String toString() {
    getString(this.rank)
  }

  private String getString(Rank rank) {
    "${cards} (${rank})" 
  }

  private String getString(HighCard rank) {
    "${cards} (${rank}: ${highCard.value})"
  }

  private String getString(Pair rank) {
    "${cards} (${rank}: ${pairs.find {k,v -> true}.value})"
  }

  private Card getHighCard() {
    cards.min { Card.val(it.value) }
  }

  private Map<String, List<Card>> getPairs() {
    getGroup(2)
  }

  private Map<String, List<Card>> getSets() {
    getGroup(3)
  }

  private Map<String, List<Card>> getQuads() {
    getGroup(4)
  }

  protected boolean isStraight() {
    isConsecutive(cards.collect { Card.values.indexOf(it.value) })
  }

  protected boolean isFlush() {
    cards.groupBy { it.suit }.count { k,v -> v.size() == 5 } == 1
  }

  private boolean isConsecutive(List<Integer> values) {
    def sorted = values.sort()
    for (int i=0; i<sorted.size(); i++) {
      if (sorted[i+1]) {
        if (sorted[i+1] != sorted[i]+1) 
          return false  
      }
    }

    return true
  }

  private Map<String, List<Card>> getGroup(int count) {
    cards.groupBy { it.value }.findAll { k,v -> v.size() == count }  
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