/**
 * @author liar
 * @since 2025/11/28
 */
public class BinarySearch {

    /**
     * 暴力查找
     *
     * @param arr    升序数组
     * @param target 目标值
     * @return 目标值索引/-1
     */
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找 <br/>
     * 左右指针，左闭右闭
     *
     * @param arr    升序数组
     * @param target 目标值
     * @return 目标值索引/-1
     */
    public int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找-改动版 <br/>
     * 左右指针，左闭右开
     *
     * @param arr    升序数组
     * @param target 目标值
     * @return 目标值索引/-1
     */
    public int binarySearch_v2(int[] arr, int target) {

        int left = 0, right = arr.length, mid;
        while (left < right) {
            mid = (left + right) >>> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 平衡二分查找 <br/>
     * 根据二分查找改动版进行优化 <br/>
     * 主要解决目标值在最左侧和最右侧的时间复杂度差异
     *
     * @param arr    升序数组
     * @param target 目标值
     * @return 索引
     */
    public int balanceBinarySearch(int[] arr, int target) {
        int left = 0, right = arr.length, mid;
        while (left < right - 1) {
            mid = (left + right) >>> 1;
            if (target < arr[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (target == arr[left]) {
            return left;
        }
        return -1;
    }




}
