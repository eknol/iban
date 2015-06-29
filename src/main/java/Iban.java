import java.math.BigInteger;

public class Iban {

  public Boolean validate(String iban) {
    if (iban != "") {
      return true;
    } else {
      return false;
    }
  }

  public Boolean validateLength(String iban) {
    if (iban.length() < 35) {
      return true;
    } else {
      return false;
    }
  }


  public Boolean validateNL(String iban) {
    if (iban.startsWith("NL")) {
      return true;
    } else {
      return false;
    }
  }

  public int ibanCheckSum(String iban) {
    String ibanWithoutSpace = iban.replaceAll("\\s+", "");
    String accountNumber = ibanWithoutSpace.substring(8);
    String bankNumber = ibanWithoutSpace.substring(4, 8);
    String countyNumber = ibanWithoutSpace.substring(0, 2);

    while (accountNumber.length() < 10) {
      accountNumber = "0" + accountNumber;
    }

    AlphabetCalculator result = new AlphabetCalculator();
    StringBuffer sb = new StringBuffer(accountNumber);
    StringBuffer sb2 = new StringBuffer();

    for (char x: bankNumber.toCharArray()) {
      int value = result.calculator(String.valueOf(x));
      sb2.append(value);
    }

    sb.insert(0, String.valueOf(sb2));

    accountNumber = String.valueOf(sb);

    for (char x: countyNumber.toCharArray()) {
      int value = result.calculator(String.valueOf(x));
      accountNumber = accountNumber.concat(String.valueOf(value));
    }

    accountNumber = accountNumber.concat("00");

    BigInteger bi1, bi2, bi3;

    Integer i1;

    bi1 = new BigInteger(accountNumber);
    bi2 = new BigInteger(String.valueOf(97));

    bi3 = bi1.mod(bi2);
    i1 = bi3.intValue();

    int checkSum = 98 - i1;

    System.out.println("CheckSum: " + checkSum);

    return checkSum;
  }
}
