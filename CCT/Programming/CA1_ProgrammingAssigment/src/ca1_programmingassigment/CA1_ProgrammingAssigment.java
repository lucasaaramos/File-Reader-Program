/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca1_programmingassigment;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class CA1_ProgrammingAssigment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //This first step is to declare the txt documents using string on my program.
        //After doing that my program can find the document which is inside of the program's folder
        String myFilePeople = "people.txt";
        String myFileStatus = "status.txt";

        //using try-atch because the file can not exist 
        //it is necessary when I work on FileReader 
        try {
            //allowing my program read the variable declared (myInput)
            Scanner myInput = new Scanner(new FileReader(myFilePeople));
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(myFileStatus, false));

            //declaring that my program will keep working while the informations in the file is following the informations below
            while (myInput.hasNext()) {

                //Stringing fullname, name, surname and the first letter of the name to output later
                String fullname = myInput.nextLine();
                String name = fullname.substring(0, fullname.indexOf(" "));
                String surname = fullname.substring(fullname.indexOf(" "));
                String initial = fullname.substring(0, 1);

                //declaring that it can be only letters
                if (!name.matches("[A-Za-z]+") && (!surname.matches("[A-Za-z]+"))) {
                    System.out.println("Name: Only letters is accepted, please try again");

                } else {

                    //outputing my name on my Netbeans screen to help me being organized with my program and be aware about possible mistakes
                    System.out.println("Name: " + name + surname);
                    //using trim to not considering the spaces before and after the non-space caracter

                }

                //Stringing my age and declaring that now I'm working on the second line
                String age = myInput.nextLine();

                //converting to Integer because the program can read only string, making
                //necessary using Integer to convert it as it is a number
                int ageInt = Integer.parseInt(age);

                //using this condition to declare that it can be only numbers between 0 and 100
                if (ageInt < 0 && ageInt > 100) {

                    System.out.println("Age: Please enter an age between 0 and 100");

                } else if (age.matches("[A-Za-z]+")) {

                    System.out.println("Age: Only nymbers are accepted");

                } else {

                    System.out.println("Age: " + age);

                }

                //Stringing my gender and declaring that now I'm working on the third line
                String gender = myInput.nextLine();

                //declaring that it can be just a single letter and M,F or T.
                if ((gender.length() > 1) || !gender.equals("M") && !gender.equals("F") && !gender.equals("T")) {

                    System.out.println("Gender: It needs to be M for male, F for female or T for trangeder. Please correct it!");

                } else {
                    gender = gender.trim();
                    System.out.println("Gender: " + gender);
                }

                //Outputing the informations into my txt file called "status" accurding the following condictions 
                // using the instructure (Mr/Ms/Mx - surname - first letter)to output
                if (gender.equals("M")) {

                    myWriter.write("Mr. " + surname + "," + initial);

                } else if (gender.equals("F")) {

                    myWriter.write("Ms. " + surname + "," + initial);

                } else if (gender.equals("T")) {

                    myWriter.write("Mx. " + surname + "," + initial);
                }

                //changing the outputing line
                myWriter.newLine();

                //criating condictions to determine the people status and output this information
                if (ageInt >= 0 && ageInt <= 18) {
                    myWriter.write("School");

                } else if (ageInt >= 19 && ageInt <= 25) {
                    myWriter.write("College");

                } else if (ageInt >= 26 && ageInt <= 66) {
                    myWriter.write("Worker");

                } else if (ageInt >= 67) {
                    myWriter.write("Retired");

                }
                //changing the outputing line
                myWriter.newLine();

            }

            //saving the informations in the txt document 
            myWriter.close();

            //if there is nothing in the file it goes here
        } catch (Exception e) {

            System.out.println("There is nothing on the file, please check it again");

        }

    }
}
