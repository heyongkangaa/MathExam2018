import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MathExam6357 {

	public static void main(String[] args) throws IOException {
			for(;;) {
				Scanner input=new Scanner(System.in);
				System.out.println("请输入问题数目和所需年级：");
				//int []z =new int [args.length];
				//z[0] = Integer.parseInt(args[0]);
				//z[1] = Integer.parseInt(args[1]);
			    //int n =z[0];
			    int n = input.nextInt();
				//int m =z[1];
				int m = input.nextInt();
				FileOutputStream in =new FileOutputStream("out.txt");
				String[] answerlist = new String[n];
				String[] questionlist = new String[n];
				String[] yushulist = new String[n];
				for (int i = 0; i < yushulist.length; i++) {
					yushulist[i]="0";
				}
				if(m==1) {
					for(int i=0;i<n;i++){
						int a=(int) (Math.random()*100+1);
						int b=(int) (Math.random()*100+1);
						int c=(int) (Math.random()*2);
						//StringBuffer question = null;
						//StringBuffer result = null;
						if(c==0) {
							System.out.println("("+(i+1)+")"+a+"+"+b+"=");
							//question = new StringBuffer("("+(i+1)+")"+a+"+"+b+"=");
							questionlist[i]="("+(i+1)+")"+a+"+"+b+"=";
							answerlist[i]=" "+(a+b);
							//result = new StringBuffer(" "+(a+b));
							}
						else {
							b=(int) (Math.random()*a+1);
							System.out.println("("+(i+1)+")"+a+"-"+b+"=");
							//question = new StringBuffer("("+(i+1)+")"+a+"-"+b+"=");
							questionlist[i]="("+(i+1)+")"+a+"-"+b+"=";
							answerlist[i]=" "+(a-b);
							//result = new StringBuffer(" "+(a-b));
							}
						//byte[] ba = question.toString().getBytes();
						byte[] ba = questionlist[i].getBytes();
						String pa ="\r\n";
						byte[] ta = pa.getBytes(); 
						in.write(ba);
						in.write(ta);
						}
					}
				else  {
					for(int i=0;i<n;i++){
						int a=(int) (Math.random()*9+1);
						int b=(int) (Math.random()*9+1);
						int c=(int) (Math.random()*2);
						//StringBuffer question = null;
						//StringBuffer result = null;
						if(c==0) {
							System.out.println("("+(i+1)+")"+a+"*"+b+"=");
							//question = new StringBuffer("("+(i+1)+")"+a+"*"+b+"=");
							questionlist[i]="("+(i+1)+")"+a+"*"+b+"=";
							answerlist[i]=" "+(a*b);
							//result = new StringBuffer(" "+(a*b));
						}
						else {
							
							System.out.println("("+(i+1)+")"+a+"÷"+b+"=");
							//question = new StringBuffer("("+(i+1)+")"+a+"÷"+b+"=");
							questionlist[i]="("+(i+1)+")"+a+"÷"+b+"=";
							answerlist[i]=" "+(a/b);
							yushulist[i]=" "+(a%b);
							//result = new StringBuffer(" "+(a/b));
						}
						//byte[] ba = question.toString().getBytes();
						byte[] ba = questionlist[i].getBytes();
						String pa ="\r\n";
						byte[] ta = pa.getBytes(); 
						in.write(ba);
						in.write(ta);
					}
				}
				String wa  ="---------标准答案----------"+"\n";
				System.out.print(wa);
				byte[] ea =wa.getBytes();
				in.write(ea);
				for (int i = 0; i <questionlist.length; i++) {
					byte[] za = questionlist[i].getBytes();
					byte[] sa = answerlist[i].toString().getBytes();
					in.write(za);
					in.write(sa);
					System.out.println(questionlist[i]+answerlist[i]);
					if(!yushulist[i].equals("0")) {
						byte[] ra =yushulist[i].getBytes();
						String ua="......";
						byte[] ya =ua.getBytes();
						in.write(ya);
						in.write(ra);
						System.out.println(questionlist[i]+answerlist[i]+ua+yushulist[i]);
						}
					
					//System.out.println(questionlist[i]);
					String pa ="\r";
					byte[] ta = pa.getBytes();
					in.write(ta);
				}
				
			System.out.println("请选择退出(0)或者继续(1)！");
			int g = input.nextInt();
			if(g==1) {
					continue;
				}else {
					System.out.println("谢谢使用！");
					break;
					
				}
			}
			}

}
