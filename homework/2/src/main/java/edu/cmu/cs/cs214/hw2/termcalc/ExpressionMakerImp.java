package edu.cmu.cs.cs214.hw2.termcalc;

import edu.cmu.cs.cs214.hw2.expression.*;

/**
 * Class to implement ExpressionMaker and create a new Expression
 * @author YunZou
 *
 */
public class ExpressionMakerImp implements ExpressionMaker{

	/**
	 * @param addend1 the first addend of the sum
	 * @param addend2 the second addend of the sum
	 * @return
	 */
	@Override
	public Expression sumExpression(Expression addend1, Expression addend2) {
		Expression result = new SumExpression(addend1, addend2);
		return result;
	}

	/**
	 * @param op1 the first operand of the subtraction
	 * @param op2 the second operand of the subtraction
	 * @return
	 */
	@Override
	public Expression differenceExpression(Expression op1, Expression op2) {
		Expression result = new DifferenceExpression(op1, op2);
		return result;
	}

	/**
	 * @param factor1 the first factor of the multiplication
	 * @param factor2 the second factor of the multiplication
	 * @return
	 */
	@Override
	public Expression productExpression(Expression factor1, Expression factor2) {
		Expression result = new ProductExpression(factor1, factor2);
		return result;
	}

	/**
	 * @param dividend of the division
	 * @param divisor  of the division
	 * @return
	 */
	@Override
	public Expression divisionExpression(Expression dividend, Expression divisor) {
		Expression result = new DivisionExpression(dividend, divisor);
		return result;
	}

	/**
	 * @param base     of the exponentiation
	 * @param exponent of the exponentiation
	 * @return
	 */
	@Override
	public Expression exponentiationExpression(Expression base, Expression exponent) {
		Expression result = new ExponentiationExpression(base, exponent);
		return result;
	}

	/**
	 * @param operand the expression whose value will be returned with a negative sign
	 * @return
	 */
	@Override
	public Expression negationExpression(Expression operand) {
		Expression result = new NegationExpression(operand);
		return result;
	}

	/**
	 * @param value the expression that will be returned with a positive sign
	 * @return
	 */
	@Override
	public Expression absoluteValueExpression(Expression value) {
		Expression result = new AbsoluteValueExpression(value);
		return result;
	}

	/**
	 * @param value the number that this expression represents
	 * @return
	 */
	@Override
	public Expression numberExpression(double value) {
		Expression result = new NumberExpression(value);
		return result;
	}
}
