class Deck {
  List cards = []

  public Deck() {
    make()
  } 

  public void shuffle() {
    Collections.shuffle(cards)
  }

  private void make() {
    Card.suits.each { suit ->
      Card.values.each { k, v ->
        cards << new Card(k + suit)
      }
    }
  }
}