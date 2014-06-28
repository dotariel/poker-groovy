class Hand {

  List<Card> cards = []

  public Card getHighCard() {
    sort().first()
  }

  public List<Card> sort() {
    cards.sort { c -> Card.values.indexOf(c.value) }
  }

  public static Hand mockHighCard() {
    def hand = new Hand()
    hand.cards << new Card("9", "H")
    hand.cards << new Card("J", "C")
    hand.cards << new Card("K", "C")
    hand.cards << new Card("2", "S")
    hand.cards << new Card("10", "D")
    hand
  }

  public static Hand mockPair() {
    def hand = new Hand()
    hand.cards << new Card("9", "H")
    hand.cards << new Card("J", "C")
    hand.cards << new Card("K", "C")
    hand.cards << new Card("2", "S")
    hand.cards << new Card("9", "D")
    hand
  }

  public static Hand mockTwoPair() {
    def hand = new Hand()
    hand.cards << new Card("A", "H")
    hand.cards << new Card("A", "D")
    hand.cards << new Card("K", "C")
    hand.cards << new Card("2", "S")
    hand.cards << new Card("2", "D")
    hand
  }

  public static Hand mockThreeOfAKind() {
    def hand = new Hand()
    hand.cards << new Card("A", "H")
    hand.cards << new Card("A", "D")
    hand.cards << new Card("K", "C")
    hand.cards << new Card("A", "S")
    hand.cards << new Card("9", "D")
    hand
  }

  public static Hand mockStraight() {
    def hand = new Hand()
    hand.cards << new Card("4", "H")
    hand.cards << new Card("5", "D")
    hand.cards << new Card("6", "C")
    hand.cards << new Card("7", "S")
    hand.cards << new Card("8", "D")
    hand
  }

  public static Hand mockFlush() {
    def hand = new Hand()
    hand.cards << new Card("2", "H")
    hand.cards << new Card("4", "H")
    hand.cards << new Card("6", "H")
    hand.cards << new Card("8", "H")
    hand.cards << new Card("10", "H")
    hand
  }
}