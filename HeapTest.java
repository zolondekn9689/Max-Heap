package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest
{
    private Heap heap = new Heap();


    @org.junit.jupiter.api.Test
    void enqueue()
    {

        int testCases = 40000000;
        Random random = new Random();
        for (int test = 0 ; test < testCases; test++)
        {
            int length = random.nextInt(3040);
            for (int i = 0; i < length; i++)
            {
                heap.enqueue(i);

            }



            for (int i = 0; i < heap.list.size(); i++)
            {

                //System.out.println("Parent = " + heap.list.get(i));
                for (int j = 2 * i + 1; j < (2*i + 3); j++)
                {
                    if (j >= heap.size()) {
                        return;
                    }
                    //Check to see if it satisfies property 1.
                    assertEquals(true, heap.list.get(i) > heap.list.get(j));

                }
            }
        }



    }

    @org.junit.jupiter.api.Test
    void testEnqueue2()
    {
        heap.enqueue(4);
        assertEquals(4, heap.list.get(0));


        heap.enqueue(5);
        assertEquals(5, heap.list.get(0));
        assertEquals(4, heap.list.get(1));

        heap.enqueue(6);
        assertEquals(6, heap.list.get(0));
        assertEquals(5, heap.list.get(2));
        assertEquals(4, heap.list.get(1));

        heap.enqueue(7);
        assertEquals(7, heap.list.get(0));
        assertEquals(6, heap.list.get(1));
        assertEquals(5, heap.list.get(2));
        assertEquals(4, heap.list.get(3));

        heap.enqueue(3);
        assertEquals(7, heap.list.get(0));
        assertEquals(6, heap.list.get(1));
        assertEquals(5, heap.list.get(2));
        assertEquals(4, heap.list.get(3));
        assertEquals(3, heap.list.get(4));
    }


    @org.junit.jupiter.api.Test
    void dequeue()
    {
        int numTestCases = 3000;

        Random random = new Random();

        for (int test = 0; test < numTestCases; test++)
        {

            int size = random.nextInt(3000);
            for (int i = 0; i < size; i++)
            {
                heap.enqueue(size - i);
            }

            for (int i = 0; i < size; i++) {
                assertEquals(size - i, heap.dequeue());
            }

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
        for (int i = 0; i < list1.size(); i++)
        {
            System.out.println(list1.get(i));
        }
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

        //Tests 5-34.
        int testCases = 300;
        Random random = new Random();
        for (int i = 0; i < testCases; i++)
        {
            ArrayList<Integer> list5 = getRandomList(testCases*random.nextInt(40));
            ArrayList<Integer> mockList5 = copy(list5);
            heap.heapSort(list5);
            doesMatch(mockList5, list5);
        }

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
            assertEquals(expected.get(i), actual.get(i));
        }
        System.out.println("--------------------");
        System.out.println();
    }

    public boolean isLeaf(int position)
    {
        System.out.println(Math.floor(Math.log(heap.size())/Math.log(2) + 1));
        return true;
    }




}