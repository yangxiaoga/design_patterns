package com.ethan.design.regex;

import java.util.regex.Pattern;

/** 
 * 正则的学习 
 *   \n 换行
 *   \t 制表符
 *   \\ \本身
 *   \d :任意一个数字，0-9
 *   \D :非数字
 *   \w :任意一个字母，或数字，或下划线，A-Z, a-z,0-9，_.
 *   \W :除了字母，数字，下划线
 *   \s :包括空格，制表符，换行符，等空白字符的其中任意一个
 *   \S :非空白符号的其他字符
 *   . : 小数点可以匹配任意一个字符，不能匹配一个换行符
 *    
    【自定义字符集合】
 *    []方括号匹配方式，能够匹配方括号中任意一个字符
 *    [ab5@] ：配置a,或b,或5，或@
 *    [^abc]： 匹配 a,b,c之外的任意一个字符
 *    [f-k]：  匹配f-k之间的任意一个字符
 *    [^A-F0-3]：匹配A-F,0-3之外的任意一个字符
 * 
 *   特殊符号包含到[]则，失去特殊意义
 *   如[\d.\-+], .就表示一个.,如果需要，则得转义
 *  【量词】修饰匹配的次数
 *    {n}  :表达式重复n次 ,如\d{6}，\d\d{6}【七位】(\d\d){6}【12位】
 *    {m,n}:表达式至少重复m次，最多重复n次 ,非贪婪模式：匹配3次就好，\d{3,6}?
 *    {m,} :表达式至少重复m次
 *    ？ ：匹配表达式0次或者一次，相当于{0,1}，如 ：a\d?b,数字出现0或者1次
 *    +  : 表达式至少出现一次，相当于{1,}
 *    *  :表达式不出现或出现人任意次，相当于{0，}
 * 【字符边界】

 *   ^ : 与字符串开始的地方匹配  如：^i，以i开始
 *   $ : 与字符串结束的地方匹配  如：i$, 以i结尾
 *  \b : 匹配一个单词边界。左右不全是\w表示
 * 
 *  多行模式，每一行都是一个字符串，都有开头和结尾
 *  在多行模式下，只匹配开头或者结尾
 *   \A：单行 \Ai，以i开头
 *   \Z：单行 i\Z，以i结尾
 * 
 * 【选择符和分组】
 *   | ：左右两边表达式之间或关系，匹配左边或者右边，如：gao|zhang
 * （）：捕获组，每一个括号会分配一个编号.反向引用： ([a-z]{2})\1，找到的内容如gogo,toto,dodo
 * （?：Expressin）:非捕获组.加个?：，捕获组会进行存储，耗资源 (？：[a-z]{2})
 * 
 *  【预搜索（零宽断言）】
 *  (?=exp) :断言自身出现的位置的后面能匹配表达式exp
 *  (?<=exp) :断言自身出现的位置的前面能匹配表达式exp
 *  (?!exp) : 断言此位置的后面不能匹配表达式exp 
 *  (?<!exp):断言此位置的前面不能匹配表达式exp
 *   [a-z]+(?=ing):  going , doing eating,匹配到的是do,do,eat
 *   
 *  【电话号码的匹配】
 *   固话+手机号
 *   (0\d{2,3}- \d{7,9}|1[35789]\d{9})
 *   邮箱
 *   [\w\-]+@[a-z0-9A-Z]+(\.[a-zA-Z]{2,4}){1,2}    .com.cn重复两次
 */
public class PatternAndMatcher {
	
	public static void main(String[] args) {
		pattern();
	}
	public static void pattern() { 
		
		Pattern pattern = Pattern.compile("\\d{2,4}");
		java.util.regex.Matcher matcher = pattern.matcher("1a2b3$12");
		boolean flag = matcher.matches();//尝试整个序列与模式匹配
		System.out.println("是否匹配：" + flag);//false
		while(matcher.find()) {//查找下一个
			System.out.println(matcher.group());//返回找到的内容
		}
	}
}
