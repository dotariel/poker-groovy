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

  private String getString(HighCard rank) {
    "${cards} (${rank}: ${highCard.value})"
  }

  private String getString(Rank rank) {
    "${cards} (${rank})" 
  }

  private Card getHighCard() {
    cards.min { Card.val(it.value) }
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