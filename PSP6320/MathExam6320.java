
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MathExam6320 {
	public static void CreatFile() {
		String filename="out.txt";
		File file=new File(filename);
		if(!file.exists()) {
			System.out.println("文件创建成功");
		}else {
			System.out.println("文件已存在");
		}
	}
	
	public static void print(int N,int M) {
		char sign[]= {'+','-','*','/'};
		Random random=new Random();
		Map<Integer,String> map1=new HashMap<Integer,String>();
		Map<Integer,Integer> map2=new HashMap<Integer,Integer>();
		for(int i = 1; i <= N; i++) {
			int x=random.nextInt(M);
			int y=random.nextInt(M);
			int f=random.nextInt(M)%2;
			int num = 0;
			
			switch (f) {
				case 0:num=x+y;	break;
				case 1:
					while(y>x) {
						y=random.nextInt(M);
					}
					num=x-y;	break;
				case 2:num=x*y; break;
				case 3:
					while(y==0) {
						y=random.nextInt(M);
					}
					x=x*y;
					num=x/y;
					break;
			}
			map1.put(i,x+" "+sign[f]+" "+y);
			map2.put(i,num);
		}
		
		
		PrintStream pS=null;
		try {
			pS = new PrintStream(new FileOutputStream("out.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载文件失败");
			e.printStackTrace();
		}
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i));
			System.out.println("("+i+") "+map1.get(i));
		}
		pS.println("");
		System.out.println("");
		for (int i = 1; i <= N; i++) {
			pS.println("("+i+") "+map1.get(i)+" = "+map2.get(i));
			System.out.println("("+i+") "+map1.get(i)+" = "+map2.get(i));
		}
		pS.close();
	}
	
	public static void main(String[] args) {
		if(args[0]!= null && args[0].matches("0*[0-9]{0,3}")){
			Integer N=Integer.parseInt(args[0]);
			CreatFile();
			print(N,50);
		}else {
			System.out.println("少于或多于一个参数\n" + 
					"参数为非数字\n"+
					"参数过大(范围在1~999)");
		}	
	}
}
