package ParserAndLexers;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class EvaluateMathLexers {
	public static void main(String[] args){
//		Expression e1 = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
//        .variables("x", "y")
//        .build()
//        .setVariable("x", 2.3)
//        .setVariable("y", 3.14);
		Expression e = new ExpressionBuilder("192.30*203").build();
		double result = e.evaluate();
	}
}
