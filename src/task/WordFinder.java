package task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordFinder {
	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the word");
		String chars = scanner.nextLine().toLowerCase();

		Map<Character, Integer> charsCount = countCharaters(chars);

		BufferedReader reader = new BufferedReader(new FileReader("english3.txt"));

		for (String word = reader.readLine(); word != null; word = reader.readLine()) {
			Map<Character, Integer> currentWordMap = countCharaters(word);

			boolean canMakeWord = true;
			for (Character character : currentWordMap.keySet()) {
				int currentWordCharCout = currentWordMap.get(character);
				int letterCharCount;
				if (charsCount.containsKey(character)) {
					letterCharCount = charsCount.get(character);
				} else
					letterCharCount = 0;

				if (currentWordCharCout > letterCharCount) {
					canMakeWord = false;
					break;
				}

			}
			if (canMakeWord) {
				System.out.println(word);
			}
		}

	}

	public static Map<Character, Integer> countCharaters(String chars) {

		Map<Character, Integer> mapChara = new HashMap<Character, Integer>();

		for (int i = 0; i < chars.length(); i++) {
			if (mapChara.containsKey(chars.charAt(i))) {
				mapChara.put(chars.charAt(i), mapChara.get(chars.charAt(i)) + 1);
			} else
				mapChara.put(chars.charAt(i), 1);
		}

		return mapChara;

	}
}
