import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class EmployeeMenu{
    public static void main(String[] args){
        String menu[]={"Add","Delete","Search","Edit","End"};
        String hold="", choice="";
        String name="",number="";
        int age=0,id=0;
        Employee emp=new Employee();
        do{
            hold="Number of Employees:\t"+emp.currentSize()+
                    "\n\nEmployee ID Files"+
                    "\n"+emp.display();
            choice=JOptionPane.showInputDialog(null, new JTextArea(hold),"Employee Management System",1,null,menu,menu[0]).toString();
            switch(choice){
                case "Add":
                    try{
                        name=JOptionPane.showInputDialog(null, "Enter name");
                        age=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter age"));
                        number=JOptionPane.showInputDialog(null, "Enter contact number");
                        id=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID number"));
                        emp.add(name, age, number, id);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Please enter a valid input","Error",JOptionPane.ERROR_MESSAGE);
                    }//end of try catch
                    break; 
                case "Delete":
                        id=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Employee ID to delete"));
                        emp.deleteAtID(id);
                    break; 
                case "Search":
                    try{
                        id=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Employee ID"));
                        JOptionPane.showMessageDialog(null,emp.search(id));
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Please enter a valid input","Error",JOptionPane.ERROR_MESSAGE);
                    }//end of try catch
                    break; 
                case "Edit":
                    try{
                        int code=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Employee ID"));
                        JOptionPane.showMessageDialog(null,emp.search(code));
                        name=JOptionPane.showInputDialog(null, "Enter name");
                        age=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter age"));
                        number=JOptionPane.showInputDialog(null, "Enter contact number");
                        id=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter ID number"));
                        if(emp.uniqueID(id)==true){
                            emp.edit(code, name, age, number, id);
                        }else{
                            emp.error_message("Please enter a unique ID number");
                        }
                        // emp.edit(code, name, age, number, id);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Please enter a valid input","Error",JOptionPane.ERROR_MESSAGE);
                    }//end of try catch
                    break;         
                case "End":   
            }//end of switch
        }while(!choice.equals("End"));//end of do 
    }//end of main
}//end of class