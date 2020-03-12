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
    public Heap() {
        list = new ArrayList<>();
    }


    /**
     * Add an element onto the priority queue.
     * @param entry
     */
    public void enqueue(int entry)
    {
        int index = list.size();
        list.add(entry);
        reheapifyUp(index);
    }


    /**
     *
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
        int parent = (currentSpot - 1)/2;

        int root = list.get(0);

        while ((list.get(currentSpot) != root) && (list.get(currentSpot) > list.get(parent))) {
            swap(currentSpot, parent);
            currentSpot = parent;
            parent = (currentSpot - 1)/2;
        }

    }

    private void reheapifyDown(int currentSpot)
    {
        int leftChild = currentSpot * 2 + 1;
        int rightChild = currentSpot * 2 + 2;

        while (leftChild < list.size())
        {
            int largest;

            if (rightChild < list.size() && list.get(leftChild) < list.get(rightChild))
                largest = rightChild;
            else
                largest = leftChild;
            if (list.get(currentSpot) >= list.get(largest))
                break;

            int temp = list.get(currentSpot);
            list.set(currentSpot,list.get(largest));
            list.set(largest, temp);


            currentSpot = largest;
            leftChild = currentSpot*2 + 1;
            rightChild = currentSpot*2 + 2;
        }

    }


    public void heapSort(ArrayList<Integer> data)
    {
        list = data;
        for (int i = 0; i < list.size(); i++)
        {
            reheapifyUp(i);
        }

        int unsorted = list.size();

        while (unsorted > 1)
        {
            swap(0, unsorted - 1);
            partialReheapifyDown(0, unsorted - 1);
            unsorted--;
        }
    }



    private void partialReheapifyDown(int currentSpot, int stop)
    {
        int leftChild = currentSpot * 2 + 1;
        int rightChild = currentSpot * 2 + 2;


        while (leftChild < stop)
        {
            int largest;
            if (rightChild < stop && list.get(leftChild) < list.get(rightChild))
                largest = rightChild;
            else
                largest = leftChild;
            if (list.get(currentSpot) >= list.get(largest))
                break;

            int temp = list.get(currentSpot);
            list.set(currentSpot,list.get(largest));
            list.set(largest, temp);

            currentSpot = largest;
            leftChild = currentSpot*2 + 1;
            rightChild = currentSpot*2 + 2;
        }
    }


    private void swap(int pos1, int pos2)
    {
        int temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
}
