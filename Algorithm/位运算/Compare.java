import java.util.*;

/*
对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。若两数相同，返回任意一个。

给定两个整数a和b，请返回较大的数。
*/
public class Compare {

    public int getMax(int a, int b) {
        // write code here
		int c = a - b;
		//a的符号，as==1表示a为非负，as==0表示a为负
		int as = sign(a);
		//b的符号，bs==1表示b为非负，bs==0表示b为负
		int bs = sign(b);
		//a-b的符号
		int cs = sign(c);
		//表示a和b是否符号不相同，不相同为1，相同为0
		int difab = as ^ bs;
		//表示a和b是否符号相同，相同为1，不相同为0
		int sameab = flip(difab);

		int returnA = difab * as + sameab * cs;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
    }
	
	//取反的作用
	public int flip(int n) {
		return n ^ 1;
	}
	//获取某个整数的符号
	public int sign(int n) {
		return flip((n >> 31) & 1);
	}
}