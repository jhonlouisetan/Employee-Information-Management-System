import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

public class Employee{
    private String name,number;
    private int age,id;
    public Employee head,next;

    public Employee(){
        name="";
        age=0;
        number="";
        id=0;
        next=head=null;
    }

    public Employee(String name, int age, String number, int id){
        this.name=name;
        this.age=age;
        this.number=number;
        this.id=id;
        next=head=null;
    }

    public void error_message(String msg){
        JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE);
    }

     /**Returns <b> true <b> if the list is empty (head is equal to null)
     * @return true or false
     */
    public boolean isEmpty(){
        return head==null;
    }

    /**
     * Returns the size of the list
     * @return int
     */
    public int currentSize(){
        int ctr=0;
        File path=new File("D:/Jolo/Programming Shit/Data Structures and Algorithms"); // change the path to match your system's
        File[] files=path.listFiles(new FilenameFilter(){
            @Override 
            public boolean accept(File dir, String name){
                return name.endsWith(".txt");
            }
        });
        for (File file:files){
            ctr++;
        }
        return ctr;

        // int counter=1;
        // if(isEmpty()){
        //     return 0;
        // }else{
        //     Employee link=head;
        //     while(link.next!=null){
        //         link=link.next;
        //         counter++;
        //     }
        //     return counter;
        // }
    }

    /**
     * Checks if the Employee ID is unique
     * @param id - int
     * @return boolean
     */
    public boolean uniqueID(int id){
        Employee link;
        link=head;
        while(link.id!=id){
            link=link.next;
            return true;
        }
        return false;
    }

     /**
     * Displays the Employee ID and name
     * @return String
     */
    public String display(){
        String hold="";
        File path=new File("D:/Jolo/Programming Shit/Data Structures and Algorithms"); // change the path to match your system's
        File[] files=path.listFiles(new FilenameFilter(){
            @Override 
            public boolean accept(File dir, String name){
                return name.endsWith(".txt");
            }
        });
        for (File file:files){
            hold+=file.getName()+"\n";
        }
        return hold;
        // if(isEmpty()){
        //     return "";
        // }else{
        //     String hold="";
        //     Employee link=head; 
        //     while(link!=null){
        //         hold+=link.id+"\t"+link.name+"\n";
        //         link=link.next; 
        //     }
        //     return hold;
        // }
    }
    // public String display(Employee n){
    //     String hold="";
    //     while(n!=null){
    //         hold+=n.id+"\t"+n.name+"\n";
    //         n=n.next;
    //     }
    //     return hold;
    // }

    /**
     * Adds data 
     * @param name - String
     * @param age - int
     * @param number - String
     * @param id - int
     * @return void
     */
    public void add(String name, int age, String number, int id){
        Employee newNode=new Employee(); 
        try{
            if(isEmpty()){
                File f1=new File(id+"_"+"file.txt");
                if(f1.createNewFile()){
                    newNode.name=name;
                    newNode.age=age;
                    newNode.number=number;
                    newNode.id=id;
                    newNode.next=null;
                    head=newNode;
                    FileWriter writer=new FileWriter(id+"_"+"file.txt");
                    writer.write("Employee Name: "+newNode.name+
                                    "\nEmployee Age: "+newNode.age+
                                    "\nEmployee Contact Number: "+newNode.number+
                                    "\nEmployee ID: "+newNode.id);
                    writer.close();
                }
            }else{
                if(uniqueID(id)==true){
                    File f1=new File(id+"_"+"file.txt");
                    if(f1.createNewFile()){
                        newNode.name=name;
                        newNode.age=age;
                        newNode.number=number;
                        newNode.id=id;
                        newNode.next=head;
                        head=newNode;
                        FileWriter writer=new FileWriter(id+"_"+"file.txt");
                        writer.write("Employee Name: "+newNode.name+
                                    "\nEmployee Age: "+newNode.age+
                                    "\nEmployee Contact Number: "+newNode.number+
                                    "\nEmployee ID: "+newNode.id);
                        writer.close();
                    }
                }else{
                    error_message("Please enter a unique ID number");
                }
            }
        }catch(Exception e){
            
        }
    }

    /**
     * Deletes the data for the selected employee ID
     * @param id - int
     * @return void
     */
    // public void deleteAtID(int id){
    //     if(isEmpty()){
    //         error_message("List is empty.");
    //     }else if(id<0){
    //         error_message("Employee not found.");
    //     }else{
    //         Employee link,visit;
    //         visit=link=head;
    //         if(link==null){
    //             error_message("Employee not found");
    //         }
    //         if(link!=null&&link.id==id){
    //             head=link.next;
    //         }
    //         while(link!=null&&link.id!=id){
    //             visit=link;
    //             link=link.next;
    //         }
    //         visit.next=link.next;
    //         JOptionPane.showMessageDialog(null, "Employee ID #"+id+" deleted.");
    //     }
    // }

    public void deleteAtID(int id){
        File file=new File(id+"_"+"file.txt");
        // if(isEmpty()&&!file.exists()){
        //     error_message("List is empty");
        // }
        if(file.exists()){
            if(file.delete()){
                // Employee link,visit;
                // visit=link=head;
                // if(link!=null&&link.id==id){
                //     head=link.next;
                // }
                // while(link!=null&&link.id!=id){
                //     visit=link;
                //     link=link.next;
                // }
                // visit.next=link.next;
                JOptionPane.showMessageDialog(null, "Employee ID #"+id+" deleted.");
            }
        }else{
            error_message("Employee not found");
        }
    }

    /**
     * Gets data of selected employee ID
     * @param id - int
     * @return String
     */
    public String search(int id) throws Exception{
        // String hold="";
        // Employee link;
        // link=head;
        // if(link==null){
        //     return "List is empty";
        // }else if(id<0){
        //    return "Employee not found.";
        // }
        // while(link!=null&&link.id!=id){
        //     link=link.next;
        // }
        // hold="Employee Name: "+link.name+
        //         "\nEmployee Age: "+ link.age+
        //         "\nEmployee Contact Number: "+link.number+
        //         "\nEmployee ID: "+link.id;
        // return hold;
        File file = new File(id+"_"+"file.txt");
        Scanner sc = new Scanner(file);
        String hold="";
        while (sc.hasNextLine())
        {
            hold+=sc.nextLine()+"\n";
        }
        return hold;
    }

    /**
     * This method edits the already entered data
     * @param code - int
     * @param name - String
     * @param age - int
     * @param number - String
     * @param id - int
     * @return void
     */
    public void edit(int code,String name, int age, String number, int id) throws IOException{
        Employee link;
        link=head;
        if(link==null){
           error_message("Employee not found");
        }
        
        while(link!=null&&link.id!=code){
            link=link.next;
        }
        link.name=name;
        link.age=age;
        link.number=number;
        link.id=id;
        FileWriter writer=new FileWriter(id+"_"+"file.txt"); //probably remove lines above this and int id. replace id with code in this line
        writer.write("\nEdited\nEmployee Name: "+link.name+
                    "\nEmployee Age: "+link.age+
                    "\nEmployee Contact Number: "+link.number+
                    "\nEmployee ID: "+link.id); //code
        File file=new File(id+"_"+"file.txt"); // comment out
        File rename=new File(link.id+"_"+"file.txt"); //comment out
        file.renameTo(rename); //comment out
        writer.close();
    }
}