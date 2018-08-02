package com.example.day9.removeDuplicates;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {

  //remove unsorted
  public void removeDuplicates(String[] myArray) {
    List<String> list = new ArrayList<String>();
    for(String s: myArray) {
      list.add(s);
    }
    Set<String> set = new LinkedHashSet<String>(list);
    for(String str: set) {
      System.out.println(str);
    }
  }

  //remove sorted
  public int[] removeDuplicatesFromSortedArray(int[] intArray){
    int[] tempArray = new int[intArray.length];
    int j = 0;
    for (int i = 0; i < intArray.length - 1; i++) {
      if(intArray[i] != intArray[i+1]){
        tempArray[j] = intArray[i];
        j++;
      }
    }
    tempArray[j] = intArray[intArray.length - 1];
    return tempArray;
  }
}
