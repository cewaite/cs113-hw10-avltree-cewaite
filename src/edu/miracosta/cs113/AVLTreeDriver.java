package edu.miracosta.cs113;

import java.lang.Math;

public class AVLTreeDriver {
    public static void main(String[] args)
    {
        AVLTree<Integer> avlTree = new AVLTree<>();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        for (int i = 1; i <= 25; i++)
        {
            int num = (int) (Math.random() * 100);
            avlTree.add(num);
            binarySearchTree.add(num);
        }

//        avlTree.preOrderTraverse(avlTree.root, 0, new StringBuilder());
//        binarySearchTree.preOrderTraverse(binarySearchTree.root, 0, new StringBuilder());

//        avlTree.add(20);
//        binarySearchTree.add(20);
//        avlTree.add(10);
//        binarySearchTree.add(10);
//        avlTree.add(30);
//        binarySearchTree.add(30);


        System.out.println(avlTree.toString());
        System.out.println(binarySearchTree.toString());

        System.out.println(avlTree.depth(avlTree.root));
        System.out.println(binarySearchTree.depth(binarySearchTree.root));
    }
}
