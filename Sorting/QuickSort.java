public class QuickSort {
    public static void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int p = parition(nums, start, end);
        sort(nums, start, p - 1);
        sort(nums, p + 1, end);
    }

    public static int parition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j <= end; j++)
        {
            if (nums[j] < pivot)
            {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i + 1];
        nums[i + 1] = nums[end];
        nums[end] = temp;

        return i + 1;
    }
}
 
