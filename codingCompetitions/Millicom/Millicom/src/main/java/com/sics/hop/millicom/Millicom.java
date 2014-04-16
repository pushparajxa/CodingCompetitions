package com.sics.hop.millicom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Millicom 
{
    private int rows,columns;
    private int[] rowSum;
    private int[] columnSum;

    public int[] getColumnSum() {
        return columnSum;
    }

    public void setColumnSum(int[] columnSum) {
        this.columnSum = columnSum;
    }
            
    public int[] getRowSum() {
        return rowSum;
    }

    public void setRowSum(int[] rowSum) {
        this.rowSum = rowSum;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    public static void main( String[] args )
    {
        Scanner s = null;
        Millicom mc = new Millicom();

        try {
            s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

               /*
            read number of rows and columns
            */ 
               mc.setRows(s.nextInt());
               mc.setColumns(s.nextInt());
               /*
               Read row sum
               */
               int i,j= mc.getRows();
               int[] temp= new int[j];
               for(i=0;i<j;i++){
                   temp[i] = s.nextInt();
               }
               mc.setRowSum(temp);
               
               /*
               read column sum
               */
               j=mc.getColumns();
               temp = new int[j];
               for(i=0;i<mc.getColumns();i++){
                   temp[i]=s.nextInt();
               }
               mc.setColumnSum(temp);
               
               mc.check();
            
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
    public static void test(){
        Millicom mc = new Millicom();
        int k= mc.rows;
    }

    private void check() {
        
        int[] sBar = new int[columns];
        
        int i=0,j;
        
        for(i=0;i<columns;i++){
            sBar[i]=0;
        }
        
        for(i=0;i<rows;i++){
            for(j=0;j<rowSum[i];j++){
                sBar[j]++;
            }
        }
        
        Arrays.sort(columnSum);//Sorts in asceding order
        reverse(columnSum);//Reverse to get in descending order;
        
      if(sBar[0]<columnSum[0]){
                System.out.println("No");
            }
        
        for(i=1;i<columns-1;i++){
            columnSum[i] = columnSum[i]+columnSum[i-1];
            sBar[i]=sBar[i]+sBar[i-1];
            if(sBar[i]<columnSum[i]){
                System.out.println("No");
            }
        }
         columnSum[columns-1] = columnSum[columns-1]+columnSum[columns-2];
            sBar[columns-1]=sBar[columns-1]+sBar[columns-2];
            
            if(sBar[columns-1]!=columnSum[columns-1]){
                System.out.println("No");
            }
        
        System.out.println("Yes");
        
        
    }
    
    
    private void reverse(int b[]){
        int left,right;
        for ( left=0, right=b.length-1; left<right; left++, right--) {
    // exchange the first and last
    int temp = b[left]; b[left]  = b[right]; b[right] = temp;
}
    }
}

