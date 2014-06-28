import org.junit.*

class DeckTest {

  @Test
  public void should_make_new_deck_with_all_cards() {
    def deck = new Deck()

    assert deck.cards.size() == 52
    assert deck.cards.groupBy { c -> c.suit }.size() == 4
    assert deck.cards.groupBy { c -> c.value }.size() == 13
  }

  @Test
  public void should_shuffle_cards() {
    def deck = new Deck()
    def originalList = deck.cards.clone()

    deck.shuffle()

    assert originalList != deck.cards
  }
}