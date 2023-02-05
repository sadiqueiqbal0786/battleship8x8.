package com.epam.rd.autotasks;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;
    public Battleship8x8(final long ships) {
        this.ships = ships;
    }
    public boolean shoot(String shot) {
        boolean aimed = false;
        String s=Long.toBinaryString(this.ships);
        if(s.length()==63)
        {
            s=String.valueOf(new StringBuffer(s).insert(0,"0"));
        }

        String []shootMap=s.split("");
        String []cr=shot.split("");
        List<String>ab=List.of("A","B","C","D","E","F","G","H");
        int shotIndex=ab.indexOf(cr[0]);
        int index=8*(Integer.parseInt(cr[1])-1)+shotIndex;
        this.shots|=1L<<63-index;

        return Objects.equals(shootMap[index],"1");
    }
    public String state () {
        String b=Long.toBinaryString(this.ships);
        if(ships>0)
        {
            b="0"+b;
        }
        String s1=Long.toBinaryString(shots);
        System.out.println(s1.length());
        if(s1.length()<64)
        {
            int c=64-s1.length();
            for(int i=0;i<c;i++)
            {
                s1="0"+s1;
            }
        }

        System.out.println(s1.length());
        char []arr1=b.toCharArray();
        char []arr=s1.toCharArray();
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]=='1'&&arr[i]=='1')
            {
                arr[i]='☒';
            }else if (arr1[i]=='0'&&arr[i]=='1')
            {
                arr[i]='×';
            }else if(arr1[i]=='1'&&arr[i]=='0')
            {
                arr[i]='☐';
            }else if(arr1[i]=='0'&&arr[i]=='0')
                arr[i]='.';
        }

        String s="";
        for(int i=0;i<arr.length;i++)
        {
            s=s+arr[i];
        }
        String []t=new String[8];
        for(int i=0;i<s.length()/8;i++)
        {
            t[i]=s.substring(i*8,i*8+8);
        }
        String m="";
        for(int i=0;i<t.length;i++)
        {
            m=m+t[i]+"\n";
        }
        System.out.println(m);
        return m;
    }
}
/*
* This is a Java class named Battleship8x8 that represents the game of battleship.
* In the game, you have an 8x8 grid with a number of ships placed in it,
*  and you take shots at the grid in an attempt to sink all of the ships.

The class has two instance variables:

ships: a long variable representing the binary representation of the position of the ships on the grid,
* with 1 denoting a ship present at a particular location and 0 denoting the absence of a ship.
shots: a long variable representing the binary representation of the shots taken on the grid,
* with 1 denoting a shot at a particular location and 0 denoting the absence of a shot.
It has two main methods:

shoot: This method takes a string argument representing the target cell in the format of "A1" and
*  returns true if there is a ship present at that cell or false otherwise.
* It updates the shots instance variable to reflect the shot taken on the grid.
state: This method returns a string representation of the state of the grid,
* with "☒" denoting a shot taken and hitting a ship, "×" denoting a shot taken and missing a ship,
*  "☐" denoting a ship present and unhit, and "." denoting a blank cell with no shot or ship.
This implementation of the class Battleship8x8 implements the game rules and can be used to play the game.
* */