import org.junit.*

class DealerTest {

  @Test
  public void should_deal_card() {
    def dealer = new Dealer()

    dealer.deck.cards = []
    dealer.deck.cards << new Card('AH')
    dealer.deck.cards << new Card('2S')
    dealer.deck.cards << new Card('KD')

    assert dealer.deal().toString() == 'KD' 
    assert dealer.deal().toString() == '2S' 
    assert dealer.deal().toString() == 'AH' 
    assert dealer.deal() == null
  }
}