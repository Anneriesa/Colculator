import java.util.logging.Logger;

// Calculator.java
public class Log {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    private Operation operation;

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ComplexNumber calculate(ComplexNumber a, ComplexNumber b) {
        logger.info("Calculating: " + a + " and " + b);
        ComplexNumber result = operation.execute(a, b);
        logger.info("Result: " + result);
        return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        ComplexNumber a = new ComplexNumber(4, 5);
        ComplexNumber b = new ComplexNumber(2, 3);

        calculator.setOperation(new Addition());
        calculator.calculate(a, b);

        calculator.setOperation(new Multiplication());
        calculator.calculate(a, b);

        calculator.setOperation(new Division());
        calculator.calculate(a, b);
    }
}
