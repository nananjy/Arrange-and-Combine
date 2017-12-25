package 包名;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求字符数组中k个元素的组合
 * 算法思想：递归
 * @author 作者名
 */
public class Combine {
	
	public static void main(String[] args) {
		//1 输入待组合的字符串，这里以字母a-z/A-Z为例
		System.out.println("请输入一个待组合的字符串(只含a-z/A-Z)，回车结束：\n");
		Scanner scanner = new Scanner(System.in);
		String inString = scanner.nextLine();//获取输入字符串
		while (!inString.matches("^[A-Za-z]+$")) {
			System.out.println("含有非法字符，字符串只含a-z/A-Z，请重输：\n");
			inString = scanner.nextLine();
		}
		System.out.println("输入的待组合字符串为：" + inString);
		//2 输入待组合的字符个数
		System.out.println("请输入一个正整数(正整数小于待组合字符串的长度)，回车结束：\n");
		String kString = scanner.nextLine();
		int k;//存放待组合的字符个数
		while (!kString.matches("^[0-9]*[1-9][0-9]*$") || (k = Integer.parseInt(kString)) > inString.length()) {//0*[1-9]\\d*
			System.out.println("输入错误，字符串是一个正整数且正整数小于待组合字符串的长度，请重输：\n");
			kString = scanner.nextLine();
		}
		System.out.println("输入的待组合字符个数为：" + k);
		scanner.close();
		//3 将待组合的字符存放到字符数组strings中
		String[] strings = inString.split("");
		//4 计算k个字符的组合
		combine(0, k, strings, new ArrayList<>());
	}
	
	/**
	 * 生成k个字符的组合
	 * @param <E> 待组合的字符类型
	 * @param index 数组com的索引
	 * @param k 待生成组合的字符个数
	 * @param com 存放所有字符的数组
	 * @param target 存放生成的组合
	 */
	public static <E> void combine(int index, int k, E []com, List<E> target) {
		if (k == 1) {
			for (int i = index; i < com.length; i++) {
				target.add(com[i]);
				//找到待生成的组合
				System.out.println(target.toString());
				target.remove((Object)com[i]);
			}
		} else if (k > 1) {
			for (int i = index; i <= com.length - k; i++) {
				//将第i个字符存放到待生成的组合target中
				target.add(com[i]);
				//递归，直到得到k个字符的组合
				combine(i + 1, k - 1, com, target);
				//包含第i个字符的组合已经输出完成，将其从List数组target中删除
				target.remove((Object)com[i]);
			}
		}
	}
}
