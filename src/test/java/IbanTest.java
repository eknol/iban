import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class IbanTest {

  private Iban ibanChecker;

  @Before
  public void before() {
    ibanChecker = new Iban();
  }

  @Test
  public void IbanIsNotEmpty() {
    //arrange
    String iban = "NL05 RABO 1234 1234 00";

    //act
    Boolean result = ibanChecker.validate(iban);

    //assert
    assertTrue(result);
  }

  @Test
  public void IbanIsMax34Characters() {
    //arrange
    String iban = "1234567890123456789012345678901234";

    //act
    Boolean result = ibanChecker.validateLength(iban);

    //assert
    assertTrue(result);
  }

  @Test
  public void IbanStartsWithNL() {
    //arrange
    String iban = "NL05 RABO 1234 1234 00";

    //act
    Boolean result = ibanChecker.validateNL(iban);

    //assert
    assertTrue(result);
  }

  @Test
  public void IbanCheckSum() {
    //arrange
    String iban = "NLxx INGB 0001 2345 67"; //20

    //act
    int result = ibanChecker.ibanCheckSum(iban);

    //assert
    assertEquals(String.valueOf(result), "20");
  }
}
