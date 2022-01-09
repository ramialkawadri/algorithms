public class LinearSearch {
    public static int search(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == value) return i;
        }

        return -1;
    }
}
