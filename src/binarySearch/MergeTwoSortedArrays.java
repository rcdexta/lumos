package binarySearch;

//https://www.youtube.com/watch?v=LPFhl65R7ww&t=365s
public class MergeTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int len1 = nums1.length;
        int len2 = nums2.length;

        int l1 = 0, r1 = len1 - 1;
        int leftX = 0, leftY = 0, rightX = 0, rightY = 0;

        while (l1 < r1) {
            int mid1 = l1 + (r1 - l1) / 2;

            int mid2 = (len1 + len2 + 1) / 2 - (mid1 + 1) - 1;

            leftX = nums1[mid1];
            leftY = nums2[mid2];
            rightX = mid1 < len1 - 1 ? nums1[mid1 + 1] : nums1[mid1];
            rightY = mid2 < len2 - 1 ? nums2[mid2 + 1] : nums2[mid2];

            System.out.printf("%d %d %n", mid1, mid2);
            System.out.printf("%d %d %d %d %n", leftX, leftY, rightX, rightY);

            if (leftX <= rightY && leftY <= rightX) break;
            else if (leftX > rightY) r1 = mid1;
            else l1 = mid1;
        }

        if ((len1 + len2) % 2 != 0) return Math.max(leftX, leftY);
        else return (Math.max(leftX, leftY) + Math.max(leftX, leftY)) / 2.0;

    }

}
