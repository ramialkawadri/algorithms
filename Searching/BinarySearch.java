public class BinarySearch {
    public static int search(int[] nums, int value) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == value) return mid;
            else if (nums[mid] > value) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }
}
