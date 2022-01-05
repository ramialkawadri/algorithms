/**
 * SelectionSort
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            // finding minimum element
            int smallestindex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallestindex]) smallestindex = j;
            }

            swap(nums, smallestindex, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
