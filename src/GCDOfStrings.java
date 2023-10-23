import java.util.ArrayList;
import java.util.List;

public class GCDOfStrings {

	public static void gcdOfStrings(String str1, String str2) {

		String smallest = "";
		String longest = "";

		if (str2.length() > str1.length()) {
			longest = str2;
			smallest = str1;
		} else {
			longest = str1;
			smallest = str2;
		}

		List<String> divisors1 = new ArrayList<String>(divideString(longest, smallest));

		List<String> divisors2 = new ArrayList<String>(divideString(smallest, longest));

		//System.out.println(divisors1);
		//System.out.println(divisors2);
		
		List<String> biggerList = new ArrayList<String>();
		List<String> smallestList = new ArrayList<String>();
		if (divisors1.size() > divisors2.size()) {
			biggerList = new ArrayList<String>(divisors1);
			smallestList = new ArrayList<String>(divisors2);
		} else {
			biggerList = new ArrayList<String>(divisors2);
			smallestList = new ArrayList<String>(divisors1);
		}

		String result = "";

		for (int i = biggerList.size() - 1; i >= 0; i--) {

		
				if (smallestList.contains(biggerList.get(i))) {
					result = (biggerList.get(i));
					break;
				} 
			

		}

		System.out.println(result);

	}

	public static List<String> divideString(String str1, String str2) {

		StringBuilder divisor = new StringBuilder();
		divisor.append(str1.charAt(0));

		List<String> result = new ArrayList<String>();
		boolean control = true;

		while (control == true) {

			for (int i = 0; i < str2.length(); i = i + divisor.length()) {

				int start = i;
				int end = i + divisor.length() - 1;
				if (end > str2.length() - 1) {
					break;
				}

				for (int k = start, h = 0; k <= end; k++, h++) {

					if (str2.charAt(k) == divisor.charAt(h)) {
						if (k == str2.length() - 1) {
							result.add(divisor.toString());
						}
					} else {
						i = str2.length() + 1;
						break;
					}

				}

			}

			if (divisor.length() > str1.length() - 1) {
				control = false;
			} else {
				divisor.append(str1.charAt(divisor.length()));

			}

		}

		return result;

	};

	public static void main(String[] args) {
		gcdOfStrings(
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
				"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}

}