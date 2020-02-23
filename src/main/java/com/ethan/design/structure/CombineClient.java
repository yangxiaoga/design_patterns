package com.ethan.design.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
 * 
 * 组合模式
 * 
 * 把部分和整体的干洗用树形结构表示，从而使客户端可以使用同一的方式处理
 * 部分对象和整体对象
 * 
 * 组合模式核心：
 *   抽象构件(Component)角色：定义【叶子】和【容器】构件的共同点 - AbstractFile
 *   叶子构件(Leaf)角色：无子节点 - ImageFile,TextFile
 *   容器构件(Composite)角色：有容器特征，可以包含子节点 - Folder
 * 
 * 场景：XML文件解析，OA系统中，组织结构处理
 *     Junit单元测试框架：TestCase(叶子)、TestUnite(容器)、Test接口 
 */
public class CombineClient {
	
	public static void main(String[] args) {
		new CombineClient().test();
	}
	
	void test() {
		
		AbstractFile img1,text1,img2,text2;
		Folder f1,f2;
		img1 = new ImageFile("图像1.jpg");
		img2 = new ImageFile("图像2.jpg");
		text1 = new TextFile("文本1.txt");
		text2 = new TextFile("文本2.txt");
		f1 = new Folder("文件夹1");
		f2 = new Folder("文件夹2");
		
		f2.add(text2);
		f2.add(img2);
		
		f1.add(img1);
		f1.add(text1);
		f1.add(f2);
		
		f1.killVirus();
		
	}
}

/** 抽象组件 - 抽象构件 - 文件 */
interface AbstractFile{
	void killVirus();//杀毒过程
}

/** 叶子 - 图像文件的查杀 */
class ImageFile implements AbstractFile{

	private String name;
	
	public ImageFile(String name) {
		this.name = name;
	}
	public void killVirus() {
		Pr.pr("--图像文件："+name+" 查杀过程");
	}
	
}

/** 叶子 - 文本文件的查杀 */
class TextFile implements AbstractFile{

	private String name;
	
	public TextFile(String name) {
		this.name = name;
	}
	public void killVirus() {
		Pr.pr("--文本文件："+name+" 查杀过程");
	}
	
}

/** 文件夹 - 容器构件 */
class Folder implements AbstractFile{

	private String name;
	
	public Folder(String name) {
		super();
		this.name = name;
	}

	//存储子节点
	private List<AbstractFile> value = new ArrayList<AbstractFile>();
	
	public void killVirus() {
		
		Pr.pr("--文件夹："+name+" 查杀过程");
		Iterator<AbstractFile> i = value.listIterator();
		
		/** 通过递归实现，如果是文件，则直接查杀;如果是子文件夹，则递归  */
		while(i.hasNext()) {
			i.next().killVirus();
		}
		
	}
	public void add(AbstractFile file) {
		value.add(file);
	}
	public void remove(AbstractFile file){
		value.remove(file);
	}
	public AbstractFile getChild(int index) {
		return value.get(index);
	}
}