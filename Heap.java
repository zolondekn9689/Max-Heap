package com.company;

import java.util.ArrayList;

/**
 * @Author Nick Zolondek
 */
public class Heap
{

    /**
     * Data will be stored in the arraylist.
     */
    public ArrayList<Integer> list;

    /**
     * Constructor to build the heap and the arraylist.
     */
    public Heap()
    {
        list = new ArrayList<>();
    }


    /**
     * Add an element onto the priority queue.
     * @param entry
     */
    public void enqueue(int entry)
    {
        //Index of the will-be inserted entry.
        int index = list.size();

        //Add entry to the list.
        list.add(entry);

        //Reheapify it.
        reheapifyUp(index);
    }


    /**
     * Remove an element from the list.
     * @return the highest element from the list.
     */
    public int dequeue()
    {
        //Conditional for if empty.
        if (list.size() < 1)
        {
            return -1;
        }
        else
        {
            //store highest number.
            int temp = list.get(0);
            //Swap the last element with the first.
            swap(0, list.size() - 1);

            //Remove the highest element.
            list.remove(list.size() - 1);
            reheapifyDown(0);
            return temp;
        }
    }

    /**
     * Get the size.
     * @return gets the number of elements from the tree.
     */
    public int size()
    {
        //Size of the
        return list.size();
    }


    /**
     * Currently works.
     * Reheapify Up.
     * @param currentSpot
     */
    private void reheapifyUp(int currentSpot)
    {
        // Get parent position.
        int parent = (currentSpot - 1)/2;

        // Get the root element from the arraylist.
        int root = list.get(0);

        // Re
        while ((list.get(currentSpot) != root) && (list.get(currentSpot) > list.get(parent))) {
            swap(currentSpot, parent);
            currentSpot = parent;
            parent = (currentSpot - 1)/2;
        }

    }

    /**
     * Precondition: currentSpot is the index in list ArrayList of element to reheapify
     * Postcondition: The heap properties are restored.
     * Reshapes the current spot and below.
     * @param currentSpot spot that you would want to readjust.
     */
    private void reheapifyDown(int currentSpot)
    {
        //get indexs of left and right child.
        int leftChild = currentSpot * 2 + 1;
        int rightChild = currentSpot * 2 + 2;

        // while not at a leaf node.
        while (leftChild < size())
        {
            //store the largest index.
            int largest;

            // Find the largest value from either left child or right child.
            if (rightChild < list.size() && list.get(leftChild) < list.get(rightChild))
                largest = rightChild;
            else
                largest = leftChild;
            if (list.get(currentSpot) >= list.get(largest))
                break;

            //Swap the current spot and largest child elements.
            swap(currentSpot, largest);

            //Reset current spot.
            currentSpot = largest;

            //Children indices.
            leftChild = currentSpot*2 + 1;
            rightChild = currentSpot*2 + 2;
        }

    }


    /**
     * Sort an arraylist data
     * @param data desired list to be sorted.
     */
    public void heapSort(ArrayList<Integer> data)
    {
        //save the heap as data.
        list = data;

        //convert list to a heap structure.
        for (int i = 0; i < size(); i++)
        {
            reheapifyUp(i);
        }

        //Set the number of unsorted elements in the list.
        int unsorted = size();

        //Sort each list individually.
        while (unsorted > 1)
        {
            int temp = list.get(0);
            list.set(0, list.get(unsorted - 1));
            data.set(unsorted - 1, temp);
            //swap(0, unsorted - 1);
            partialReheapifyDown(0, unsorted - 1);
            unsorted--;
        }
    }


    /**
     * ReheapifyDown with a stop feature.
     * @param currentSpot starts at current spot
     * @param stop reheaps down to stop posiion.
     */
    private void partialReheapifyDown(int currentSpot, int stop)
    {
        //get indexs of left and right child.
        int leftChild = currentSpot * 2 + 1;
        int rightChild = currentSpot * 2 + 2;

        // while not at a leaf node.
        while (leftChild < stop)
        {
            //store the largest index.
            int largest;

            // Find the largest value from either left child or right child.
            if (rightChild < stop && list.get(leftChild) < list.get(rightChild))
                largest = rightChild;
            else
                largest = leftChild;
            if (list.get(currentSpot) >= list.get(largest))
                break;

            //Swap the current spot and largest child elements.
            swap(currentSpot, largest);

            //Reset current spot.
            currentSpot = largest;

            //Children indices.
            leftChild = (currentSpot * 2) + 1;
            rightChild = (currentSpot * 2) + 2;
        }
    }

    /**
     * Simple method to swap between two positions in the heap.
     * @param pos1 position 1.
     * @param pos2 position 2.
     */
    private void swap(int pos1, int pos2)
    {
        int temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
}
