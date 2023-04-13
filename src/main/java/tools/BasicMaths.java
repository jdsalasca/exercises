package tools;

public class BasicMaths {
	public int mySqrt(int x) {
		Double response = Math.sqrt(x);
		return (response.intValue());
	}

	public int tribonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 2 || i == 1) {
			return 1;
		}
		return tribonacci(i - 1) + tribonacci(i - 2) + tribonacci(i - 3);
	}

	public int tribonacci_list(int i) {
		int dp[] = new int[i];
		if (i == 0) {
			return 0;
		}
		if (i == 2 || i == 1) {
			return 1;
		}
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int j = 3; j < i; j++) {
			dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];

		}
		return dp[i - 1] + dp[i - 2] + dp[i - 3];
	}

	public int singleNumber(int[] nums) {

		for (int number : nums) {
			int counter = 0;
			for (int num : nums) {
				if (num == number) {
					counter++;
				}
			}
			if (counter == 1) {
				return number;
			}
		}
		return 1;
	}

	public int singleNumberII(int[] nums) {
		int unique = nums[0];
		for (int i = 1; i < nums.length; i++) {
			unique ^= nums[i]; // Unique es unique o es el nuevo valor pero no es ambos y adicionalmente unique
								// toma el nuevo valor
		}
		return unique;
	}

	public int countOdds(int low, int high) {
		int counter = 0;
		for (int i = low; i <= high; i++) {
			if (i % 2 != 0) {
				counter++;
			}
		}
		return counter;
	}

	public String sum_binaries(String bin1, String bin2) {
		int len1 = bin1.length();
		int len2 = bin2.length();
		int maxLen = Math.max(len1, len2);
		int saver = 0;
		StringBuilder result = new StringBuilder(maxLen + 1);
		for (int i = 0; i < maxLen; i++) {
		    int a = saver;
		    if (i < len1) {
		        a += bin1.charAt(len1 - i - 1) - '0';
		    }
		    if (i < len2) {
		        a += bin2.charAt(len2 - i - 1) - '0';
		    }

		    if (a == 0 || a == 1) {
		        saver = 0;
		        result.append(a);
		    } else if (a == 2) {
		        saver = 1;
		        result.append(0);
		    } else { // a == 3
		        saver = 1;
		        result.append(1);
		    }
		}
		if (saver == 1) {
		    result.append(saver);
		}
		return result.reverse().toString();    
	}

	public int countOddsII(int low, int high) {
		return (low % 2 != 0 || high % 2 != 0) ? ((high - low) / 2) + 1 : (high - low) / 2;

	}

}
