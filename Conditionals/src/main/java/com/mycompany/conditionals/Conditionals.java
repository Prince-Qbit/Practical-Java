/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conditionals;

/**
 *
 * @author User
 */
public class Conditionals {

    public static void main (String[] args) {
        double score = 100;
        String [] grades = {"A", "B", "C"};
        
        if (score >= 90 && score  <=100) {
            System.out.println ("Your grade is " + grades [0] + ".");
        }
        else if (score >= 80 && score <= 89 ) {
            System.out.println ("Your grade is " + grades [1] + ".");
        }
        
        else if (score >= 70 && score <= 79) {
            System.out.println ("Your grade is " +grades  [2] + ".");
        }
        
        else {
            System.out.println ("Your scores are not gradeable.");
        }
    }
    }
