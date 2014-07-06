abstract class BaseRank implements Rank {
  boolean visit(Hand hand) {
    return true
  }

  protected int val(String s) {
    Card.getCardValue(s)
  }

  protected List<Integer> val(List<Integer> list) {
    list.collect { Card.getCardValue(it) }
  }
}