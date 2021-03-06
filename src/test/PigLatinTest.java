import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Collections;

public class PigLatinTest {

        @Test
        public void translatePlainWord() {
                PigLatin pig = new PigLatin();
                Map<String, String> map = new HashMap<String, String>();

                map.put("pig", "igpay");
                map.put("latin", "atinlay");
                map.put("banana", "ananabay");
                map.put("trash", "ashtray");
                map.put("Trash", "Ashtray");
                map.put("T", "Tay");
                map.put("a", "away");
                map.put("eat", "eatway");
                map.put("cheers", "eerschay");

                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        String correct = (String)pair.getValue();
                        String translated = pig.translateWord((String)pair.getKey());
                        assertEquals(correct, translated);
                }
        }
        
        @Test
		public void translatePunctuatedWord() {
                PigLatin pig = new PigLatin();
                Map<String, String> map = new HashMap<String, String>();
                
                map.put("latin,", "atinlay,");
                map.put("banana...", "ananabay...");
                map.put("banana???", "ananabay???");
                map.put("banana!!", "ananabay!!");
		            map.put("we're", "e'reway");
                map.put("t!", "tay!");

                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        String correct = (String)pair.getValue();
                        String translated = pig.translateWord((String)pair.getKey());
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
        
        @Test
        public void translateSentence() {
                PigLatin pig = new PigLatin();
                Map<String, String> map = new HashMap<String, String>();

                map.put("pig latin banana trash", "igpay atinlay ananabay ashtray");
                map.put("pig latin    banana trash", "igpay atinlay ananabay ashtray");
                map.put("pig latin, banana trash!", "igpay atinlay, ananabay ashtray!");
                
                Iterator it = map.entrySet().iterator();
                while (it.hasNext()){
                        Map.Entry pair = (Map.Entry)it.next();
                        String correct = (String)pair.getValue();
                        String translatedSentence = pig.translateSentence((String)pair.getKey());
                        assertEquals(correct, translatedSentence);
                }
        }

}
