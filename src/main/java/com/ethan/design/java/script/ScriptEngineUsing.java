package com.ethan.design.java.script;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Java中脚本的使用
 */
public class ScriptEngineUsing {
	
	public static void main(String[] args) 
			throws ScriptException, 
			NoSuchMethodException, IOException {
		useScriptEngine();
	}
	
	public static void useScriptEngine() throws ScriptException, NoSuchMethodException, IOException {
		ScriptEngineManager manager = new ScriptEngineManager();
		
		ScriptEngine engine = manager.getEngineByName("javascript");
		//定义变量，会存储到引擎上下文中
		engine.put("msg", "这是个常量");
	    String script = "var user = {name:'养',age:18,schools:['1','2']};";
	    script += "print(user.name);";
	    engine.eval(script);//养
		engine.eval("msg='update to new value';");
		System.out.println(engine.get("msg")); //update to new value
		
		/** 定义函数 */
		engine.eval("function add(a,b){var sum = a + b;return sum;}");
		/** 执行方法 */
		Invocable invoke = (Invocable)engine;
		Object result = invoke.invokeFunction("add", 1,2);
		System.out.println("相加结果："+result);
		
		/** 执行JS脚本文件 */
		URL url = ScriptEngineUsing.class.getClassLoader().getResource("engine.js");
		Reader reader = new FileReader(url.getPath());
		Object resultJS = engine.eval(reader);
		System.out.println("调用脚本相加结果："+resultJS);
		reader.close();
	}
	
}
