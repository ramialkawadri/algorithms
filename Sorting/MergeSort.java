class MergeSort {
    public static void sort(int[] nums) {
        if (nums.length <= 1) return;
        int[] first = new int[nums.length / 2];
        int[] second = new int[nums.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = nums[i];
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = nums[i + first.length];
        }

        sort(first);
        sort(second);
        merge(first, second, nums);
    }

    public static void merge(int[] first, int[] second, int[] nums) {
        int iFirst = 0;
        int iSecond = 0;

        for (int i = 0; i < nums.length; i++) {
            if (iSecond >= second.length || (iFirst < first.length 
                    && first[iFirst] < second[iSecond])) {

                nums[i] = first[iFirst];
                iFirst++;
            } else {
                nums[i] = second[iSecond];
                iSecond++;
            }
        }
    }
}
