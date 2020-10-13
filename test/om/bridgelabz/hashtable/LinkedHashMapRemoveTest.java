package om.bridgelabz.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedHashMapRemoveTest {

	// Test to remove a word
	@Test
	public void testMyHashtableParagraph() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		LinkedHashMap<String, Integer> myLinkedHashMap = new LinkedHashMap<>();
		String[] words = sentence.toLowerCase().split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value = value + 1;
			myLinkedHashMap.add(word, value);
		}
		MapNode removed = myLinkedHashMap.remove("avoidable");
		System.out.println(myLinkedHashMap);
		assertEquals("avoidable", removed.getKey());
	}

}
