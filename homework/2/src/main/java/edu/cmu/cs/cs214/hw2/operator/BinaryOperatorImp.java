package edu.cmu.cs.cs214.hw2.operator;

/**
 * BinaryOperator - an arithmetic operator with two oerpands.
 * 
 * @author zhilinh
 */
public enum BinaryOperatorImp implements BinaryOperator {
    /**
     *
     */
    ADDITION {
        /**
         * @return
         */
        @Override
        public String toString() {
            return "+";
        }

        /**
         * @param arg1 the first number before the operator
         * @param arg2 the second number after the operator
         * @return
         */
        @Override
        public double apply(double arg1, double arg2) {
            return arg1 + arg2;
        }
    },
    /**
     *
     */
    SUBTRACTION{
        /**
         * @return
         */
        @Override
        public String toString(){
            return "-";
        }

        /**
         * @param arg1 the first number before the operator
         * @param arg2 the second number after the operator
         * @return
         */
        @Override
        public double apply(double arg1, double arg2) {
            return arg1 - arg2;
        }
    },
    /**
     *
     */
    MULTIPLICATION {
        /**
         * @return
         */
        @Override
        public String toString(){
            return "*";
        }

        /**
         * @param arg1 the first number before the operator
         * @param arg2 the second number after the operator
         * @return
         */
        @Override
        public double apply(double arg1, double arg2) {
            return arg1 * arg2;
        }
    },
    /**
     *
     */
    DIVISION {
        /**
         * @return
         */
        @Override
        public String toString(){
            return "/";
        }

        /**
         * @param arg1 the first number before the operator
         * @param arg2 the second number after the operator
         * @return
         */
        @Override
        public double apply(double arg1, double arg2) {
            if (arg2 == 0) {
                throw new ArithmeticException("Denominator is zero");
            }
            return arg1 / arg2;
        }
    },
    /**
     *
     */
    EXPONENTIATION{
        /**
         * @return
         */
        @Override
        public String toString(){
            return "^";
        }

        /**
         * @param arg1 the first number before the operator
         * @param arg2 the second number after the operator
         * @return
         */
        @Override
        public double apply(double arg1, double arg2) {
            return Math.pow(arg1, arg2);
        }
    }
}
