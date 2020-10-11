import java.util.Scanner;

class Calc {

  public static int funcNumbers(String number, String[] Arab, String[] Rome){//получение индекса
    int n = 0;
  for(int i = 0; i < Arab.length; i++){
      if (number.equals(Arab[i])){
        n = ++i;
        break;
      }
    }
  for(int i = 0; i < Rome.length; i++){
      if (number.equals(Rome[i])){
        n = i;
        break;
      }
    }
    return n;
  }

  public static void main(String[] args) {

    String[] Arab = {"1","2","3","4","5","6","7","8","9","10"};
    String[] Rome = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    Scanner in = new Scanner(System.in);
    System.out.println("Введите выражение:");
    String num = in.nextLine(); //запрос с консоли
    //String num = "V / II";

    String typesDigit = "";

    if (num.matches("^([1-9]|10)\\ [-+*\\/]\\ ([1-9]|10)$")){ //проверка для арабских
      typesDigit = "A";
    }
    else if (num.matches("^(I{1,3}|IV|VI{0,3}|I?X)\\ [-+*\\/]\\ (I{1,3}|IV|VI{0,3}|I?X)$")){
      typesDigit = "R";
    }
    else{
      System.out.println("Ошибка ввода!");
      System.exit(0);
    }

    String[] number = num.split("\\s");

    int number1 = funcNumbers(number[0], Arab, Rome); //получение индекса 1-го числа
    int number2 = funcNumbers(number[2], Arab, Rome); //получение индекса 2-го числа
    int ans = 0;
    int inTeger = 0;
    int fraction = 0;

    switch(number[1]){ //определение математического знака
      case "+":
        ans = number1 + number2;
        break;
      case "-":
        ans = number1 - number2;
        break;
      case "*":
        ans = number1 * number2;
        break;
      case "/":
        ans = number1 / number2;
        break;
      default:
        System.out.println("Какая-то ошибка");
        break;
    }

    inTeger = (int)Math.round(ans/10); //получение десятков
    fraction = ans % 10; //получение целых

    if (typesDigit == "A"){
      System.out.println(ans);
    }
    else if (typesDigit == "R"){//получение римских цифр
      if (ans > 0 && ans <= 10){
        System.out.println(Rome[(int)Math.round(ans)]);
      }
      else if (inTeger > 0 && inTeger < 4){
        System.out.println("X".repeat(inTeger) + Rome[fraction]);
      }
      else if (inTeger >= 4 && inTeger < 5){
        System.out.println("XL" + Rome[fraction]);
      }
      else if (inTeger >= 5 && inTeger < 9){
        System.out.println("L" + "X".repeat(inTeger - 5) + Rome[fraction]);
      }
      else if (inTeger >= 9 && inTeger != 10){
        System.out.println("XL" + Rome[fraction]);
      }
      else if (inTeger == 10) {System.out.println("C");}
      else {System.out.println("В системе римских цифр отсутствует ноль");}
    }
    else {
      System.out.println("Что то пошло не так:|");
    }
  }
}