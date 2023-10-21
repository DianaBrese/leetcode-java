
public class MergeStringsAlternately {
	public static void mergeAlternately(String word1, String word2) {

		char[] splittedWord1 = word1.toCharArray();
		char[] splittedWord2 = word2.toCharArray();

		char[] longestWord = new char[0];
		char[] smallestWord = new char[0];

		if (splittedWord1.length > splittedWord2.length) {
			longestWord = splittedWord1;
			smallestWord = splittedWord2;
		} else {
			longestWord = splittedWord2;
			smallestWord = splittedWord1;

		}

		int diff = longestWord.length - smallestWord.length;

		char[] mergedWord = new char[splittedWord1.length + splittedWord2.length];
		for (int i = 0, j = 0; i < mergedWord.length; i += 2, j++) {
			if (diff != 0) {
				if (j >= smallestWord.length) {
					for (int k = j; k < longestWord.length; k++, i++) {
						mergedWord[i] = longestWord[k];
					}
					break;
				}
			}

			if (j < splittedWord1.length) {
				mergedWord[i] = splittedWord1[j];
			} else {

			}
			if (j < splittedWord2.length) {
				mergedWord[i + 1] = splittedWord2[j];
			} else {

			}

		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < mergedWord.length; i++) {
			result.append(mergedWord[i]);
		}

		System.out.println(result);
	}

	public static void main(String[] args) {
		mergeAlternately("abcd", "pq");

	}
}
