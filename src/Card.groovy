class Card {

  static List<String> values = ['A','K','Q','J','T','9','8','7','6','5','4','3','2']
  static List<String> suits = ['C', 'H', 'D', 'S']

  private String str

  public Card(String str) {
    if (!(str ==~ /[2-9KTQJA]{1}[CDSH]{1}/))
      throw new IllegalArgumentException()
    
    this.str = str
  }

  public String getValue() {
    str[0]
  }

  public String getSuit() {
    str[1]
  }

  @Override
  public String toString() {
    "${value}${suit}"
  }
}
