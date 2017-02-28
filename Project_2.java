
/*
 * Dale Salcedo
 * CS 331 - Analysis of Algorithms
 * Project 2
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Project_2 {
    static int totalnum=0;

    public static void main(String[] args) {

        int size = 10;//, _k=0;
        int k=1, k2=size/4, k3=size/2, k4=(3*size)/4, k5=size;
        long startTime =0, endTime=0, time=0;
        long s1time_1=0, s2time_1=0, s3time_1=0, s4time_1=0, s1time_2=0, s2time_2=0, s3time_2=0, s4time_2=0;
        long s1time_3=0, s2time_3=0, s3time_3=0, s4time_3=0, s1time_4=0, s2time_4=0, s3time_4=0, s4time_4=0;
        long s1time_5=0, s2time_5=0, s3time_5=0, s4time_5=0, cntr=100;
 
        Random random1 = new Random();
        int array[] = new int[size];
        int arr[] = new int[size];
        int sortArray[] = new int[size];
        ArrayList<Integer> arrayList = new ArrayList<Integer>(size);

        for(int a=0; a < array.length; a++) {
            array[a] = random1.nextInt(9999);
            arr[a] = array[a];
            arrayList.add(array[a]);
            sortArray[a] = array[a];
        }
        Arrays.sort(sortArray);

        System.out.println("Algorithm 1: ");
       
            startTime = System.nanoTime();
            sAlgorithm1(arr, 0, arr.length-1, k-1);
            endTime = System.nanoTime();
            s1time_1 = (endTime - startTime);
            System.out.println(s1time_1);

            startTime = System.nanoTime();
            sAlgorithm1(arr, 0, arr.length-1, k2-1);
            endTime = System.nanoTime();
            s1time_2 = (endTime - startTime);
            System.out.println(s1time_2);
            
            startTime = System.nanoTime();
            sAlgorithm1(arr, 0, arr.length-1, k3-1);
            endTime = System.nanoTime();
            s1time_3 = (endTime - startTime);
            System.out.println(s1time_3);
            
            startTime = System.nanoTime();
            sAlgorithm1(arr, 0, arr.length-1, k4-1);
            endTime = System.nanoTime();
            s1time_4 = (endTime - startTime);
            System.out.println(s1time_4);

            startTime = System.nanoTime();
            sAlgorithm1(arr, 0, arr.length-1, k5-1);
            endTime = System.nanoTime();
            s1time_5 = (endTime - startTime);
            System.out.println(s1time_5);
            //``````````````````````````````````````````````````````````````````````````````````
        
            

        System.out.println("\nSELECT 2: ");
        copyArr(array, arr);
        for(int i=0; i<cntr; i++) {
            startTime = System.nanoTime();
            algorithm2(arr, 0, arr.length-1, k);
            endTime = System.nanoTime();
            s2time_1 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm2(arr, 0, arr.length-1, k2);
            endTime = System.nanoTime();
            s2time_2 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm2(arr, 0, arr.length-1, k3);
            endTime = System.nanoTime();
            s2time_3 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm2(arr, 0, arr.length-1, k4);
            endTime = System.nanoTime();
            s2time_4 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm2(arr, 0, arr.length-1, k5);
            endTime = System.nanoTime();
            s2time_5 += (endTime - startTime);
            copyArr(array, arr);
        }
        s2time_1 /= 100; s2time_2 /= 100; s2time_3 /= 100;
        s2time_4 /= 100; s2time_5 /= 100;

        copyArr(array, arr);
        System.out.println("k=1: " + algorithm2(arr, 0, arr.length-1, k));
        copyArr(array, arr);
        System.out.println("k=n/4: " + algorithm2(arr, 0, arr.length-1, k2));
        copyArr(array, arr);
        System.out.println("k=n/2: " + algorithm2(arr, 0, arr.length-1, k3));
        copyArr(array, arr);
        System.out.println("k=3n/4: " + algorithm2(arr, 0, arr.length-1, k4));
        copyArr(array, arr);
        System.out.println("k=n: " + algorithm2(arr, 0, arr.length-1, k5));


        System.out.println("\nSELECT 3: ");
        copyArr(array, arr);
        for(int i=0; i<cntr; i++) {
            startTime = System.nanoTime();
            algorithm3(arr, 0, arr.length-1, k);
            endTime = System.nanoTime();
            s3time_1 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm3(arr, 0, arr.length-1, k2);
            endTime = System.nanoTime();
            s3time_2 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm3(arr, 0, arr.length-1, k3);
            endTime = System.nanoTime();
            s3time_3 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm3(arr, 0, arr.length-1, k4);
            endTime = System.nanoTime();
            s3time_4 += (endTime - startTime);
            copyArr(array, arr);

            startTime = System.nanoTime();
            algorithm3(arr, 0, arr.length-1, k5);
            endTime = System.nanoTime();
            s3time_5 += (endTime - startTime);
            copyArr(array, arr);
        }
        s3time_1 /= 100; s3time_2 /= 100; s3time_3 /= 100;
        s3time_4 /= 100; s3time_5 /= 100;

        copyArr(array, arr);
        System.out.println("k=1: " + algorithm3(arr, 0, arr.length-1, k));
        copyArr(array, arr);
        System.out.println("k=n/4: " + algorithm3(arr, 0, arr.length-1, k2));
        copyArr(array, arr);
        System.out.println("k=n/2: " + algorithm3(arr, 0, arr.length-1, k3));
        copyArr(array, arr);
        System.out.println("k=3n/4: " + algorithm3(arr, 0, arr.length-1, k4));
        copyArr(array, arr);
        System.out.println("k=n: " + algorithm3(arr, 0, arr.length-1, k5));


        System.out.println("\nSELECT 4: ");
        copyArr(array, arrayList);
        for(int i=0; i<cntr; i++) {
            startTime = System.nanoTime();
            algorithm4(arrayList, k-1);
            endTime = System.nanoTime();
            s4time_1 += (endTime - startTime);
            copyArr(array, arrayList);

            startTime = System.nanoTime();
            algorithm4(arrayList, k2-1);
            endTime = System.nanoTime();
            s4time_2 += (endTime - startTime);
            copyArr(array, arrayList);

            startTime = System.nanoTime();
            algorithm4(arrayList, k3-1);
            endTime = System.nanoTime();
            s4time_3 += (endTime - startTime);
            copyArr(array, arrayList);

            startTime = System.nanoTime();
            algorithm4(arrayList, k4-1);
            endTime = System.nanoTime();
            s4time_4 += (endTime - startTime);
            copyArr(array, arrayList);

            startTime = System.nanoTime();
            algorithm4(arrayList, k5-1);
            endTime = System.nanoTime();
            s4time_5 += (endTime - startTime);
            copyArr(array, arrayList);
        }
        s4time_1 /= 100; s4time_2 /= 100; s4time_3 /= 100;
        s4time_4 /= 100; s4time_5 /= 100;

        copyArr(array, arrayList);
        System.out.println("k=1: " + algorithm4(arrayList, k-1));
        copyArr(array, arrayList);
        System.out.println("k=n/4: " + algorithm4(arrayList, k2-1));
        copyArr(array, arrayList);
        System.out.println("k=n/2: " + algorithm4(arrayList, k3-1));
        copyArr(array, arrayList);
        System.out.println("k=3n/4: " + algorithm4(arrayList, k4-1));
        copyArr(array, arrayList);
        System.out.println("k=n: " + algorithm4(arrayList, k5-1));

        /*System.out.println("\n\nSELECT 2 TIMES:");
        System.out.println("k=1: " + s2time_1);
        System.out.println("k=n/4: " + s2time_2);
        System.out.println("k=n/2: " + s2time_3);
        System.out.println("k=3n/4: " + s2time_4);
        System.out.println("k=n: " + s2time_5);*/

        System.out.println("\n\nSELECT 1 TIMES:");
        System.out.println(s1time_1);
        System.out.println(s1time_2);
        System.out.println(s1time_3);
        System.out.println(s1time_4);
        System.out.println(s1time_5);

        System.out.println("\n\nSELECT 2 TIMES:");
        System.out.println(s2time_1);
        System.out.println(s2time_2);
        System.out.println(s2time_3);
        System.out.println(s2time_4);
        System.out.println(s2time_5);

        System.out.println("\n\nSELECT 3 TIMES:");
        System.out.println(s3time_1);
        System.out.println(s3time_2);
        System.out.println(s3time_3);
        System.out.println(s3time_4);
        System.out.println(s3time_5);

        System.out.println("\n\nSELECT 4 TIMES:");
        System.out.println(s4time_1);
        System.out.println(s4time_2);
        System.out.println(s4time_3);
        System.out.println(s4time_4);
        System.out.println(s4time_5);

    }//end main

    static void copyArr(int copyFrom[], int copyTo[])
    {
        for(int i=0; i<copyFrom.length; i++)
            copyTo[i] = copyFrom[i];
    }

    static void copyArr(int copyFrom[], ArrayList<Integer> copyTo)
    {
        copyTo.clear();
        for(int i=0; i<copyFrom.length; i++)
            copyTo.add(copyFrom[i]);
    }

    static void print(int arr[])//`````````````````````````````````````
    {
        for(int a=0; a<arr.length; a++)
            System.out.print(arr[a] + " ");
        System.out.println("\n");
    }

   

    static int sAlgorithm1(int arr[], int left, int right, int k) {
        int index = partition(arr, left, right, (left+right)/2);
        if (left < index - 1)
            sAlgorithm1(arr, left, index - 1, k);
        if (index < right)
            sAlgorithm1(arr, index, right, k);
        return arr[k];
    }//end select1

    static int partition(int arr[], int left, int right, int pivotpoint)
    {
        int l = left, r = right;
        int tmp;
        int pivot = arr[pivotpoint];

        while (l <= r) {
            while (arr[l] < pivot)
                l++;
            while (arr[r] > pivot)
                r--;
            if (l <= r) {
                  tmp = arr[l];
                  arr[l] = arr[r];
                  arr[r] = tmp;
                  l++;
                  r--;
            }
      }
        return l;
    }//end partition

    private static int algorithm2(int[] arr, int left, int right, int k)
    {
        int temp;
        k = k-1;
        while(true) {
            if(right <= left+1) {
                if((right == left+1) && (arr[right] < arr[left])) {
                    temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }

                return arr[k];

            }else {
                int middle = (left+right)/2;
                temp = arr[middle];
                arr[middle] = arr[left+1];
                arr[left+1] = temp;


                if(arr[left] > arr[right]) {
                    temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }

                if(arr[left+1] > arr[right]) {
                    temp = arr[left+1];
                    arr[left+1] = arr[right];
                    arr[right] = temp;
                }

                if(arr[left] > arr[left+1]) {
                    temp = arr[left];
                    arr[left] = arr[left+1];
                    arr[left+1] = temp;
                }

                int i = left+1;
                int j = right;
                int pivot = arr[left + 1];

                while(true) {
                    do{
                        i++;
                    }while (arr[i] < pivot);

                    do{
                        j--;
                    }while(arr[j] > pivot);

                    if(j < i)
                        break;

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }//end while

                arr[left+1] = arr[j];
                arr[j] = pivot;

                if(j >= k)
                    right = j - 1;

                if( j <= k )
                    left = i;
            }//end else
        }//end while
    }//end select2

    static int algorithm3(int arr[], int left, int right, int k)
    {
        if(left==right)
            return arr[left];

        int pivot_loc = (left+right)/2;
        int pivotNewIndex = partition3(arr, left, right, pivot_loc);
        int pivotDist = pivotNewIndex - left + 1;

        if(pivotDist == k)
            return arr[pivotNewIndex];
        else if(k < pivotDist)
            return algorithm3(arr, left, pivotNewIndex - 1, k);
        else
            return algorithm3(arr, pivotNewIndex + 1, right, k-pivotDist);
    }//end select3

    static int partition3(int arr[], int left, int right, int pivot_loc)
    {
        int pivot_val = arr[pivot_loc];
        int temp = arr[pivot_loc];

        arr[pivot_loc] = arr[right];
        arr[right] = temp;
        int temp2 = left;

        for(int i=left; i<=right; i++){
            if(arr[i] < pivot_val) {
                temp = arr[temp2];
                arr[temp2] = arr[i];
                arr[i] = temp;
                temp2++;
            }
        }//end for

        temp = arr[right];
        arr[right] = arr[temp2];
        arr[temp2] = temp;

        return temp2;
    }//end partition3

    public static int algorithm4(ArrayList<Integer> _arr, int k)
    {
        totalnum++;
        ArrayList<Integer> arr = new ArrayList<Integer>(_arr);

        if (arr.size() <= 10) {
            Collections.sort(arr);
            return arr.get(k).intValue();
        }

        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        for(int i=0; i < arr.size(); i+=5) {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            for(int q=i; q < i+5 && q < arr.size(); q++) {
                temp.add(arr.get(q));
            }

            if(i+5 < arr.size())
                arr2.add(new Integer(algorithm4(temp,3)));
            else
                arr2.add(new Integer(algorithm4(temp,(arr.size() - i)/2)));
        }//end for

        int middle = algorithm4(arr2, arr2.size()/2);

        ArrayList<Integer> arr_lower = new ArrayList<Integer>();
        ArrayList<Integer> arr_higher = new ArrayList<Integer>();
        ArrayList<Integer> arr_exact = new ArrayList<Integer>();

        for(int i=0; i < arr.size(); i++) {
            if(arr.get(i) < middle)
                arr_lower.add(arr.get(i));
            else if( arr.get(i) > middle )
                arr_higher.add(arr.get(i));
            else
                arr_exact.add(arr.get(i));
        }//end for

        if (k < arr_lower.size()) {
            return algorithm4(arr_lower, k);
        }
        else if (k > arr_lower.size() + arr_exact.size()) {
            return algorithm4(arr_higher, k - arr_lower.size() - arr_exact.size());
        }
        else
            return arr_exact.get(0);
    }//end select4
}//end class























