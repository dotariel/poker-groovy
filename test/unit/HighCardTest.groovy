import org.junit.*

class HighCardTest {

  @Test
  public void should_return_rank() {
    assert new HighCard().evaluate(new Hand()) == true
  }
}