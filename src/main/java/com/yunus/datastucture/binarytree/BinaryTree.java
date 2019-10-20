package com.yunus.datastucture.binarytree;

/**
 * 二叉树
 *
 * @author gaoyunfeng
 */
public class BinaryTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 插入方法
     * 1.如果不存在直接插入根节点
     * 2.从根开始查找一个相应的插入节点即新节点的父节点，当父节点找到后根据新节点的值来判断是插入左节点还是右节点
     * 一般小的放到左边大的放到右边
     */
    public void insert(int keyData, int otherData) {
        Node newNode = new Node(keyData, otherData);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                // 记录上积极节点
                parent = current;
                if (keyData < current.getKeyData()) {
                    current = current.getLeftNode();
                    if (current == null) {
                        // 增加节点
                        parent.setLeftNode(newNode);
                        break;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        // 增加节点
                        parent.setRightNode(newNode);
                        break;
                    }
                }
            }
        }
    }

    /**
     * 查找方法
     * 从根节点开始查找如果查找节点值比父节点值小，则查找左子树，否则查找右子树，直到查找到为止
     *
     * @param keyData
     * @return
     */
    public Node find(int keyData) {
        Node current = root;
        while (current.getKeyData() != keyData) {
            if (keyData < current.getKeyData()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            // 找不到时
            if (current == null) {
                break;
            }
        }
        return current;
    }

    /**
     * 遍历二叉树
     * 先序遍历二叉树（访问节点--》遍历节点左节点树--》遍历节点右节点树）
     */
    public void preOrder(Node root) {
        if (root != null) {
            root.display();
            preOrder(root.leftNode);
            preOrder(root.rightNode);
        }
    }

    public Node getRoot() {
        return root;
    }

    /**
     * 删除方法
     *
     * @param keyData
     */
    public void delete(int keyData) {

    }

    /**
     * 修改方法
     * 1.找到节点
     * 2.修改值
     *
     * @param keyData
     */
    public void update(int keyData, int newOtherData) {
        Node node = find(keyData);
        node.setOtherData(newOtherData);
    }

    /**
     * 内部类节点
     */
    static class Node {
        // 关键字
        private int keyData;
        // 其他数据
        private int otherData;
        // 左子节点
        private Node leftNode;
        // 右子节点
        private Node rightNode;

        public Node(int keyData, int otherData) {
            this.keyData = keyData;
            this.otherData = otherData;
        }

        public int getKeyData() {
            return keyData;
        }

        public void setKeyData(int keyData) {
            this.keyData = keyData;
        }

        public int getOtherData() {
            return otherData;
        }

        public void setOtherData(int otherData) {
            this.otherData = otherData;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public void display() {
            System.out.println(keyData + " ," + otherData);
        }
    }
}
