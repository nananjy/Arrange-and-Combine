package 包名;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求A(n, n)的所有排列之和 A(4, 1)+ A(4, 2)+ A(4, 3)+A(4, 4), 如果n=4
 * @author 作者名
 */
public class Arrange {
	
	public static void main(String[] args) {
		//1 输入待排列的字符串
		System.out.println("请输入一个字符串(只含a-z/A-Z)，回车结束：\n");
		Scanner scanner = new Scanner(System.in);
		String inString = scanner.nextLine();//获取输入字符串
		while (!inString.matches("^[A-Za-z]+$")) {
			System.out.println("含有非法字符，字符串只含a-z/A-Z，请重输：\n");
			inString = scanner.nextLine();
		}
		scanner.close();
		System.out.println("输入的字符串为：" + inString);
		//2 将字符串存放到List数组中
		List<String> data = new ArrayList<String>();
		String[] strings = inString.split("");
		for (String string : strings) {
			data.add(string);
		}
		//3 计算A(n,i)的排列，i表示待排列字符的个数
		Arrange arrange = new Arrange();
		for(int i = 1; i <= data.size(); i++) {
			arrange.getArrange(data,new ArrayList<String>(),i);
		}
	}
	
	/**
	 * 计算A(n,k)
	 * @param data 待排列的字符集合
	 * @param target 排列的结果
	 * @param k 排列后字符的个数
	 */
	public <E> void getArrange(List<E> data,List<E> target, int k) {
		List<E> copyData;//复制待排列的字符列表data
		List<E> copyTarget;//复制当前排列结果target
		if(target.size() == k) {
			for(E i : target) {
				System.out.print(i);
			}
			System.out.println();
			//已经找到k个字符的排列
			return;
		}
		//生成排列
		for(int i=0; i<data.size(); i++) {
			copyData = new ArrayList<E>(data);
			copyTarget = new ArrayList<E>(target);
			copyTarget.add(copyData.get(i));
			copyData.remove(i);
			//迭代，直到得到k个字符的排列
			getArrange(copyData, copyTarget, k);
		}
	}
}
