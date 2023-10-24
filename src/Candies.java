import java.util.ArrayList;
import java.util.List;

public class Candies {

	public static void kidsWithCandies(int[] candies, int extraCandies) {

		List<Boolean> result = new ArrayList<>();
		List<Boolean> isTrueOrFalse = new ArrayList<>();
		for(int i = 0; i < candies.length; i++) {
			int sum = candies[i] + extraCandies;
			for(int j = 0; j < candies.length; j++) {
				if(sum >= candies[j]) {
					isTrueOrFalse.add(true);
				} else {
					isTrueOrFalse.add(false);
				}
			}
			if(isTrueOrFalse.contains(false)) {
				result.add(false);
			} else {
				result.add(true);
			}
			
			isTrueOrFalse = new ArrayList<Boolean>();
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		int[] candies = new int[] {12,1,12 };
		kidsWithCandies(candies, 10);
	}

}
