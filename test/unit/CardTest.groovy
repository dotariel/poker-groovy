import org.junit.*

public class CardTest {

  @Test
  public void should_return_string() {
    assert new Card("4C").toString() == "4C"
    assert new Card("AH").toString() == "AH"
    assert new Card("3S").toString() == "3S"
    assert new Card("KD").toString() == "KD"
  }

  @Test
  public void should_construct_card_from_string() {
    assert new Card('AH').toString() == 'AH'
    assert new Card('TC').toString() == 'TC'
    assert new Card('2S').toString() == '2S'
  }

  @Test(expected=IllegalArgumentException)
  public void should_throw_exception_if_string_is_wrong_format() {
    new Card("XX")
  }

  @Test
  public void should_get_face() {
    assert new Card('AH').face == 'A'
    assert new Card('TC').face == 'T'
    assert new Card('2S').face == '2'
  }

  @Test
  public void should_get_suit() {
    assert new Card('AH').suit == 'H'
    assert new Card('TC').suit == 'C'
    assert new Card('2S').suit == 'S'
    assert new Card('9D').suit == 'D'
  }

  @Test
  public void should_get_value() {
    assert new Card('AH').value == 14
    assert new Card('TC').value == 10
    assert new Card('2S').value == 2
    assert new Card('9D').value == 9
  }
}