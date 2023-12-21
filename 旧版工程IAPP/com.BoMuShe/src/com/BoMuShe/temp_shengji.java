package com.BoMuShe;

import java.lang.*;
import com.BoMuShe.R;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class temp_shengji {
  public static void temps(){
    String fileName = "/storage/emulated/0/Bomm/temp.txt";
    ArrayList<String> nameArray = new ArrayList<String>();
    ArrayList<String> sxArray = new ArrayList<String>();
    ArrayList<String> mapArray = new ArrayList<String>();
    ArrayList<Integer> levelArray = new ArrayList<Integer>();
    ArrayList<Integer> expArray = new ArrayList<Integer>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      
      StringBuilder fileContentBuilder = new StringBuilder();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        fileContentBuilder.append(line);
      }
      scanner.close();
      
      String fileContent = fileContentBuilder.toString();
      
      // System.out.println(fileContent);
      
      String[] lines = fileContent.split("¥");
      // System.out.println(lines.length);
      for (String line : lines) {
        // System.out.println(line);
        String[] parts = line.split(";");
        // for (String part : parts)
        //     System.out.println(part);
        nameArray.add(parts[0]);
        sxArray.add(parts[1]);
        mapArray.add(parts[2]);
        levelArray.add(Integer.parseInt(parts[3]));
        expArray.add(Integer.parseInt(parts[4]));
      }
      
      quicksortParallelArrays(expArray, nameArray, sxArray, mapArray, levelArray, 0, expArray.size() - 1);
      writeArraysToFile("/storage/emulated/0/Bomm/tempSorted.txt", nameArray, sxArray, mapArray, levelArray, expArray);
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  /*
  public String getPath(Context context) {
    File dir = null;
    boolean state = Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED );
    if (state) {
      if (Build.VERSION.SDK_INT >= 29) {
        //Android10之后
        dir = context.getExternalFilesDir( null );
      } else {
        dir = Environment.getExternalStorageDirectory();
      }
    } else {
      dir = Environment.getRootDirectory();
    }
    return dir.toString();
  }
  */
  
  public static void quicksortParallelArrays(List<Integer> expArray, List<String> nameArray, List<String> sxArray,
  List<String> mapArray, List<Integer> levelArray, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(expArray, nameArray, sxArray, mapArray, levelArray, low, high);
      quicksortParallelArrays(expArray, nameArray, sxArray, mapArray, levelArray, low, pivotIndex - 1);
      quicksortParallelArrays(expArray, nameArray, sxArray, mapArray, levelArray, pivotIndex + 1, high);
    }
  }
  
  public static int partition(List<Integer> expArray, List<String> nameArray, List<String> sxArray,
  List<String> mapArray, List<Integer> levelArray, int low, int high) {
    int pivot = expArray.get(high);
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (expArray.get(j) >= pivot) {
        i++;
        swap(expArray, i, j);
        swap(nameArray, i, j);
        swap(sxArray, i, j);
        swap(mapArray, i, j);
        swap(levelArray, i, j);
      }
    }
    swap(expArray, i + 1, high);
    swap(nameArray, i + 1, high);
    swap(sxArray, i + 1, high);
    swap(mapArray, i + 1, high);
    swap(levelArray, i + 1, high);
    
    return i + 1;
  }
  
  public static <T> void swap(List<T> list, int i, int j) {
    T temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }
  
  public static void writeArraysToFile(String fileName, List<String> nameArray, List<String> sxArray,
  List<String> mapArray, List<Integer> levelArray, List<Integer> expArray) {
    try (FileWriter writer = new FileWriter(fileName)) {
      for (int i = 0; i < nameArray.size(); i++) {
        String line = nameArray.get(i) + ";" + sxArray.get(i) + ";" + mapArray.get(i) + ";" + levelArray.get(i) + ";" + expArray.get(i) + "¥";
        writer.write(line);
        writer.write(System.lineSeparator());
      }
      System.out.println("Sorted arrays have been written to the file: " + fileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}