import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
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
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Введите первое число ");
        double real1 = scanner.nextDouble();
        System.out.println("Введите второе число ");
        double imaginary1 = scanner.nextDouble();
        ComplexNumber a = new ComplexNumber(real1, imaginary1);

        System.out.println("Введите первое число ");
        double real2 = scanner.nextDouble();
        System.out.println("Введите второе число ");
        double imaginary2 = scanner.nextDouble();
        ComplexNumber b = new ComplexNumber(real2, imaginary2);

        System.out.println("Выберите действие(add, multiply, divide):");
        String operationType = scanner.next();
        Operation operation = OperationFactory.getOperation(operationType);
        calculator.setOperation(operation);

        ComplexNumber result = calculator.calculate(a, b);
        System.out.println("The result is: " + result);
    }
}
