package educative.trees;

import ds.trees.BinaryTree;

public class Identical {

    public static boolean areIdentical(BinaryTree root1, BinaryTree root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null || root2 == null) || !root1.value.equals(root2.value)) return false;

        if (!areIdentical(root1.left, root2.left)) return false;
        if (!areIdentical(root1.right, root2.right)) return false;

        return true;
    }
}
