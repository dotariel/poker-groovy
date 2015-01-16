class Dealer {
  Deck deck

  public Dealer() {
    this.deck = new Deck()
  }

  public Card deal() {
    if (deck.cards.size() > 0)
      deck.cards.pop()
  }
}