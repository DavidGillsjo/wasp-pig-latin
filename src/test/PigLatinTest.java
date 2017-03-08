import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
                map.put("latin,", "atinlay,");
                map.put("banana", "ananabay");
                map.put("banana???", "ananabay???");
                map.put("trash", "ashtray");
                map.put("trash.", "ashtray.");
                
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        String correct = (String)pair.getValue();
                        String translated = pig.translate((String)pair.getKey());
                        assertEquals(correct, translated);
                }
        }
        @Test
        public void runQuiz() {
                PigLatin pig = new PigLatin();
                String english_sentence = pig.getQuizSentence();
                assertTrue((english_sentence != null && !english_sentence.isEmpty()));
                //translated_sentence = pig.getQuizSentence();
        }

}
