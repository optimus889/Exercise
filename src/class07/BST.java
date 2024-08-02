package class07;

class TreeNode<E> {
    E element;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E o) {
        element = o;
        left = null;
        right = null;
    }
}

public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root;

    public BST() {
        root = null;
    }

    public boolean insert(E e) {
        // 检查根节点是否为空
        if (root == null) {
            // 如果树为空，则创建一个新的节点作为根节点
            root = new TreeNode<>(e);
        } else {
            // 如果树不为空，开始寻找合适的插入位置
            TreeNode<E> parent = null;   // 用于跟踪当前节点的父节点
            TreeNode<E> current = root;  // 从根节点开始遍历树

            // 循环查找插入位置
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    // 如果待插入元素小于当前节点的元素，移动到左子树
                    parent = current;     // 更新父节点为当前节点
                    current = current.left; // 移动到左子节点
                } else if (e.compareTo(current.element) > 0) {
                    // 如果待插入元素大于当前节点的元素，移动到右子树
                    parent = current;     // 更新父节点为当前节点
                    current = current.right; // 移动到右子节点
                } else {
                    // 如果待插入元素等于当前节点的元素，说明树中已存在该元素，不进行插入
                    return false; // 插入失败，返回 false
                }
            }

            // 找到合适的插入位置后，创建新节点并插入
            if (e.compareTo(parent.element) < 0) {
                // 如果待插入元素小于父节点的元素，将新节点插入到父节点的左子树
                parent.left = new TreeNode<>(e);
            } else {
                // 如果待插入元素大于父节点的元素，将新节点插入到父节点的右子树
                parent.right = new TreeNode<>(e);
            }
        }

        // 插入成功，返回 true
        return true;
    }

    // 搜索某个元素的方法
    public boolean search(E e) {
        TreeNode<E> current = root; // 从根节点开始搜索

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left; // 如果搜索元素小于当前节点，向左子树移动
            } else if (e.compareTo(current.element) > 0) {
                current = current.right; // 如果搜索元素大于当前节点，向右子树移动
            } else {
                return true; // 找到元素，返回 true
            }
        }

        return false; // 未找到元素，返回 false
    }

    // 删除某个节点的方法
    public boolean delete(E e) {
        TreeNode<E> parent = null;  // 跟踪父节点
        TreeNode<E> current = root; // 从根节点开始寻找待删除的节点

        // 寻找待删除的节点
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left; // 向左子树移动
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right; // 向右子树移动
            } else {
                break; // 找到待删除的节点
            }
        }

        if (current == null) {
            return false; // 树中没有找到待删除的节点
        }

        // 情况 1: 待删除的节点没有子节点（叶子节点）
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null; // 如果待删除的节点是根节点且没有子节点，直接将根节点设为空
            } else if (current == parent.left) {
                parent.left = null; // 从父节点的左子树中删除
            } else {
                parent.right = null; // 从父节点的右子树中删除
            }
        }
        // 情况 2: 待删除的节点只有一个子节点
        else if (current.left == null) { // 只有右子节点
            if (current == root) {
                root = current.right; // 如果待删除的节点是根节点，右子节点成为新的根节点
            } else if (current == parent.left) {
                parent.left = current.right; // 将右子节点替换为当前节点
            } else {
                parent.right = current.right; // 将右子节点替换为当前节点
            }
        } else if (current.right == null) { // 只有左子节点
            if (current == root) {
                root = current.left; // 如果待删除的节点是根节点，左子节点成为新的根节点
            } else if (current == parent.left) {
                parent.left = current.left; // 将左子节点替换为当前节点
            } else {
                parent.right = current.left; // 将左子节点替换为当前节点
            }
        }
        // 情况 3: 待删除的节点有两个子节点
        else {
            TreeNode<E> rightMostParent = current; // 右子树中最小节点的父节点
            TreeNode<E> rightMost = current.left;  // 从左子树中寻找最大的节点
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }

            // 用右子树中最小的节点替换当前节点
            current.element = rightMost.element;

            // 删除右子树中最小的节点
            if (rightMostParent.right == rightMost) {
                rightMostParent.right = rightMost.left;
            } else {
                rightMostParent.left = rightMost.left;
            }
        }

        return true; // 删除成功
    }

    // 中序遍历方法
    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode<E> node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print(node.element + " ");
        inorderTraversal(node.right);

    }

    public static void main(String[] args) {
        // 创建一个 BST 实例
        BST<Integer> bst = new BST<>();

        // 插入一些元素
        System.out.println("Insert 50: " + bst.insert(50)); // 应输出 true
        System.out.println("Insert 30: " + bst.insert(30)); // 应输出 true
        System.out.println("Insert 70: " + bst.insert(70)); // 应输出 true
        System.out.println("Insert 20: " + bst.insert(20)); // 应输出 true
        System.out.println("Insert 40: " + bst.insert(40)); // 应输出 true
        System.out.println("Insert 60: " + bst.insert(60)); // 应输出 true
        System.out.println("Insert 80: " + bst.insert(80)); // 应输出 true

        // 测试插入已经存在的元素
        System.out.println("Insert 50 again: " + bst.insert(50)); // 应输出 false

        // 遍历并显示树的结构
        System.out.println("Inorder traversal of the BST:");
        bst.inorderTraversal();

        // 测试搜索功能
//        System.out.println("Search for 30: " + bst.search(30)); // 应输出 true
//        System.out.println("Search for 90: " + bst.search(90)); // 应输出 false
//
//        // 测试删除功能
//        System.out.println("Delete 20: " + bst.delete(20)); // 应输出 true
//        System.out.println("Delete 30: " + bst.delete(30)); // 应输出 true
//        System.out.println("Delete 50: " + bst.delete(50)); // 应输出 true
//        System.out.println("Inorder traversal after deletions:");
//        bst.inorderTraversal(); // 应输出 40 60 70 80
    }
}
