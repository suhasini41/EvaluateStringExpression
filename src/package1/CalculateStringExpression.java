package package1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculateStringExpression 
{
	public static int evaluateStringExpression(String expression)
	{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("JavaScript");
		
		int s=0;
		try {
			s = (Integer) engine.eval(expression);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	
	@Test
	public void testCase1()
	{
		Assert.assertEquals(evaluateStringExpression("3+5*5-9/3"), 25);
	}
	
	@Test
	public void testCase2()
	{
		Assert.assertEquals(evaluateStringExpression("4*6-8/2+1"), 21);
	}
}


