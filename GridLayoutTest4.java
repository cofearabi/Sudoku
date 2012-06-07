import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class GridLayoutTest4 extends JFrame{

  public static void main(String[] args){

    boolean a[][][] = new boolean[10][10][10];

/*
    a[1][9][1] = true;
    a[1][1][2] = true;
    a[1][2][3] = true;
    a[1][3][4] = true;
    a[1][4][5] = true;
    a[1][5][6] = true;
    a[1][6][7] = true;
    a[1][7][8] = true;
    a[1][8][9] = true;

*/

    GridLayoutTest4 frame = new GridLayoutTest4(a);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 600, 400);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  GridLayoutTest4(boolean a[][][]){

    int i,j,k;
//    String s[][] = new String[10][10];
    String s="";
    i=1;
    j=1;
   JButton[] button =  new JButton[81];

    for ( i =1 ; i < 10 ; i++ )
    for ( j =1 ; j < 10 ; j++ )
    for ( k =1 ; k < 10 ; k++ ){
        if( a[i][j][k] == true)s=String.valueOf(k);

   button[i*9-9+j-1] = new JButton(s);
    }

/*
JButton button1  = new JButton(s[1][1]);
JButton button2  = new JButton(s[1][2]);
JButton button3  = new JButton(s[1][3]);
JButton button4  = new JButton(s[1][4]);
JButton button5  = new JButton(s[1][5]);
JButton button6  = new JButton(s[1][6]);
JButton button7  = new JButton(s[1][7]);
JButton button8  = new JButton(s[1][8]);
JButton button9  = new JButton(s[1][9]);
*/

//    JButton button10  = new JButton("button19");

    JPanel p = new JPanel();
    GridLayout layout = new GridLayout(9, 9);
    layout.setHgap(10);
    layout.setVgap(5);
    p.setLayout(layout);

//    p.add(button[0]);


    for( i =0; i< 81 ; i++){
    p.add(button[i]);


/*
    p.add(button1);
    p.add(button2);
    p.add(button3);
    p.add(button4);
    p.add(button5);
    p.add(button6);
    p.add(button7);
    p.add(button8);
    p.add(button9);
    p.add(button10);
*/

    }

    getContentPane().add(p, BorderLayout.CENTER);
  }
}
