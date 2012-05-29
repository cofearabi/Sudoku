//package sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Sudoku4 {

	/**
	 * @param args
	 */

	static boolean a[][][] = new boolean[10][10][10];

	static int[][] b = new int[40][3];



	public static void main(String[] args) {


/*
		int i,j,k;
		for(i =0;i<10;i++){
			for(j=0;j<10;j++){
				for(k=0;k<10;k++){
					a[i][j][k]=true;

				}
			}
		}


		for(i =0;i<10;i++){
			for(j=0;j<10;j++){
					a[i][j][0]=false;

			}
		}
*/

		





		int ch=0;

		if( read_in()!= 0) System.exit(1);
		init();
		ch= init_2();
		System.out.println(ch);




/*


*/


//      Sample1	(28)









/*


		System.out.println(checkrc());
		System.out.println(check_r1c1_each());
*/

		if(sikou()!=81){
			sakugo();
		}
	}


	public static int  read_in() {
		try{
			FileReader in = new FileReader("morii.txt");
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

//  Team Morii  (28)

/*
			ch += tubusi(1,1,8);
			ch += tubusi(1,2,7);
			ch += tubusi(1,5,1);
			ch += tubusi(1,6,4);
			ch += tubusi(1,7,6);
			ch += tubusi(2,1,6);
			ch += tubusi(2,6,2);
			ch += tubusi(2,7,3);
			ch += tubusi(3,7,1);
			ch += tubusi(3,8,5);
			ch += tubusi(3,9,8);

			ch += tubusi(4,8,2);
			ch += tubusi(4,9,6);

			ch += tubusi(5,1,7);
			ch += tubusi(5,9,4);

			ch += tubusi(6,1,3);
			ch += tubusi(6,2,5);
			ch += tubusi(7,1,5);
			ch += tubusi(7,2,1);
			ch += tubusi(7,3,2);

			ch += tubusi(8,3,3);
			ch += tubusi(8,4,7);
			ch += tubusi(8,9,5);

			ch += tubusi(9,3,7);
			ch += tubusi(9,4,5);
			ch += tubusi(9,5,3);
			ch += tubusi(9,8,8);
			ch += tubusi(9,9,9);
*/

//  team Takase (28)
/*
			ch += tubusi(1,8,2);
			ch += tubusi(1,9,3);

			ch += tubusi(2,1,1);
			ch += tubusi(2,3,6);
			ch += tubusi(2,4,3);
			ch += tubusi(2,6,7);

			ch += tubusi(2,8,4);
			ch += tubusi(2,9,8);

			ch += tubusi(3,1,4);
			ch += tubusi(3,6,1);

			ch += tubusi(4,1,9);
			ch += tubusi(4,3,7);
			ch += tubusi(4,4,5);
			ch += tubusi(4,6,8);

			ch += tubusi(6,4,6);
			ch += tubusi(6,6,3);
			ch += tubusi(6,7,5);
			ch += tubusi(6,9,9);

			ch += tubusi(7,4,7);
			ch += tubusi(7,9,5);

			ch += tubusi(8,1,7);
			ch += tubusi(8,2,4);
			ch += tubusi(8,4,8);
			ch += tubusi(8,6,5);
			ch += tubusi(8,7,3);
			ch += tubusi(8,9,6);

			ch += tubusi(9,1,2);
			ch += tubusi(9,2,9);
*/



	//  sample1  ()
	/*
	ch += tubusi(1,1,4);
	ch += tubusi(1,4,7);
	ch += tubusi(1,6,9);
	ch += tubusi(1,9,6);
	ch += tubusi(2,1,9);

	ch += tubusi(2,4,8);
	ch += tubusi(2,6,2);
	ch += tubusi(2,9,3);
	ch += tubusi(3,1,3);
	ch += tubusi(3,2,1);
	ch += tubusi(3,8,7);

	ch += tubusi(3,9,8);
	ch += tubusi(4,3,5);
	ch += tubusi(4,7,6);
	ch += tubusi(6,2,4);
	ch += tubusi(6,8,9);

	ch += tubusi(7,1,2);
	ch += tubusi(7,2,9);
	ch += tubusi(7,8,6);
	ch += tubusi(7,9,5);

	ch += tubusi(8,3,4);
	ch += tubusi(8,4,9);
	ch += tubusi(8,6,3);
	ch += tubusi(8,7,2);

	ch += tubusi(9,3,3);
	ch += tubusi(9,4,2);
	ch += tubusi(9,6,6);
	ch += tubusi(9,7,4);
	*/


 //      Expert(23)


/*
	ch += tubusi(1,3,5);
	ch += tubusi(1,4,3);

	ch += tubusi(2,1,8);
	ch += tubusi(2,8,2);

	ch += tubusi(3,2,7);
	ch += tubusi(3,5,1);
	ch += tubusi(3,7,5);

	ch += tubusi(4,1,4);
	ch += tubusi(4,6,5);
	ch += tubusi(4,7,3);

	ch += tubusi(5,2,1);
	ch += tubusi(5,5,7);
	ch += tubusi(5,9,6);

	ch += tubusi(6,3,3);
	ch += tubusi(6,4,2);
	ch += tubusi(6,8,8);

	ch += tubusi(7,2,6);
	ch += tubusi(7,4,5);
	ch += tubusi(7,9,9);


	ch += tubusi(8,3,4);
	ch += tubusi(8,8,3);

	ch += tubusi(9,6,9);
	ch += tubusi(9,7,7);
*/



//expert finland(23)

	/*
		int[][] b= {

		{1,3,5},
		{1,4,3},

		{2,1,8},
		{2,8,2},

		{3,2,7},
		{3,5,1},
		{3,7,5},

		{4,1,4},
		{4,6,5},
		{4,7,3},

		{5,2,1},
		{5,5,7},
		{5,9,6},

		{6,3,3},
		{6,4,2},
		{6,8,8},

		{7,2,6},
		{7,4,5},
		{7,9,9},


		{8,3,4},
		{8,8,3},

		{9,6,9},
		{9,7,7}

		};

	*/




//  team Oguri (23)
/*

	ch += tubusi(1,3,1);

	ch += tubusi(2,2,2);
	ch += tubusi(2,4,5);
	ch += tubusi(2,8,1);

	ch += tubusi(3,2,3);
	ch += tubusi(3,4,8);
	ch += tubusi(3,7,2);
	ch += tubusi(3,9,5);

	ch += tubusi(4,2,4);
	ch += tubusi(4,7,3);
	ch += tubusi(4,9,8);

	ch += tubusi(5,3,5);
	ch += tubusi(5,7,4);

	ch += tubusi(6,1,3);
	ch += tubusi(6,3,6);
	ch += tubusi(6,8,5);

	ch += tubusi(7,1,1);
	ch += tubusi(7,3,7);
	ch += tubusi(7,6,3);
	ch += tubusi(7,8,6);

	ch += tubusi(8,2,8);
	ch += tubusi(8,6,1);
	ch += tubusi(8,8,7);

	ch += tubusi(9,7,8);


*/


// Team Kuriyama
//

/*
			ch += tubusi(1,2,6);
			ch += tubusi(1,4,1);
			ch += tubusi(1,6,2);
			ch += tubusi(1,8,3);

			ch += tubusi(2,1,7);
			ch += tubusi(2,3,8);
			ch += tubusi(2,5,6);
			ch += tubusi(2,7,9);
			ch += tubusi(2,9,2);

			ch += tubusi(3,2,1);
			ch += tubusi(3,4,9);
			ch += tubusi(3,6,8);
			ch += tubusi(3,8,7);

			ch += tubusi(4,1,2);
			ch += tubusi(4,3,6);
			ch += tubusi(4,5,4);
			ch += tubusi(4,7,1);
			ch += tubusi(4,9,3);

			ch += tubusi(5,2,9);
			ch += tubusi(5,4,6);
			ch += tubusi(5,6,7);
			ch += tubusi(5,8,8);

			ch += tubusi(6,1,1);
			ch += tubusi(6,3,4);
			ch += tubusi(6,5,9);
			ch += tubusi(6,7,7);
			ch += tubusi(6,9,5);


			ch += tubusi(7,2,2);
			ch += tubusi(7,4,5);
			ch += tubusi(7,6,1);
			ch += tubusi(7,8,4);

			ch += tubusi(8,1,9);
			ch += tubusi(8,3,5);
			ch += tubusi(8,5,3);
			ch += tubusi(8,7,8);
			ch += tubusi(8,9,1);

			ch += tubusi(9,2,3);
			ch += tubusi(9,4,4);
			ch += tubusi(9,6,9);
			ch += tubusi(9,8,5);
*/



//  Sample2  (28)

/*
	ch += tubusi(1,2,6);
	ch += tubusi(1,3,2);
	ch += tubusi(1,4,5);
	ch += tubusi(1,5,9);
	ch += tubusi(1,8,3);
	ch += tubusi(1,9,1);

	ch += tubusi(2,8,5);

	ch += tubusi(3,2,1);
	ch += tubusi(3,3,9);
	ch += tubusi(3,4,7);

	ch += tubusi(5,1,9);
	ch += tubusi(5,4,2);
	ch += tubusi(5,5,6);
	ch += tubusi(5,8,7);

	ch += tubusi(6,2,7);
	ch += tubusi(6,3,1);
	ch += tubusi(6,4,9);
	ch += tubusi(6,8,2);
	ch += tubusi(6,9,8);

	ch += tubusi(7,2,8);
	ch += tubusi(7,3,7);
	ch += tubusi(7,4,4);
	ch += tubusi(7,9,6);

	ch += tubusi(8,4,8);
	ch += tubusi(8,6,9);

	ch += tubusi(9,3,4);
	ch += tubusi(9,5,3);
	ch += tubusi(9,9,2);
*/


/*
		int[][] b = {
				{1,3,5},
				{2,2,2},
				{2,5,5},
				{2,8,8},
				{3,3,4},
				{3,4,3},
				{3,6,1},
				{3,7,5},
				{3,9,9},
				{4,3,3},
				{4,5,8},
				{4,7,7},
				{5,2,4},
				{5,8,5},
				{6,3,8},
				{6,5,6},
				{6,7,2},
				{7,1,7},
				{7,3,6},
				{7,4,8},
				{7,6,2},
				{7,7,1},
				{8,2,1},
				{8,5,7},
				{8,8,2},
				{9,7,4},

		};
*/


//      (23)
/*
		int[][] b1 = {
				{1,4,9},
				{1,7,2},
				{2,3,6},
				{2,5,3},
				{2,8,4},
				{3,2,8},
				{3,9,5},
				{4,1,9},
				{4,4,2},
				{4,7,1},
				{5,2,5},
				{5,5,8},
				{5,8,6},
				{6,3,8},
				{6,6,4},
				{6,9,3},
				{7,1,2},
				{7,8,9},
				{8,2,7},
				{8,5,6},
				{8,7,8},
				{9,3,3},
				{9,6,5},

		};

*/


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
				 System.out.print(b[0]+"(     )  ");
				}else if(b[0]==1){
					System.out.print("1("+b[1]+"    )  ");
					k++;
					tubusi(i,j,b[1]);
					a[i][j][0]=true;
				}else if(b[0]==2){ System.out.print(b[0]+"("+ b[1]+"   )  ");
				}else if(b[0]==3){ System.out.print(b[0]+"("+ b[1]+"  )  ");
				}else if(b[0]==4){ System.out.print(b[0]+"("+ b[1]+" )  ");
				}else if(b[0]==5){ System.out.print(b[0]+"("+ b[1]+")  ");
				}else            { System.out.print(b[0]+"("+ b[1]+")  ");
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

}
