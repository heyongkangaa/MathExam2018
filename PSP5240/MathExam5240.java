import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MathExam5240 {
	public static int multiplication(int i,OutputStream out) {
		int a =(int) (Math.random()*10);
		int b =(int) (Math.random()*10);
		String word=("("+(i+1)+") "+a +" * "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a*b;
		
	}
	public static void division(int i,OutputStream out,int intArray[],int intArray1[]) {
		int a =(int) (Math.random()*100);
		int b =(int) (1+Math.random()*9);
		String word=("("+(i+1)+") "+a +" / "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		intArray[i]=a/b;
		intArray1[i]=a%b;
		
	}
	public static int addition(int i,OutputStream out) {
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(100-a+1));
		String word=("("+(i+1)+") "+a +" + "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a+b;
	}
	public static int subtraction (int i,OutputStream out){
		int a =(int) (Math.random()*100);
		int b =(int) (Math.random()*(a+1));
		String word=("("+(i+1)+") "+a +" - "+ b +" = ")+"\n";
		try {
			out.write(word.getBytes());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return a-b;
	}
	public static void math(int n,int grade){
		int j;
		if(grade==1) {
			j=2;
		}else {
			j=4;
		}
		int intArray[] = new int[n];
		int intArray1[] = new int[n];
		String filename="out";
		  File file = new File(filename+".txt"); 
		  OutputStream out;
		try {
			out = new FileOutputStream(file);
			
			for(int i=0;i<n;i++)
		{	int k=(int) (Math.random()*j);
			if (k==0) {//���мӷ�����
				intArray[i]=addition(i,out);
				intArray1[i]=0;
		}else if(k==1){//���м�������
			intArray[i]=subtraction(i,out);
			intArray1[i]=0;
		}else if(k==2) {
			intArray[i]=multiplication(i,out);
			intArray1[i]=0;
		}else{
			division(i,out,intArray,intArray1);
		}
			
		}

			 String word = "---------------��׼��--------------- "+"\n";
			  out.write(word.getBytes());
			  //��ȡ���������һ��
			  Scanner scanner0=new Scanner(file);
			  int i=0;
			  while(scanner0.hasNextLine()&&(i!=n)) {
				  if(intArray1[i]==0) {
				  word =(scanner0.nextLine())+intArray[i]+"\n";
				  }
				  else {
				  word =(scanner0.nextLine())+intArray[i]+"..."+intArray1[i]+"\n"; 
				  }
				  out.write(word.getBytes());
				  i++;
			  }
			  Date date1=new Date();
			  String str="yyyy��MM��dd�� HH:mm";
			  SimpleDateFormat sdf1 = new SimpleDateFormat(str);
			  String time="211605240 л����"+sdf1.format(date1)+"\n";
			  out.write(time.getBytes());
			  out.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

	}
	public static boolean Input(String[] args) {
		String regex="\\d*";
		if(args.length!=2) {//����������Ϊ���
			System.out.println("����Ĳ���ӦΪ��������");
		}
		else if((!args[0].matches(regex))||(!args[1].matches(regex))) {//���������벻Ϊ����
			System.out.println("����Ĳ���ӦΪ�����Ҳ�Ϊ-1");
			}
		else{String s = String.valueOf(args[0]);
		String s1=String.valueOf(args[1]);
		int n = Integer.parseInt(s);
		int grade =Integer.parseInt(s1);
		if(n<30 && (grade==1||grade==2)) {
			return true;
		}else {
			System.out.println("���������ӦС��30����ֻ��ѡ��һ�꼶���߶��꼶");
		}
		}
		return false;
	}
	public static void main(String[] args){
		// TODO �Զ����ɵķ������
		System.out.println("---------------��ӭʹ��MathExam5240����---------------");
		System.out.println("1.�밴�ո�ʽ�����롰��Ŀ���������֣�+�ո�+�꼶�����֣����� ����8 2���������Զ����ɶ��꼶�˵������⡣");
		System.out.println("2.�������һ�ο�����30�������⡣ѧϰ��һ��ѭ�򽥽��Ĺ��̣����˲�֮������");
		System.out.println("3.ʹ�ù������������޷������bug������ϵ���ͣ���ѻ��һ�װ˽��д���Ľ���");
		System.out.println("-----------------------------------------------------");
		if(Input(args)) {
			String s = String.valueOf(args[0]);
			String s1=String.valueOf(args[1]);
			int n = Integer.parseInt(s);
			int grade =Integer.parseInt(s1);
		try {
			math(n,grade);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		}
	}

}
