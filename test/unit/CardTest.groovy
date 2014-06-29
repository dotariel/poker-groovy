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
}