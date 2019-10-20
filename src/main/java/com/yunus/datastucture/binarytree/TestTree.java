package com.yunus.datastucture.binarytree;


/**
 * @author gaoyunfeng
 */
public class TestTree {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        BinaryTree tree = new BinaryTree();
        tree.insert(80, 34);
        tree.insert(49, 23);
        // 查找测试
        //System.out.println(tree.find(56).getOtherData());
        // 修改测试
        //tree.update(1,5555);
        //System.out.println(tree.find(1).getOtherData());
        tree.insert(90, 35);
        tree.insert(45, 345);
        tree.insert(30, 315);
        tree.insert(45, 389);
        tree.insert(82, 315);
        tree.insert(150, 389);
        tree.preOrder(tree.getRoot());
    }
}
