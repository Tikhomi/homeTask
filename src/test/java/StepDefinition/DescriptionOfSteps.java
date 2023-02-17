package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class DescriptionOfSteps {

    private int numA;
    private int numB;
    private int sum;

    @Дано("Пользователь вводит первое число {int}")
    public int ввод_числа_a(int a) {
        this.numA = a;
        return numA;
    }
    @Дано("Пользователь вводит второе число {int}")
    public int ввод_числа_b(int b){
        this.numB = b;
        return numB;
    }

    @Когда("Расчет суммы")
    public int расчет_суммы() {
        int a = ввод_числа_a(23);
        int b = ввод_числа_b(36);
        sum = numA + numB;
        return sum;
    }

    @Тогда("Вывод результата сложения")
    public void вывод_суммы() {
        sum = расчет_суммы();
        System.out.println(numA + " + " + numB + " = " + sum);
    }

}