
class Q6 {

    private static int countDigit(long num) {
        int cnt = 0;
        while (num > 0) {
            num /= 10;
            cnt++;
        }
        return cnt;
    }

    private static String getString(int num) {
        if (num >= 0 && num <= 9) {
            switch (num) {
                case 0:
                    return "zero";
                case 1:
                    return "one";
                case 2:
                    return "two";
                case 3:
                    return "three";
                case 4:
                    return "four";
                case 5:
                    return "five";
                case 6:
                    return "six";
                case 7:
                    return "seven";
                case 8:
                    return "eight";
                case 9:
                    return "nine";
                default:
                    throw new AssertionError();
            }
        } else if (num >= 11 && num <= 19) {
            switch (num) {
                case 11:
                    return "eleven";
                case 12:
                    return "twelve";
                case 13:
                    return "thirteen";
                case 14:
                    return "fourteen";
                case 15:
                    return "fifteen";
                case 16:
                    return "sixteen";
                case 17:
                    return "seventeen";
                case 18:
                    return "eighteen";
                case 19:
                    return "nineteen";
                default:
                    throw new AssertionError();
            }
        } else if (num % 10 == 0) {
            switch (num) {
                case 10:
                    return "ten";
                case 20:
                    return "twenty";
                case 30:
                    return "thirty";
                case 40:
                    return "fourty";
                case 50:
                    return "fifty";
                case 60:
                    return "sixty";
                case 70:
                    return "seventy";
                case 80:
                    return "eighty";
                case 90:
                    return "ninty";
                default:
                    throw new AssertionError();
            }
        } else {
			return "";
		}
    }

    public static void main(String[] args) {

    }
}
