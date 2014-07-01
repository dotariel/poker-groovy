class Poker {
  public static void main(String[] args) {
    def evaluator = new Evaluator()

    println "Simple Poker Hand Evaluator"
    println "======================================="
    println ""
    println "Instructions:"
    println " - Enter each hand in the following format:"
    println "    {F}{C} {F}{C} {F}{C} {F}{C} {F}{C}"
    println "     Suits: C=Clubs, H=Hearts, S=Spades, D=Diamonds"
    println "     Faces: 2,3,4,5,6,7,8,9,T,J,Q,K,A"
    println "  - Example:"
    println "     AC 2D TH 3S 5D"
    println ""

    String a = System.console().readLine 'Hand 1: '
    String b = System.console().readLine 'Hand 2: '

    try {
      Hand h1 = new Hand(a.tokenize(' '))
      Hand h2 = new Hand(b.tokenize(' '))

      println evaluator.choose(h1,h2) ?: "Tie" 
    }
    catch (InvalidHand e) {
      println "Hands must consist of 5 cards."
    }
    catch (Exception e) {
      println "An unexpected error occured. [${e.message}]"        
    }
  }
}