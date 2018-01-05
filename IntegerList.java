// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//          
// ****************************************************************

import java.util.Scanner;

public class IntegerList{

    int[] list; //values in the list
    int[] newList;
    Scanner scan = new Scanner(System.in);

    //-------------------------------------------------------
    //create a list of the given size
    //-------------------------------------------------------
    public IntegerList(int size)
    {
	list = new int[size];
    }


    //-------------------------------------------------------
    //fill array with integers between 1 and 100, inclusive
    //-------------------------------------------------------
    public void randomize()
    {
	for (int i=0; i<list.length; i++)
	    list[i] = (int)(Math.random() * 100) + 1;
    }

    //-------------------------------------------------------
    //print array elements with indices
    //-------------------------------------------------------
    public void print()
    {
	for (int i=0; i<list.length; i++) {
	    System.out.println(i + ":\t" + list[i]);
	   }
    }

    //-------------------------------------------------------
    //return the index of the first occurrence of target in the list.
    //return -1 if target does not appear in the list
    //-------------------------------------------------------
    public int search(int target)
    {
	int index = -1;
        for(int i=0; i<list.length; i++) {
	    if(list[i] == target && i != index) {
	        index = i;
	       }
	   }
        if(index == -1) {
            return -1;
        }
        else {
            return index;
        }
    }

    //-------------------------------------------------------
    //sort the list into ascending order using the selection sort algorithm
    //-------------------------------------------------------
    public void selectionSort()
    {
        int swapper = 0;
	for (int current = 0; current < list.length-1; current++) {
	    for(int comparer = current; comparer < list.length; comparer++) {
		    if(list[current] > list[comparer]) {
		        swapper = list[current];
		        list[current] = list[comparer];
		        list[comparer] = swapper;
		          }
		      }   
	    }
    }
    
    public void replaceFirst(int oldVal, int newVal) {
        if(search(oldVal) != -1) {
            list[search(oldVal)] = newVal;
        }
    }
    
    public void replaceAll(int oldVal, int newVal) {
        if(search(oldVal) != -1) {
            for(int i = 0; i<list.length-1; i++) {
                if(list[i] == oldVal) {
                    list[i] = newVal;
                }
            }
        }
    }
    
    public void increaseSize() {
        int[] newList = new int[list.length*2];
        for(int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public void addElement(int newVal) {
        if(search(0) == -1) {
                increaseSize();  
        }
        int loc = search(0);
        list[loc] = newVal;
    }
    
    public void removeFirst(int newVal) {
        list[search(newVal)] = 0;
    }
}
