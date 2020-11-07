package edu.miracosta.cs113;

public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {

    protected Node<E> rotateRight(Node<E> root)
    {
        Node<E> p = root.parent;
        Node<E> b = root.left;
        root.left = b.right;
        if (b.right != null)
        {
            b.right.parent = root;
        }
        b.right = root;
        root.parent = b;
        b.parent = p;
        if (p != null)
        {
            if (p.left == root)
            {
                p.left = b;
            }
            else
            {
                p.right = b;
            }
        }
        return b;

//        Node<E> temp = root.left;
//        root.left = temp.right;
//        temp.right = root;
//        return temp;
    }

    protected Node<E> rotateLeft(Node<E> root)
    {
        Node<E> p = root.parent;
        Node<E> b = root.right;
        root.right = b.left;
        if (b.left != null)
        {
            b.left.parent = root;
        }
        b.left = root;
        root.parent = b;
        b.parent = p;
        if (p != null)
        {
            if (p.right == root)
            {
                p.right = b;
            }
            else
            {
                p.left = b;
            }
        }
        return b;

//        Node<E> temp = root.right;
//        root.right = temp.left;
//        temp.left = root;
//        return temp;
    }
}
