import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class MathExam1302 {
	public static void main(String[] args) {
		Bean bean = new Bean();
		bean.setArgsLength(args.length);
		bean.setQuizNumber(args[0]);// ���ó�����
		if (args.length == 2) {
			bean.setGrade(args[1]); // �����꼶��
		}
		long time1=0; long time2=0; long time=0; // ���������ַ���ƴ�ӻ��ѵ�ʱ��
		for (int n = 0; n < bean.getQuizNumber(); n++) {
			getSymbol(bean); // �����������
			//���������������������ŵĲ�ͬ�����ɷ��ض�Ӧ�Ķ���
			RandomNumber ran = RandomNumberFactory.createRan(bean.getSymbol());
			ran.createRandomAandB(bean);
			Operation oper = OperationFactory.createOperate(bean);
			oper.calculate();
			//����ƴ���ַ�������ʱ��
//			time1=System.currentTimeMillis();
			
			bean.setText();  //���ɴ洢��Ŀ�ʹ𰸵��ַ���
			
//			time2=System.currentTimeMillis();
//			time = time + (time2-time1);
			//ʱ����� end
		}
//		System.out.println(time);   //���ƴ���ַ�������ʱ��
		bean.setTxt();
		createMathExamTxt(bean);
	}

	private static void getSymbol(Bean bean) {
		Random ran = new Random();
		switch (bean.getGrade()) {
		case 1:
			// �������true��false����true��Ϊ��+������false��Ϊ��-��
			if (ran.nextBoolean()) {
				bean.setSymbol("+");
			} else {
				bean.setSymbol("-");
			}
			break;
		case 2:
			// �������true��false����true��Ϊ��*������false��Ϊ��/��
			if (ran.nextBoolean()) {
				bean.setSymbol("*");
			} else {
				bean.setSymbol("/");
			}
			break;
		}
	}

	private static void createMathExamTxt(Bean bean) {
		try {
			FileOutputStream fos = new FileOutputStream("out.txt");
			PrintStream ps = new PrintStream(fos);
			ps.println(bean.getTxt());
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
