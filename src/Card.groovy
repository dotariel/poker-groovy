class Card {

  static List suits = ['C','H','D','S']

  static Map values = [
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    'T': 10,
    'J': 11,
    'Q': 12,
    'K': 13,
    'A': 14 
  ]

  private String str

  public Card(String str) {
    if (!(str ==~ /[2-9KTQJA]{1}[CDSH]{1}/))
      throw new IllegalArgumentException()
    
    this.str = str
  }

  public String getFace() {
    str[0]
  }

  public String getSuit() {
    str[1]
  }

  public int getValue() {
    values[face]
  }

  @Override
  public String toString() {
    "${face}${suit}"
  }
}
