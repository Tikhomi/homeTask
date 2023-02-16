package StepDefinition;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

public class DescriptionOfSteps {

    private int numA;
    private int numB;
    private int sum;

    @Дано("Пользователь вводит первое число {int}")
    public void ввод_числа_a(int a) {
        this.numA = a;
    }
    @Дано("Пользователь вводит второе число {int}")
    public void ввод_числа_b(int b){
        this.numB = b;
    }

    @Когда("Расчет суммы")
    public void расчет_суммы() {
        sum = numA + numB;
    }

    @Тогда("Вывод результата сложения {int}")
    public void вывод_суммы(int summa) {
        this.sum = summa;
        System.out.println(sum);
    }

}