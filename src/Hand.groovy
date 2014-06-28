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
}