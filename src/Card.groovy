
class Card {

  static List<String> values = ['A','K','Q','J','T','9','8','7','6','5','4','3','2']
  static List<String> suits = ['C', 'H', 'D', 'S']

  String suit
  String value

  public Card(String value, String suit) {
    this.value = value
    this.suit = suit
  }

  @Override
  public String toString() {
    "${value}${suit}"
  }
}
