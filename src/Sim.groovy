class Sim {
  public static void main(String[] args) {
    def evaluator = new Evaluator()
    def dealer = new Dealer() 
    def hands = [new Hand(), new Hand()]

    dealer.deck.shuffle()

    5.times {
      hands.each { h ->
        h.cards << dealer.deal()
      }
    }

    def winner = evaluator.choose(hands[0], hands[1])

    hands.each { h ->
      println h.toString() + ((h == winner) ? " WINNER" : "")
    }
  }
}