package com.example.javafxproject;

import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HighArray
{
    private Rectangle[] a;                 // ref to array a
    public int nElems;                      // number of data items
    private int Capacity=5;


    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        Capacity = max;
        a = new Rectangle[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    public HighArray(){
        a = new Rectangle[Capacity];
        nElems = 0;
    }
    //-----------------------------------------------------------

    public void IncreaseSize(){
        Capacity*=2;
        Rectangle[] temparr = new Rectangle[Capacity];
        for (int i = 0;i<nElems;i++) {
            temparr[i] = a[i];
        }
        a=temparr;
    }
    public void insert(Rectangle value)    // put element into array
    {
        if(nElems >= Capacity){
            IncreaseSize();
        }
        a[nElems] = value;             // insert it
        nElems++;                  // increment size
    }
    //-----------------------------------------------------------
    public void clear(){
        nElems = 0;
    }
    //-----------------------------------------------------------

    public Rectangle getR(int i) {
        return a[i];
    }
    //-----------------------------------------------------------

    public Rectangle[] getA() {
        return a;
    }
}  // end class HighArray