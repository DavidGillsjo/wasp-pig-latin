import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Collections;

public class PigLatinTest {

        @Test
        public void translateWord() {
                PigLatin pig = new PigLatin();
                Map<String, String> map = new HashMap<String, String>();

                map.put("pig", "igpay");
                map.put("latin", "atinlay");
                map.put("banana", "ananabay");
                map.put("trash", "ashtray");

                map.put("Trash", "Ashtray");

                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        String correct = (String)pair.getValue();
                        String translated = pig.translateWord((String)pair.getKey());
                        assertEquals(correct, translated);
                }
        }

}
