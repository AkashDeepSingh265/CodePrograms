package com.practice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptFunction {
	public static void main(String[] args) throws ScriptException{
		ScriptEngineManager mgr = new ScriptEngineManager();
		
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    String foo = "40+2";
	    
	    System.out.println(engine.eval(foo));
	}
}
