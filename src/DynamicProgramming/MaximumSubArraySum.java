package DynamicProgramming;


import java.util.ArrayList;
import java.util.List;

public class MaximumSubArraySum {
  public static void main(String[] args) {
    List<int[]> list = new ArrayList<>();
    list.add(new int[] {904, 40, 523, 12, -335, -385, -124, -481, -31});
    list.add(new int[] {1, 2, -3, -5, 10, 20, -9});
    list.add(new int[] {1, 9, -3, 5, -10, 20, -9});
    list.add(new int[] {2, -4, 9, 5, 10, 20, -9});
    list.add(new int[] {-2, 4, 9, -5, 10, -20, 9});
    list.add(new int[] {});
    list.add(new int[] {1});
    list.add(new int[] {1, 2, 3, 4, 5});
    list.add(new int[] {-1, 2, 3, 4, 5});
    list.add(new int[] {1, 2, 3, 4, -5});
    list.add(new int[] {-1, 2, 3, 4, -5});
    list.add(new int[] {-1, 2, -3, 4, -5});
    list.add(new int[] {-1, -2, -3, 4, -5});
    list.add(new int[] {-1, -2, -3, -4, -5});
    list.add(new int[] {-1, 3, -2, 4, -5});
    for (int i = 0; i < list.size(); i++) {
      System.out.println(maxSum1(list.get(i)) + " " + maxSum2(list.get(i)) + " " + maxSum3(list.get(i)));
    }

  }

//  private static int maxSum(int[] arr) {
//
//    int low = 0;
//    int high = arr.length;
//
//
//  }

  //Prefix sum O(n^2)
  private static int maxSum2(int[] arr) {
    if (arr.length == 0 || arr == null) return -1;
    if (arr.length == 1) return arr[0];
    int[] prefixSum = new int[arr.length];
    prefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        sum = prefixSum[j] - prefixSum[i] + arr[i];
        max = Math.max(max, sum);
      }
    }
    return max;
  }

  //Brute Force - O(n^3)
  private static int maxSum1(int[] arr) {
    if (arr.length == 0 || arr == null) return -1;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += arr[k];
        }
        max = Math.max(max, sum);
      }
    }
    return max;
  }

  //My Approach (DP) - O(n)
  private static int maxSum3(int[] arr) {
    if (arr.length == 0 || arr == null) return -1;
    if (arr.length == 1) return arr[0];
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] + arr[i] > arr[i]) {
        arr[i] = arr[i - 1] + arr[i];
      }
      max = Math.max(max, arr[i]);
    }
    return max;
  }


}
