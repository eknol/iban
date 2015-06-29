public class AlphabetCalculator {

  public int calculator(String chara) {
    String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    return allChars.indexOf(chara) + 10;
  }
}
