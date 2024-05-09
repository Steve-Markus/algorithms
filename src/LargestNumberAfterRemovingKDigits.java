import java.util.ArrayDeque;
import java.util.Deque;

public class LargestNumberAfterRemovingKDigits {

  public static void main(String[] args) {
    // read input
    String num = "1432219";
    int k = 3;
    String largestNumber = removeKDigits(num, k);
    System.out.println(
        "The largest number after removing " + k + " digits from " + num + " is: " + largestNumber);
  }

  private static String removeKDigits(String num, int k) {
    if (k >= num.length()) {
      return "0"; // if we need to remove all digits, the result is 0
    }

    Deque<Character> deque = new ArrayDeque<>();
    // remove k digits from number while maintaining the order to maximize the value
    for (char digit : num.toCharArray()) {
      while (k > 0 && !deque.isEmpty() && deque.peek() > digit) {
        deque.pop();
        k--;
      }
      deque.push(digit);
    }

    // if k is still greater than 0, we need to remove remaining digits from the end
    while (k > 0) {
      deque.pop();
      k--;
    }

    // construct the result String
    StringBuilder result = new StringBuilder();
    while (!deque.isEmpty()) {
      result.insert(0, deque.pop());
    }

    // remove leading zeros
    while (result.length() > 1 && result.charAt(0) == '0') {
      result.deleteCharAt(0);
    }

    return result.toString();
  }
}