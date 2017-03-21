
public class HammingDistance {

    public static String integerToBinary(int x) {
        String ans = "";
        while (x >= 1) {
            ans = Integer.toString(x % 2) + ans;
            x = x / 2;
        }
        return ans;
    }

    public static int getDistance(String x, String y) {
        int ans = 0;
        for (int i = 0; i < x.length(); i++) {
            // System.out.println(i);
            // System.out.println(small_string.length());
            if (x.charAt(i) != y.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }

    public static int hammingDistance(int x, int y) {
        String x_binary_str = integerToBinary(x);
        String y_binary_str = integerToBinary(y);
        int len_x = x_binary_str.length(), len_y = y_binary_str.length(), zeros_required;
        String big_string, small_string;
        if (len_x > len_y) {
            big_string = x_binary_str;
            zeros_required = len_x - len_y;
            small_string = new String(new char[zeros_required]).replace('\0', '0') + y_binary_str;
        } else {
            big_string = y_binary_str;
            zeros_required = len_y - len_x;
            small_string = new String(new char[zeros_required]).replace('\0', '0') + x_binary_str;
        }
        // System.out.println("X in binary: " + x_binary_str);
        // System.out.println("Y in binary: " + y_binary_str);
        int hamming_distance = getDistance(big_string, small_string);
        return hamming_distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
