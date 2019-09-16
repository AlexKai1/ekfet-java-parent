package com.ekfet.leetcode;


import java.util.*;

public class ArrayAlgorithm {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * <p>
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        assert nums.length > 2;
        Arrays.sort(nums);
        int left;
        int right;
        int sum3;  //数组中的三个数的和
        int res = 0;  //记录返回结果
        int tmp = Integer.MAX_VALUE; //记录sum3和target的差的绝对值
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum3 = nums[left] + nums[right] + nums[i];
                //如果已经找到等于target的三个数，直接返回即可。
                if (sum3 == target) {
                    return target;
                }
                if (Math.abs(sum3 - target) < tmp) {
                    tmp = Math.abs(sum3 - target);
                    res = sum3;
                }
                if (sum3 > target) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return res;
    }

    public static int threeSumClosestBak(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2 && nums[i] <= target / 3; i++) {
            int s;
            if ((s = nums[nums.length - 2] + nums[nums.length - 1] + nums[i]) < target) {
                if (Math.abs(target - s) < Math.abs(target - ans)) {
                    ans = s;
                }
                continue;
            }
            if ((s = nums[i + 2] + nums[i + 1] + nums[i]) > target) {
                if (Math.abs(target - s) < Math.abs(target - ans)) {
                    ans = s;
                }
                return ans;
            }

            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<String> letterCombinations(String digits) {
        Map<String, String[]> map = new HashMap<String, String[]>();
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"g", "h", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});

        for (int i = 0; i < digits.length(); i++) {

        }
        return null;

    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static String toLowerCase(String str) {
        int length = str.length();
        byte[] newByte = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            if (bytes[i] < 97 && bytes[i] >= 65) {
                newByte[i] = (byte) (bytes[i] + 32);
            } else {
                newByte[i] = bytes[i];
            }
        }
        return new String(newByte);
    }

    public static boolean isArmstrong(int N) {
        String str = String.valueOf(N);
        int length = str.length();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), length);
        }
        return sum == N ? true : false;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        Integer[] nums = new Integer[nums1.length + nums2.length];

    }

    public static int fixedPoint(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i) {
                return i;
            }
        }
        return -1;
    }

    public static int numJewelsInStones(String J, String S) {
        Set<Character> chars = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            chars.add(J.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

}
