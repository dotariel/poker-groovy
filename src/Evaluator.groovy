class Evaluator {

  static List<Rank> ranks = [
    new FourOfAKind(),
    new FullHouse(),
    new Flush(),
    new Straight(),
    new ThreeOfAKind(),
    new TwoPair(),
    new Pair(), 
    new HighCard()
  ]
 
  public def evaluate(Hand hand) {
    ranks.find { rank -> rank.evaluate(hand) }
  } 
}