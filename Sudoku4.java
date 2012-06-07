//package sudoku;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

public class Sudoku4 {

	/**
	 * @param args
	 */

	static boolean a[][][] = new boolean[10][10][10];

	static int[][] b = new int[40][3];



	public static void main(String[] args) {



		int ch=0;

		if( read_in()!= 0) System.exit(1);
		init();
		ch= init_2();
		System.out.println(ch);





		if(sikou()!=81){
			sakugo();
		}else{display();}
	}


	public static int  read_in() {
                double a;
                String filename,ret;

/*
setLayout(new GridLayout(2, 3));
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
*/

/*
Object[] possibilities = {"ham", "spam", "yam"};
String st = (String)JOptionPane.showInputDialog(
                    frame,
                    "Complete the sentence:\n"
                    + "\"Green eggs and...\"",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    possibilities,
                    "ham");

//If a string was returned, say so.
if ((st != null) && (st.length() > 0)) {
    setLabel("Green eggs and... " + st + "!");
    return;
}

//If you're here, the return value was null/empty.
setLabel("Come on, finish the sentence!");
*/

		try{
                ret = JOptionPane.showInputDialog(null, "メッセージ","morii.txt");
		if (ret == null) {
			System.out.println("cancel or close");
		} else {
			System.out.println(ret);
		}

		//    BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
                //        System.out.print("please input number(1~3):");

                //        a = Double.valueOf(d.readLine()).doubleValue();

                 //       filename = d.readLine();
                 //       filename = "morii.txt"; 
                 //       if( a == 1 ) filename="morii.txt";
                 //       if( a == 2 ) filename="morii_org.txt";
                 //       if( a == 3 ) filename="morii2.txt";
	//		FileReader in = new FileReader("morii.txt");
			FileReader in = new FileReader(ret);
			BufferedReader buf = new BufferedReader(in);
			String s = new String();
			int i=0;
			int j=0;
			while(buf.ready()){
			   s = buf.readLine();
			   System.out.println(s);
	
			   if(s.charAt(0)=='/'){
				   continue;
			   }	
			   
			   StringTokenizer token = new StringTokenizer(s,",");
                while(token.hasMoreTokens()){
				//System.out.println(token.nextToken());
				b[i][j++]=Integer.parseInt(token.nextToken());
			   }
			   i++;
			   j=0;
			}

			buf.close();
                        return 0;
		}catch(IOException ie){
			System.out.println("Error:can not find file");
                        return 1;
		}catch(Exception e){
			System.out.println("Error:Exception");
                        return 2;
		}
	}



	public static int init_2(){

	int ch =0;

	int i,j=0;
	for(i=0;i<b.length;i++){
		if( b[i][0] != 0){
			ch += tubusi(b[i][0],b[i][1],b[i][2]);
			j++;
		}	
	}
	System.out.println("-------------------"+ i + "(" + j + ")----------------");



	return ch;

	}




	public static int sakugo(){


		double ran;

		init();
		init_2();


		int i,j,k=0;
		int l=0;
		while( 1!=0 ){

		for(i=1;i<=9;i++){
			for(j=1;j<=9;j++){
				for(k=1;k<=9;k++){
					if(a[i][j][k]==true && check(i,j)!=1){


						ran=Math.random();

						if(ran > 0.5){
							System.out.println("SAKUGO"+i+j+k);

							tubusi(i,j,k);
							l=sikou();

							if(l==-1){

							init();
							init_2();
							l=sikou();
							//	a[i][j][k]=false;

							}else if(l==81){

/*    GridLayoutTest4 frame = new GridLayoutTest4(a);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 600, 400);
    frame.setTitle("タイトル");
    frame.setVisible(true);
*/
                                                                display();
								return l;
							}
						}

					}

					if(i==9 && j==9 && k==9){
						System.out.println("End");
					}

				}
			}
		}

		}

	//	return l;
	}


   public static void init(){
	   int i,j,k;
	   for(i =0;i<10;i++){
		   for(j=0;j<10;j++){
			   for(k=0;k<10;k++){
				   a[i][j][k]=true;

			   }
		   }
	   }
   }


   public static int countTrue(){
	   int i,j,k;
	   int l=0;
	   for(i =0;i<10;i++){
		   for(j=0;j<10;j++){
			   for(k=0;k<10;k++){
				   if(a[i][j][k]==true){
					   l++;
				   }

			   }
		   }
	   }
	   return l;
   }





	public static int sikou(){

		int i,j=0;
		int k,l=810;

		for(i=1;i<=13;i++){

			System.out.println(checkrc());
			System.out.println(checkrc());
			System.out.println(check_r1c1_each());
			System.out.println(check_row_each());
			System.out.println(check_columns_each());
			System.out.println(toji_each());

			j=checkrc();
			System.out.println(j);

			k=countTrue();

			if(k == l){
				break;
			}
			l=k;

			if(j==81 || j==-1){
				break;
			}
		}

		return j;
	}


	public static int tubusi(int i,int j,int k){
		int ch=0;
		int l,m,n;


		for(l=1;l<=9;l++){
			a[l][j][k]=false;
			a[i][l][k]=false;
			a[i][j][l]=false;


		}

		for(m=1;m<=3;m++){
			for(n=1;n<=3;n++){
				a[(i-1)/3*3+m][(j-1)/3*3+n][k]=false;
			}
		}

		a[i][j][k]=true;
		if(a[i][j][0]=false){
			a[i][j][0]=true;
			ch++;
		}

		return ch;
	}

	public static int check(int i,int j,int b[]){
		int ch=0;
		int k;
		b[1]=0;
		for(k=1;k<=9;k++){
			if(a[i][j][k]==true){
				ch++;
			    if(b[1]<10000){
				    b[1]=b[1]*10+ k;
			    }
			}
		}
		b[0]=ch;

		return ch;

	}

	public static int check(int i,int j){
		int ch=0;
		int k;

		for(k=1;k<=9;k++){
			if(a[i][j][k]==true){
				ch++;

			}
		}

		return ch;

	}


	public static int checkrc(){
		int k=0;
		int i,j;
		int b[] =new int[2];
		int tedumari=0;

		for(i=1;i<=9;i++){
			for(j=1;j<=9;j++){
				b[0]=0;
				b[1]=0;
				check(i,j,b);
				if(b[0]==0){tedumari=1;
				 System.out.print(b[0]+"(     ) ");
				}else if(b[0]==1){
					System.out.print("1("+b[1]+"    ) ");
					k++;
					tubusi(i,j,b[1]);
					a[i][j][0]=true;
				}else if(b[0]==2){ System.out.print(b[0]+"("+ b[1]+"   ) ");
				}else if(b[0]==3){ System.out.print(b[0]+"("+ b[1]+"  ) ");
				}else if(b[0]==4){ System.out.print(b[0]+"("+ b[1]+" ) ");
				}else if(b[0]==5){ System.out.print(b[0]+"("+ b[1]+") ");
				}else            { System.out.print(b[0]+"("+ b[1]+") ");
				}
			}
			System.out.println();

		}

	/*
		for(i=1;i<=9;i++){
			for(j=1;j<=9;j++){
				System.out.print(a[i][j][0]+ " " );
			}
			System.out.println();
		}
	*/
		if(tedumari==1)return -1;
		else return k;
	}



	public static int check_r1c1(int i,int j,int k){

	int l,m;
	int n=0;
	int o=0;
	int p=0;
		for(l=1;l<=3;l++){
			for(m=1;m<=3;m++){
				if(a[i*3+l][j*3+m][k]==true){
					n++;
					o=i*3+l;
					p=j*3+m;
				}
			}
		}
		if(n==1){
			tubusi(o,p,k);
			a[o][p][0]=true;

		}
		return n;
	}

	public static int check_r1c1_each(){
		int i,j,k;
		int l=0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				for(k=1;k<=9;k++){
					if(check_r1c1(i,j,k)==1){
					//	System.out.println("blocks "+ i+j+k);
						l++;
					}
				}
			}
		}
		return l;
	}


	public static int check_row(int i,int j){

		int l,m=0;
		int n=0;
			for(l=1;l<=9;l++){
					if(a[l][i][j]==true){
						m=l;
						n++;
					}

			}
			if(n==1){
				tubusi(m,i,j);
				a[m][i][0]=true;
			}
			return n;
	}



	public static int check_row_each(){
		int i,j;
		int l=0;
		for(i=1;i<=9;i++){
			for(j=1;j<=9;j++){
					if(check_row(i,j)==1){
						//System.out.println("rows "+ i+j);
						l++;
					}
			}
		}
		return l;
	}


	public static int check_columns(int i,int j){

		int l,m=0;
		int n=0;
			for(l=1;l<=9;l++){
					if(a[i][l][j]==true){
						m=l;
						n++;
					}

			}
			if(n==1){
				tubusi(i,m,j);
				a[i][m][0]=true;
			}
			return n;
	}

	public static int check_columns_each(){
		int i,j;
		int l=0;
		for(i=1;i<=9;i++){
			for(j=1;j<=9;j++){
					if(check_columns(i,j)==1){
						//System.out.println("columns "+ i+j);
						l++;
					}
			}
		}
		return l;
	}

	public static int toji_c(int i){
		int j,k,m,o,p;
		int l=0;
		int c[]= new int[2];
		int d[]= new int[2];
		for(j=1;j<=8;j++){
			for(k=j+1;k<=9;k++){
				o=check(i,j,c);
				p=check(i,k,d);

		//System.out.println(""+i+j+k+" "+c[1]+" "+d[1] );

				if(o==2 && p==2 ){
					if(c[1]==d[1]){
						for(m=1;m<=9;m++){
							if(m!=j && m!=k){
								a[i][m][c[1]/10]=false;
								a[i][m][c[1]%10]=false;

							}

						}

						l++;

					}

				}
			}
		}
		return l;
	}

	public static int toji_r(int i){
		int j,k,l=0;
		int m;
		int c[]= new int[2];
		int d[]= new int[2];
		for(j=1;j<=8;j++){
			for(k=j+1;k<=9;k++){
				if(check(j,i,c)==check(k,i,d) && check(k,i,d)==2 ){
					if(c[1]==d[1]){
						for(m=1;m<=9;m++){
							if(m!=j && m!=k){
								a[m][i][c[1]/10]=false;
								a[m][i][c[1]%10]=false;

							}

						}
						l++;
					}

				}
			}
		}
		return l;
	}

	public static int toji_each(){
		int i,k,l=0;
		for(i=1;i<=9;i++){
			k=toji_r(i);
			if(k!=0){
				System.out.println(i + "gyoume" +k);
				l++;
			}
		}
	//
		for(i=1;i<=9;i++){
			k=toji_c(i);
			if(k!=0){
				System.out.println(i + "retume" +k);
				l++;
			}
		}
		return l;
	}

    public static void display(){
    
    GridLayoutTest4 frame = new GridLayoutTest4(a);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 600, 400);
    frame.setTitle("タイトル");
    frame.setVisible(true);
    }

}
