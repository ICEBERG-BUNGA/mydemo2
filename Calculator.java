import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ScannerException {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        if( exp.length() > 3) {
            throw new ScannerException("строка содержит больше трех символов");
        }
        //Определяем арифметическое действие:
        int actionIndex=-1;
        for (int i = 0; i < actions.length; i++) {
            if(exp.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу

        if(actionIndex==-1){
            throw new ScannerException("Некорректное выражение");
        }
        //Делим строчку по найденному арифметическому знаку


        String[] data = exp.split(regexActions[actionIndex]);
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int a,b;

            //Определяем, римские ли это числа
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                //если римские, то конвертируем их в арабские
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                //если арабские, конвертируем их из строки в число
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if(a < 1 || b > 10 || a > 10 || b<1 ){
                throw new ScannerException("нужно вводить от 1 до 10");
            }

            //выполняем с числами арифметическое действие
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
                //если числа были римские, возвращаем результат в римском числе
                System.out.println(converter.intToRoman(result));
            }
            else{
                //если числа были арабские, возвращаем результат в арабском числе
                System.out.println(result);
            }
        }else{
            throw new ScannerException("Числа должны быть в одном формате");
        }


    }
}

