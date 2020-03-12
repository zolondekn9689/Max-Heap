package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest
{
    Heap heap = new Heap();


    @org.junit.jupiter.api.Test
    void enqueue()
    {

        heap.enqueue(4);
        heap.enqueue(5);
        heap.enqueue(56);
        heap.enqueue(7);
        heap.enqueue(23);
        heap.enqueue(10);
        heap.enqueue(2);
        heap.enqueue(1);


        assertEquals(56, heap.list.get(0));
    }

    @org.junit.jupiter.api.Test
    void dequeue()
    {

        for (int i = 0; i < 10; i++)
        {
            heap.enqueue(10 - i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(10 - i, heap.dequeue());
        }

    }

    @org.junit.jupiter.api.Test
    void size()
    {
        addMockData();
        assertEquals(4, heap.size());
    }


    @org.junit.jupiter.api.Test
    void heapSort()
    {
        //Test 1
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(2);
        list1.add(9);
        list1.add(13);
        list1.add(19);
        list1.add(1);

        //Array list.
        ArrayList<Integer> mockList1 = copy(list1);

        heap.heapSort(list1);
        doesMatch(mockList1, list1);

        //Test 2:
        ArrayList<Integer> list2 = getRandomList(30);
        ArrayList<Integer> mockList2 = copy(list2);
        heap.heapSort(list2);
        doesMatch(mockList2, list2);

        //Test 3:
        ArrayList<Integer> list3 = getRandomList(50);
        ArrayList<Integer> mockList3 = copy(list3);
        heap.heapSort(list3);
        doesMatch(mockList3, list3);

        //Test 4:
        ArrayList<Integer> list4 = getRandomList(25);
        ArrayList<Integer> mockList4 = copy(list4);
        heap.heapSort(list4);
        doesMatch(mockList4, list4);

    }

    public void printList()
    {
        for (int i = 0; i < heap.list.size(); i++) {
            System.out.println("Element = " + heap.list.get(i));
        }
    }


    public void addMockData()
    {
        heap.enqueue(4);
        heap.enqueue(5);
        heap.enqueue(56);
        heap.enqueue(7);

    }


    public ArrayList<Integer> getRandomList(int size)
    {
        Random random = new Random();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++)
        {
            list.add(random.nextInt(100));
        }

        return list;
    }

    public ArrayList<Integer> copy(ArrayList<Integer> copyFrom)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < copyFrom.size(); i++)
        {
            list.add(copyFrom.get(i));
        }
        return list;
    }


    public void doesMatch(ArrayList<Integer> expected, ArrayList<Integer> actual)
    {
        Collections.sort(expected);
        if (expected.size() != actual.size())
        {
            assertEquals(true, false);
        }


        for (int i = 0; i < expected.size(); i++)
        {
            System.out.println("Actual = " + actual.get(i) + "\tExpected: " + expected.get(i));
            //assertEquals(expected.get(i), actual.get(i));
        }
        System.out.println("--------------------");
        System.out.println();
    }

}