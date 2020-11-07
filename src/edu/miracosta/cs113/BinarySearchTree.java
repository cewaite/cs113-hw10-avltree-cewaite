package edu.miracosta.cs113;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{
    
    protected boolean addReturn;
    protected E deleteReturn;

    public boolean add(E item)
    {
        root = add(root, item);
        return addReturn;
    }

    private Node<E> add(Node<E> localRoot, E item)
    {
        if (localRoot == null)
        {
            addReturn = true;
            return new Node<E>(item);
        }
        else if (item.compareTo(localRoot.data) == 0)
        {
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0)
        {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        }
        else
        {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    public E find(E target)
    {
        return find(root, target);
    }

    private E find(Node<E> localRoot, E target)
    {
        if (localRoot == null)
        {
            return null;
        }

        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
        {
            return localRoot.data;
        }
        else if (compResult < 0)
        {
            return find(localRoot.left, target);
        }
        else
        {
            return find(localRoot.right, target);
        }
    }

    public E delete(E target)
    {
        root = delete(root, target);
        return deleteReturn;
    }

    private Node<E> delete(Node<E> localRoot, E item)
    {
        if (localRoot == null)
        {
            deleteReturn = null;
            return null;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0)
        {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0)
        {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else
        {
            deleteReturn = localRoot.data;
            if (localRoot.left == null)
            {
                return localRoot.right;
            }
            else if (localRoot.right == null)
            {
                return localRoot.left;
            }
            else
            {
                if (localRoot.left.right == null)
                {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                }
                else
                {
                    localRoot.data = findLargestChild(localRoot.left);
                }
                return localRoot;
            }
        }
    }

    private E findLargestChild(Node<E> parent) {
        if (parent.right.right == null)
        {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else
        {
            return findLargestChild(parent.right);
        }
    }

    public boolean contains(E item)
    {
        if (find(item) == null)
        {
            return false;
        }

        return true;
    }

    public boolean remove(E item)
    {
        return remove(root, item);
    }

    private boolean remove(Node<E> localRoot, E item)
    {
        if (localRoot == null)
        {
            return false;
        }

        if (!contains(item))
        {
            return false;
        }

        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0)
        {
            localRoot.left = delete(localRoot.left, item);
            return true;
        }
        else if (compResult > 0)
        {
            localRoot.right = delete(localRoot.right, item);
            return true;
        }
        else
        {
            deleteReturn = localRoot.data;
            if (localRoot.left == null && localRoot.right == null)
            {
                if (localRoot.isLeft)
                {
                    localRoot.parent.left = null;
                }
                else
                {
                    localRoot.parent.right = null;
                }
            }
            else if (localRoot.left != null || localRoot.right != null)
            {
                if (localRoot.left != null)
                {
                    localRoot.parent.left = localRoot.left;
                }
                else
                {
                    localRoot.parent.right = localRoot.right;
                }
            }
            else
            {
                if (localRoot.left.right == null)
                {
                    localRoot.parent.left = localRoot.left;
                }
                else {
                    Node<E> rightMostChild = localRoot.right;
                    while (rightMostChild.right != null) {
                        rightMostChild = rightMostChild.right;
                    }
                    localRoot.data = rightMostChild.data;
                    rightMostChild.parent.right = rightMostChild.left;
                }
            }
        }

        return false;
    }

    public int depth(Node<E> localRoot)
    {
        if (localRoot == null)
        {
            return 0;
        }

        int leftDepth = depth(localRoot.left);
        int rightDepth = depth(localRoot.right);

        if (leftDepth > rightDepth)
        {
            return leftDepth + 1;
        }
        else
        {
            return rightDepth + 1;
        }
    }
}
