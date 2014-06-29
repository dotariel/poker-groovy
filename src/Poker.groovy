class Poker {
  public static void main(String[] args) {
    def evaluator = new Evaluator()

    String a = System.console().readLine 'First Hand:'
    String b = System.console().readLine 'Second Hand:'

    Hand h1 = new Hand(a.tokenize(' '))
    Hand h2 = new Hand(b.tokenize(' '))

    println evaluator.choose(h1,h2)
  }
}