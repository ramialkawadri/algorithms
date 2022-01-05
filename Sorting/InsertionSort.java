public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int num = nums[i];

            while (j > 0 && nums[j - 1] > num) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = num;
        }
    }
}
