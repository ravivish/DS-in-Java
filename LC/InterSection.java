package LC;

import java.util.HashMap;

public class InterSection {

    private static int lenhelper(int[] nums1, int[] nums2) {
        int len = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i >= nums1.length - 1) {
                    continue;//break;
                }
                if (nums1[i] == nums2[j]) {
                    len++;
                    i++;
                }
            }
        }
        return len;
    }

    private static int[] arrhelper(int[] nums1, int[] nums2, int len) {
        int k = 0;
        int arr[] = new int[len];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (i >= nums1.length - 1) {
                    continue;
                }
                if (nums1[i] == nums2[j]) {
                    arr[k] = nums1[i];
                    k++;
                    i++;
                }
            }
        }
        return arr;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        int res=0;
        if (nums1.length < nums2.length)
            res=lenhelper(nums2, nums1);
        else
            res=lenhelper(nums1, nums2);
        int[] arr=new int[res];
        if (nums1.length < nums2.length)
            arr=arrhelper(nums2, nums1,res);
        else
            arr=arrhelper(nums1, nums2,res);
        return arr;

    }

    public static void main(String[] args) {
        int arr1[] = {4,9,5};
        int arr2[] = {9,4,9,8,4};
        int arr[] = intersect(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
