class Sim {
  public static void main(String[] args) {
    def times = args[0] as Integer

    def start = System.currentTimeMillis()

    def results = [:]
    times.times {
      def winner = new Sim().run()
      def key = winner ? winner.rank : 'Tie'

      results[key] = (results[key] ?: 0) + 1
    }

    def end = System.currentTimeMillis()

    results.sort { a,b -> b.value <=> a.value }.each { k,v ->
      double perc = (v / times) * 100
      println "${k}: ${v} (${perc}%)"
    }

    println "Total Ms: ${end - start}"
      
  }

  def evaluator
  def dealer
  def hands = []

  public Sim() {
    evaluator = new Evaluator()
    dealer = new Dealer()
    hands = [new Hand(), new Hand()]
  }

  public Hand run() {
    dealer.deck.shuffle()
    deal()
    evaluator.choose(hands[0], hands[1])
  }

  private void deal() {
    5.times { hands.each { it.cards << dealer.deal() } }
  }
}