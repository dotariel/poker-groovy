class Evaluator {

  static List<Rank> ranks = [
    new TwoPair(),
    new Pair(), 
    new HighCard()
  ]
 
  public def evaluate(Hand hand) {
    ranks.find { rank -> rank.evaluate(hand) }
  } 
}