package myExercise;

	import java.util.*;
	import java.io.IOException;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Scanner;

public class Kpurmuthtation 
{


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	    
	    public static int []  remove(int[] arr, int i)  	    
	    
	    //This will remove the index from Array we made and will retuen new array
	    {
	        int[] newArray = new int[arr.length - 1];
	        if (i > 0){
	            System.arraycopy(arr, 0, newArray, 0, i);
	        }

	        if (newArray.length > i){
	            System.arraycopy(arr, i + 1, newArray, i, newArray.length - i);
	        }
	        return newArray;
	        
	    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	    //Function for Lexigraphical Order
		   
	    public static int OrderofPermutation(int[] lex, int n){
	        ArrayList<int[]> myList = new ArrayList<int[]>();


	        int[] arrayMy = new int[n];
	        for (int i = 0; i < arrayMy.length; i++)
	        {    arrayMy[i] = i+1;}
	        myList.add(0,arrayMy); 
	        int var = 0;
	        int indexE=0;
	        int[] factorial = new int[n];

	        for(int i=n-1; i>=1; i--)
	        {
	            var = lex[n - i - 1];
	            for (int index = 0; index <= i; index++)
	            {
	                if (var == myList.get(n - i - 1)[index])
	                {
	                    indexE = index;
	                    break;
	                }
	            }
	            factorial[n - i - 1] = indexE;
	            int[] result = new int[i + 1];
	            result = myList.get(n - i - 1); 
	            myList.add(n - i, remove(result, indexE));
	        }
	        factorial[n-1] = 0;


	        int sagment=0;
	        for (int i=n-1; i>=0; i--)
	        {
	        	sagment = sagment + factorial[n-i-1]*PrbOneCryptoG.permutation(i);
	        }
	        return sagment;
	    }

	    //This function will find the permutation of K-Th Number of it Data
	    public static int[] kthPermutation(int k, int n)   
	    {
	        ArrayList<int[]> myListPer = new ArrayList<int[]>();

	        int[] myIntArray = new int[n];
	        int[] array = new int[n];

	        int permutation,multipyIndex,removeIndex=0;
	        
	        for (int i = 0; i < array.length; i++)
	        {    array[i] = i+1;}
	        myListPer.add(0,array); 
	        

	        for(int i=n-1; i>=1; i--)
	        {
	        	permutation = PrbOneCryptoG.permutation(i);
	            multipyIndex=1*permutation;
	            for(int q=1;;q++)
	            {
	                multipyIndex = q*permutation;
	                if(k>multipyIndex)
	                {
	                    removeIndex = q;
	                }
	                else if(k<multipyIndex)
	                {
	                    removeIndex = q-1;
	                    multipyIndex=(q-1)*permutation;
	                    k = k - multipyIndex;
	                    break;
	                }
	                else
	                {
	                    removeIndex = q-1;
	                    multipyIndex=removeIndex * permutation;
	                    k = k - multipyIndex;
	                    break;
	                }
	            }

	            int[] result = new int[i+1];
	            result = myListPer.get(n-i-1); 
	            myIntArray[n-i-1]=result[removeIndex];
	            myListPer.add(n-i,myExercise.Kpurmuthtation.remove(result,removeIndex));

	        }
	        myIntArray[n-1]=myListPer.get(n-1)[0];
	        return myIntArray; 
	    }

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

