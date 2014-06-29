class Hand {

  List<Card> cards = []
  Rank rank

  public Hand(List<String> str) {
    str.each { s -> cards << new Card(s[0] + s[1]) }
  }

  public void sort() {
    this.cards = cards.sort { c -> Card.values.indexOf(c.value) } as List<Card>
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

  private Map<String, List<Card>> getGroup(int count) {
    cards.groupBy { it.value }.findAll { k,v -> v.size() == count }  
  }

  public int compare(Map<String,List<Card>> a, Map<String,List<Card>> b) {
    def aKeys = a.keySet().sort().reverse() as List
    def bKeys = b.keySet().sort().reverse() as List

    while (aKeys.size() > 0 && bKeys.size() > 0) {
      def c1 = aKeys.pop()
      def c2 = bKeys.pop()

      if (Card.val(c1) < Card.val(c2)) return 1
      if (Card.val(c1) > Card.val(c2)) return -1
    }

    return 0
  }

  public int compare(List<Card> a, List<Card> b) {
    def aKeys = a.sort{ Card.val(it.value) }.reverse() as List
    def bKeys = b.sort{ Card.val(it.value) }.reverse() as List

    while (aKeys.size() > 0 && bKeys.size() > 0) {
      def c1 = aKeys.pop().value
      def c2 = bKeys.pop().value

      if (Card.val(c1) < Card.val(c2)) return 1
      if (Card.val(c1) > Card.val(c2)) return -1
    }

    return 0
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