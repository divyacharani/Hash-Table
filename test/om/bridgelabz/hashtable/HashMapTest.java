package om.bridgelabz.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashMapTest {

	// To test the frequency of words in a sentence
	@Test
	public void test() {
		String sentence = "To be or not to be";
		HashMap<String, Integer> myHashMap = new HashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myHashMap.add(word, value);
		}
		
		int frequency = myHashMap.get("to");
		System.out.println(myHashMap);
		assertEquals(2, frequency);

	}

}
