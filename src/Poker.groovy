class Poker {
  public static void main(String[] args) {
    def evaluator = new Evaluator()

    println "Simple Poker Hand Evaluator"
    println "======================================="
    println ""
    println "Instructions:"
    println " - Enter each hand in the following format:"
    println "    {V}{S} {V}{S} {V}{S} {V}{S} {V}{S}"
    println "     Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds"
    println "     Values: 2,3,4,5,6,7,8,9,T,J,Q,K,A"
    println "  - Example:"
    println "     AC 2D TH 3S 5D"
    println ""

    String a = System.console().readLine 'Black: '
    String b = System.console().readLine 'White: '

    try {
      Map players = [
        'Black': new Hand(a.tokenize(' ')),
        'White': new Hand(b.tokenize(' '))
        ]

      def result = evaluator.choose(players['Black'], players['White'])
      def winner = players.find { k,v -> result == v }

      println "${winner.key} wins - ${result}"
      
    }
    catch (InvalidHand e) {
      println "Hands must consist of 5 cards."
    }
    catch (Exception e) {
      println "An unexpected error occured. [${e.message}]"        
    }
  }
}
