import java.util.Scanner;

public class Main {public static void main(String[] args) throws ScannerException {
    Converter converter = new Converter();
    String[] actions = {"+", "-", "/", "*"};
    String[] regexActions = {"\\+", "-", "/", "\\*"};
    Scanner scn = new Scanner(System.in);
    System.out.print("Введите выражение: ");
    String exp = scn.nextLine();
    if( exp.length() > 5) {
        throw new ScannerException("арифметическим выражение должно быть между двумя числами");
    }
    int actionIndex=-1;
    for (int i = 0; i < actions.length; i++) {
        if(exp.contains(actions[i])){
            actionIndex = i;
            break;
        }
    }
    if(actionIndex==-1){
        throw new ScannerException("Некорректное выражение");
    }
    String[] data = exp.split(regexActions[actionIndex]);

    if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
        int a,b;
        boolean isRoman = converter.isRoman(data[0]);
        if(isRoman){
            a = converter.romanToInt(data[0]);
            b = converter.romanToInt(data[1]);
        }else{
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
        }
        if(a < 1 || b > 10 || a > 10 || b<1 ){
            throw new ScannerException("нужно вводить от 1 до 10");
        }
        int result;
        switch (actions[actionIndex]){
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
            default:
                result = a/b;
                break;
        }
        if(isRoman){

            System.out.println(converter.intToRoman(result));
        }
        else{

            System.out.println(result);
        }
    }else{
        throw new ScannerException("Числа должны быть в одном формате");
    }


}
}




