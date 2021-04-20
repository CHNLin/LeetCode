/*
给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
如果存在则返回 true，不存在返回 false。

输入：nums = [1,2,3,1], k = 3, t = 0
输出：true
 */


/*
Point:
java.util.TreeSet.floor()方法和java.util.TreeSet.ceiling()方法
floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.

 */

import java.util.TreeSet;

public class containsNearbyAlmostDuplicate {
    public static boolean My_containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] argv){
        int[] nums = new int[]{1,2,3,1};
        System.out.println(My_containsNearbyAlmostDuplicate(nums,3,0));
    }

}
