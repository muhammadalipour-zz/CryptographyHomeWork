package myExercise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class PrbOneCryptoG {
	
	
	
	
    @SuppressWarnings("resource")
	public static void main(String []args)
    {
    	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 createAndShowGUI();
                 }
             });
        Scanner scan = new Scanner(System.in);
        System.out.println("\tPress KEY '1' for Kth Permutation\n\tPress '2' for Lexigraphical Order\n\tFrom Option 1,2:\t");
        
        int option = scan.nextInt();
        int n=0;
        if(option==1)   
       //For Finding K- The Permutation
        {
            System.out.println("Enter n: ");
            n = scan.nextInt();
            System.out.println("Enter k: ");
            int k = scan.nextInt();
            System.out.println("n is "+n+"\t k is "+k);

            if(k>=1 && k<=permutation(n))
            {
                int[] array =myExercise.Kpurmuthtation.kthPermutation(k, n);
                System.out.println("Permutation: " + Arrays.toString(array));

            }
            else
            {
                System.out.println("K Not satisfy the rule");
            }
        }
      
 //For Finding Lexigraphical Order Geting 3rd Option
        else if (option==2)    
        {
            System.out.println("Enter Lexigraphical Order of n: ");
            n = scan.nextInt();
            System.out.println("Enter Lexigraphical Array[USE SPACE]: ");
            int[] lex = new int[n];
            for(int i=0; i<n; i++)
            {
                lex[i] = scan.nextInt();
            }

            System.out.println("Lex is " + Arrays.toString(lex));
            int order = myExercise.Kpurmuthtation.OrderofPermutation(lex,n)+1;
            System.out.println("Lexigraphical Order: " + order);
        }
        

    }
    private static void createAndShowGUI() {
        final String[] labels = {"Enter n: ", "Enter k: ", "Enter Lexigraphical Order: "};
        int labelsLength = labels.length;
        final JTextField[] textField = new JTextField[labels.length];
        //Create and populate the panel.
        JPanel p = new JPanel(new SpringLayout());
        for (int i = 0; i < labelsLength; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            p.add(l);
            textField[i] = new JTextField(10);
            l.setLabelFor(textField[i]);
            p.add(textField[i]);
        }
        JButton button = new JButton("Submit");
        p.add(new JLabel());
        p.add(button);

//        //Lay out the panel.
//        SpringUtilities.makeCompactGrid(p, labelsLength + 1, 2, // rows, cols
//                7, 7, // initX, initY
//                7, 7); // xPad, yPad

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                for (int i = 0 ; i < labels.length ; i++)
                {
                    System.out.println(labels[i]+"->"+textField[i].getText());
                }
            }
        });  
        //Create and set up the window.
        JFrame frame = new JFrame("SpringForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        p.setOpaque(true);  //content panes must be opaque
        frame.setContentPane(p);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 	//The N number got from user to find permutation
    public static int permutation(int n)    
    {
        int p=1;
        for(int i=1; i<=n; i++)
        {
            p=p*i;
        }
        if(n==0){p=1;}
        return p;
    }
}

