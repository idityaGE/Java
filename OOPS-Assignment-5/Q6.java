
class Q6 {

    private static String getString(int num) {
        if (num >= 0 && num <= 9) {
            return new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}[num];
        } else if (num >= 11 && num <= 19) {
            return new String[]{"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}[num - 11];
        } else if (num % 10 == 0) {
            return new String[]{"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninty"}[num / 10 - 1];
        } else {
            return getString(num - num % 10) + " " + getString(num % 10);
        }
    }

    private static String convertToWords(long num) {
        if (num == 0) return "zero";
        

        StringBuilder words = new StringBuilder();

        if (num / 10000000 > 0) {
            words.append(getString((int) (num / 10000000))).append(" crore ");
            num %= 10000000;
        }
        if(num / 100000 > 0) {
            words.append(getString((int) (num / 100000))).append(" lakh ");
            num %= 100000;
        }
        if (num / 1000 > 0) {
            words.append(getString((int) (num / 1000))).append(" thousand ");
            num %= 1000;
        }
        if (num / 100 > 0) {
            words.append(getString((int) (num / 100))).append(" hundred ");
            num %= 100;
        }
        if (num > 0) {
            if (num < 10 || (num >= 11 && num <= 19) || num % 10 == 0) {
                words.append(getString((int) num));
            } else {
                words.append(getString((int) (num / 10) * 10)).append(" ").append(getString((int) (num % 10)));
            }
        }
        String result = words.toString().trim();
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }

    public static void main(String[] args) {
        long number = 3021320;
        String ans = convertToWords(number);
        System.out.println(ans);
    }
}
