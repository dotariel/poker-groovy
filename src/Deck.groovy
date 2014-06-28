class Deck {
  List<Card> cards = []

  public Deck() {
    make()
  } 

  public void shuffle() {
    Collections.shuffle(cards)
  }

  private void make() {
    Card.suits.each { suit ->
      Card.values.each { value ->
        cards << new Card(value, suit)
      }
    }
  }
}