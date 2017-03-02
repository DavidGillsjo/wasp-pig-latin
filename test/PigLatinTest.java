import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PigLatinTest {
  @Test
  public void translateWord() {
    PigLatin pig = new PigLatin();
    String word = pig.translate("pig");
    assertEquals("igpay", word);
  }
}