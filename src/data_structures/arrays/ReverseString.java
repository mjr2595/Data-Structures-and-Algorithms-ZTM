package data_structures.arrays;

// create a function that reverse a string:
// example: "Hello World" becomes "dlroW olleH"

public class ReverseString {
    private static String reverse(String string) {
        StringBuilder rev = new StringBuilder();
        // iterate backwards
        for (int i = string.length() - 1; i >= 0; i--) {
            rev.append(string.charAt(i));
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("gfedcba"));
    }
}
