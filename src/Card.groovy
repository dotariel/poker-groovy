class Card {

  static List<String> values = ['A','K','Q','J','T','9','8','7','6','5','4','3','2']
  static List<String> suits = ['C', 'H', 'D', 'S']
  static Map<String,Integer> faces = ['T':10, 'J':11, 'Q':12, 'K':13, 'A':14]

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

  public static int val(String str) {
    values.indexOf(str)    
  }

  public static int getCardValue(String s) {
    faces[s] ?: new Integer(s)
  }
}
