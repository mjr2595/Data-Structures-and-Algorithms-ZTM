package data_structures.arrays;

// merge two sorted arrays so that final result is a merged sorted array.
// example: [0,3,4,31] and [4,6,30] when merged gives output: [0, 3, 4, 4, 6, 30, 31]
// Note that this does NOT remove duplicates!

import java.util.Arrays;

public class MergeSortedArrays {
    private static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        // Need three pointers, one for each array Only increment the pointer if the value is lower
        int array1Index = 0;
        int array2Index = 0;
        int mergedIndex = 0;

        // Only increment the pointer if the value is lower
        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                merged[mergedIndex] = array1[array1Index];
                array1Index++;
            } else {
                merged[mergedIndex] = array2[array2Index];
                array2Index++;
            }
            mergedIndex++;
        }

        // should have gone through one of the arrays
        // only add in the remainder for the array where the index is still < length

        // add in any left over from array1
        if (array1Index < array1.length) {
            while (array1Index < array1.length) {
                merged[mergedIndex] = array1[array1Index];
                array1Index++;
                mergedIndex++;
            }
        }

        // add in any left over from array2
        if (array2Index < array2.length) {
            while (array2Index < array2.length) {
                merged[mergedIndex] = array2[array2Index];
                array2Index++;
                mergedIndex++;
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] test;
        test = mergeSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(test));
        test = mergeSortedArrays(new int[]{1, 7}, new int[]{2, 4, 6});
        System.out.println(Arrays.toString(test));
        test = mergeSortedArrays(new int[]{1}, new int[]{1});
        System.out.println(Arrays.toString(test));
    }
}
