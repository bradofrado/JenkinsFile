public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: [method] [...params]");
            return;
        }

        String method = args[0];
        Calculator calculator = new Calculator();
        int returnVal = 0;
        int arg1 = 0;
        int arg2 = 0;

        try {
            arg1 = parseArgs(args, 1);

            if (!isOneParamMethod(method)) {
                arg2 = parseArgs(args, 2);
            }
        } catch (IllegalArgumentException ex) {
            String params = isOneParamMethod(method) ? "[int]" : "[int] [int]";
            System.out.printf("Usage: %s %s\n", method, params);
            return;
        }

        switch(method) {
            case "add":
                returnVal = calculator.add(arg1, arg2);
                break;
            case "subtract":
                returnVal = calculator.subtract(arg1, arg2);
                break;
            case "multiply":
                returnVal = calculator.multiply(arg1, arg2);
                break;
            case "divide":
                returnVal = calculator.divide(arg1, arg2);
                break;
            case "fibonacci":
                returnVal = calculator.fibonacciNumberFinder(arg1);
                break;
            case "binary":
                String val = calculator.intToBinaryNumber(arg1);
                System.out.println(val);
                return;
            default:
                System.out.println("Useage: [method] [...params]");
                return;
        }

        System.out.println(returnVal);
    }

    private static int parseArgs(String[] args, int index) throws IllegalArgumentException {
        if (args.length <= index) {
            throw new IllegalArgumentException();
        }

        String str = args[index];

        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOneParamMethod(String method) {
        return method.equals("binary") || method.equals("fibonacci");
    }
}
