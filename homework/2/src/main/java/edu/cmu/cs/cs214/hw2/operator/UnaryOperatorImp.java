package edu.cmu.cs.cs214.hw2.operator;

/** 
 * UnaryOperator - an arithmetic operator with a single operand.
 *
 */
public enum UnaryOperatorImp implements UnaryOperator {
	/**
	 *
	 */
	NEGATION{
		/**
		 * @return
		 */
		@Override
		public String toString(){
			return "neg";
		}

		/**
		 * @param arg a number to apply the operator on
		 * @return
		 */
		@Override
		public double apply(double arg) {
			return -arg;
		}
	},
	/**
	 *
	 */
	ABS{
		/**
		 * @return
		 */
		@Override
		public String toString(){
			return "abs";
		}

		/**
		 * @param arg a number to apply the operator on
		 * @return
		 */
		@Override
		public double apply(double arg) {
			return Math.abs(arg);
		}
	}
}
