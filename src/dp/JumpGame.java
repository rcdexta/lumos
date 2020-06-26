package dp;

import java.util.Arrays;
import java.util.Stack;

public class JumpGame {

    boolean[] blackList;
    Stack<Integer> stack = new Stack<>();

    public boolean canJumpMemo(int position, int[] nums) {
        stack.push(position);

        System.out.println(stack);
        System.out.println(Arrays.toString(blackList));

        if (blackList[position]) return false;
        if (position == nums.length - 1) return true;

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int next = position + 1; next <= furthestJump; next++) {
            if (canJumpMemo(next, nums)) return true;
        }

        blackList[position] = true;
        stack.pop();

        System.out.printf(" = %b %n", false);
        return false;
    }

    public boolean canJumpBF(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int next = position + 1; next <= furthestJump; next++) {
            if (canJumpBF(next, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.printf("%2d", i);
        }
        System.out.println();
        for(int i=0;i<nums.length;i++) {
            System.out.printf("%2d", nums[i]);
        }
        System.out.println();

        return canJumpBF(0, nums);
    }

    public boolean canJumpOptimised(int[] nums) {
        blackList = new boolean[nums.length];
        return canJumpMemo(0, nums);
    }
}
