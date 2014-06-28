import org.junit.*

public class CardTest {

  @Test
  public void should_return_string() {
    assert new Card("4", "C").toString() == "4C"
    assert new Card("A", "H").toString() == "AH"
    assert new Card("3", "S").toString() == "3S"
    assert new Card("K", "D").toString() == "KD"
  }
}