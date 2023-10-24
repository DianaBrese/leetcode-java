import java.util.ArrayList;
import java.util.List;

public class Flowers {

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0) {
			System.out.println(true);
			return true;
		}

		List<Boolean> planted = new ArrayList<>();
		for (int i = 0; i < flowerbed.length; i++) {
			if (i == 0) {
				if (flowerbed.length - 1 == i) {
					if (flowerbed[i] == 1) {
						planted.add(false);
					} else {
						planted.add(true);
						flowerbed[i] = 1;
					}
				} else {
					if (flowerbed[i + 1] == 1 || flowerbed[i] == 1) {
						planted.add(false);
					} else {
						planted.add(true);
						flowerbed[i] = 1;
					}
				}

			} else if (i == flowerbed.length - 1) {
				if (flowerbed[i - 1] == 1 || flowerbed[i] == 1) {
					planted.add(false);
				} else {
					planted.add(true);
					flowerbed[i] = 1;

				}
			} else {
				if (flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1 || flowerbed[i] == 1) {
					planted.add(false);
				} else {
					planted.add(true);
					flowerbed[i] = 1;
				}
			}

		}

		long countTrue = planted.stream().filter(value -> value.equals(true)).count();
		if (countTrue == n || n < countTrue) {
			System.out.println(true);
			return true;
		} else {
			System.out.println(false);
			return false;

		}

	}

	public static void main(String[] args) {
		int[] flowerbed = new int[] { 0,0,1,0,0 };
		canPlaceFlowers(flowerbed, 1);
	}

}
