import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//http://www.javatpoint.com/java-swing
public class mainClass extends JFrame
{
       JPanel bg = new JPanel();
       JLabel jl = new JLabel();
       JLayeredPane pane = new JLayeredPane();

       public mainClass()
       {
    	   ///////////////////////////////////////
    	   //Creating image icons of all the cards
    	   ///////////////////////////////////////
    	   	ImageIcon c2 = new ImageIcon("c2.png");//declaring an image of each type of card
    	   	ImageIcon c3 = new ImageIcon("c3.png");
    	   	ImageIcon c4 = new ImageIcon("c4.png");  
    	   	ImageIcon c5 = new ImageIcon("c5.png");  
    	   	ImageIcon c6 = new ImageIcon("c6.png");  
    	   	ImageIcon c7 = new ImageIcon("c7.png");  
    	   	ImageIcon c8 = new ImageIcon("c8.png");  
    	   	ImageIcon c9 = new ImageIcon("c9.png");  
    	   	ImageIcon c10 = new ImageIcon("c10.png");  
    	   	ImageIcon cj = new ImageIcon("cj.png");  
    	   	ImageIcon cq = new ImageIcon("cq.png");  
    	   	ImageIcon ck = new ImageIcon("ck.png");  
    	   	ImageIcon ca = new ImageIcon("ca.png");  
    	   	ImageIcon d2 = new ImageIcon("d2.png");  
    	   	ImageIcon d3 = new ImageIcon("d3.png");  
    	   	ImageIcon d4 = new ImageIcon("d4.png");  
    	   	ImageIcon d5 = new ImageIcon("d5.png");  
    	   	ImageIcon d6 = new ImageIcon("d6.png");  
    	   	ImageIcon d7 = new ImageIcon("d7.png");  
    	   	ImageIcon d8 = new ImageIcon("d8.png");  
    	   	ImageIcon d9 = new ImageIcon("d9.png");  
    	   	ImageIcon d10 = new ImageIcon("d10.png");  
    	   	ImageIcon dj = new ImageIcon("dj.png");  
    	   	ImageIcon dq = new ImageIcon("dq.png");  
    	   	ImageIcon dk = new ImageIcon("dk.png");  
    	   	ImageIcon da = new ImageIcon("da.png");  
    	   	ImageIcon h2 = new ImageIcon("h2.png");  
    	   	ImageIcon h3 = new ImageIcon("h3.png");  
    	   	ImageIcon h4 = new ImageIcon("h4.png");  
    	   	ImageIcon h5 = new ImageIcon("h5.png");  
    	   	ImageIcon h6 = new ImageIcon("h6.png");  
    	   	ImageIcon h7 = new ImageIcon("h7.png");  
    	   	ImageIcon h8 = new ImageIcon("h8.png");  
    	   	ImageIcon h9 = new ImageIcon("h9.png");  
    	   	ImageIcon h10 = new ImageIcon("h10.png");  
    	   	ImageIcon hj = new ImageIcon("hj.png");  
    	   	ImageIcon hq = new ImageIcon("hq.png");  
    	   	ImageIcon hk = new ImageIcon("hk.png");  
    	   	ImageIcon ha = new ImageIcon("ha.png");  
    	   	ImageIcon s2 = new ImageIcon("s2.png");  
    	   	ImageIcon s3 = new ImageIcon("s3.png");  
    	   	ImageIcon s4 = new ImageIcon("s4.png");  
    	   	ImageIcon s5 = new ImageIcon("s5.png");  
    	   	ImageIcon s6 = new ImageIcon("s6.png");  
    	   	ImageIcon s7 = new ImageIcon("s7.png");  
    	   	ImageIcon s8 = new ImageIcon("s8.png");  
    	   	ImageIcon s9 = new ImageIcon("s9.png");  
    	   	ImageIcon s10 = new ImageIcon("s10.png");  
    	   	ImageIcon sj = new ImageIcon("sj.png");  
    	   	ImageIcon sq = new ImageIcon("sq.png");  
    	   	ImageIcon sk = new ImageIcon("sk.png");  
    	   	ImageIcon sa = new ImageIcon("sa.png");  
              setTitle("Cribbage");//Sets the title of the window
              setVisible(true);//Sets the window to visible.  You have to do this.
              setSize(1532, 870);//(+19,+46)//sets the size of the window as close to the size of the background image as I could get it.. Pretty sure this size includes the size of the window bar
              setDefaultCloseOperation(EXIT_ON_CLOSE);//When you close the window it stops the program

              jl.setIcon(new ImageIcon("bg.png"));//have to set images with icons.  Uses Maria's game board
              jl.setSize(1532,850);//sets the size of the JLabel image.  JLabel can be used for images or plain text that arent supposed to be interacted with.  Maybe use for score keeping later.
              
              pane.add(jl, new Integer(1));//adds background image to the first level of JLayeredPane
              add(pane);//adds the pane to JFrame
              
              JButton startButton = new JButton("CLICK HERE TO START");//creates a start button with the text.  could set to image later for fancy ness
              startButton.setBounds(600,400,350,150);//sets a button at x-600 y-400 with 350x150 size
              
              startButton.addActionListener(new ActionListener(){  //whenever this button (in this case, startButton) is clicked...
            	    public void actionPerformed(ActionEvent e){  //do this action
                        startButton.setVisible(false);//change button to invisible when it is clicked.

                }  
                });  
 
              
              pane.add(startButton, new Integer(2));//adds start button to the second level of JLayeredPane.  startButton is what you're adding new Integer(2) is to what level you're adding it.
              add(pane);//adds the pane to the Frame.
              
            ////////////////////////////
              //CARDS IN HAND SLOTS
            ////////////////////////////
              JButton handSlot1 = new JButton();//creates button for "handSlot1"
              handSlot1.setIcon(ha);//sets the icon for handSlot1.  Can change to any of the image icons set up above.
              handSlot1.setBounds(359,632,122,174);//x location, ylocation, width, height
              //handSlot1.setVisible(true);//pretty sure these are set to visible(true) by default unlike the Frame
              pane.add(handSlot1, new Integer(2));//handSlot1 to pane one the 2nd level of the layeredpane
              add(pane);//adds this to the Frame
              
              JButton handSlot2 = new JButton();//repetition
              handSlot2.setIcon(s10);
              handSlot2.setBounds(486,632,122,174);
              //handSlot1.setVisible(true);
              pane.add(handSlot2, new Integer(2));
              add(pane);
              
              JButton handSlot3 = new JButton();
              handSlot3.setIcon(sj);
              handSlot3.setBounds(614,632,122,174);
              //handSlot1.setVisible(true);
              pane.add(handSlot3, new Integer(2));
              add(pane);
              
              JButton handSlot4 = new JButton();
              handSlot4.setIcon(sq);
              handSlot4.setBounds(742,632,122,174);
              //handSlot1.setVisible(true);
              pane.add(handSlot4, new Integer(2));
              add(pane);
              
              JButton handSlot5 = new JButton();
              handSlot5.setIcon(sk);
              handSlot5.setBounds(869,632,122,174);
              //handSlot1.setVisible(true);
              pane.add(handSlot5, new Integer(2));
              add(pane);
              
              JButton handSlot6 = new JButton();
              handSlot6.setIcon(sa);
              handSlot6.setBounds(997,632,122,174);
              //handSlot1.setVisible(true);
              pane.add(handSlot6, new Integer(2));
              add(pane);
              
            ////////////////////////////////
              //PLAYED CARD SLOTS
            ////////////////////////////////
              JButton playedSlot1 = new JButton();//same thing as above, just located at the top now since its the Played cards
              playedSlot1.setIcon(sk);
              playedSlot1.setBounds(451,55,122,174);//81 <-- the amount of X spacing I used to space the cards evenly.
              //handSlot1.setVisible(true);
              pane.add(playedSlot1, new Integer(2));//these are layered differently so they look like they are layed down in the order they were played, like the game board
              add(pane);
              
              JButton playedSlot2 = new JButton();
              playedSlot2.setIcon(sk);
              playedSlot2.setBounds(532,86,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot2, new Integer(3));
              add(pane);
              
              JButton playedSlot3 = new JButton();
              playedSlot3.setIcon(sk);
              playedSlot3.setBounds(613,55,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot3, new Integer(4));
              add(pane);
              
              JButton playedSlot4 = new JButton();
              playedSlot4.setIcon(sk);
              playedSlot4.setBounds(694,86,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot4, new Integer(5));
              add(pane);
              
              JButton playedSlot5 = new JButton();
              playedSlot5.setIcon(sk);
              playedSlot5.setBounds(775,55,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot5, new Integer(6));
              add(pane);
              
              JButton playedSlot6 = new JButton();
              playedSlot6.setIcon(sk);
              playedSlot6.setBounds(856,86,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot6, new Integer(7));
              add(pane);
              
              JButton playedSlot7 = new JButton();
              playedSlot7.setIcon(sk);
              playedSlot7.setBounds(937,55,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot7, new Integer(8));
              add(pane);
              
              JButton playedSlot8 = new JButton();
              playedSlot8.setIcon(sk);
              playedSlot8.setBounds(1018,86,122,174);
              //handSlot1.setVisible(true);
              pane.add(playedSlot8, new Integer(9));
              add(pane);
              
              
              

              validate();//have to do this or an empty window will pop up.  Not really sure why, but, yeah.
              
       }

       public static void main(String[] args)
       {
             mainClass t = new mainClass();
       }
}
