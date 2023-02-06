
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        //ЗАДАНИЕ 1. Написать Predicate, который проверяет, является ли число положительным.
        // То есть, если число положительное, то предикат должен возвращать true, в противном случае false.
        System.out.println("Задание 1");
        Predicate<Integer> number = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(number.test(5));
        System.out.println(number.test(-1));

        Predicate<Integer> number1 = x -> x > 0;

        System.out.println(number1.test(5));
        System.out.println(number1.test(-1));
        System.out.println();

        //ЗАДАНИЕ 2. Создать Consumer, который будет принимать на вход имя человека и выводить в консоль его приветствие.
        System.out.println("Задание 2");

        Consumer<String> name1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, мое имя " + s);
            }
        };
        name1.accept("Igor");
        name1.accept("Jeremy");

        Consumer<String> name = n -> System.out.println("Привет! Мое имя " + n);
        name.accept("Lex");
        name.accept("Mark");
        System.out.println();

        // ЗАДАНИЕ 3. Реализовать функциональный интерфейс Function, который принимает на вход вещественное число типа Double,
        // а возвращает его округленный вариант типа Long.

        System.out.println("Задание 3");
        Function<Double, Long> x = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(x.apply(3.1));
        System.out.println(x.apply(4.8));
        System.out.println(x.apply(5.5));

        Function<Double, Long> x1 = j -> Math.round(j);

        System.out.println(x1.apply(3.33));
        System.out.println();

        //ЗАДАНИЕ 4. Написать Supplier, который будет возвращать случайное число от 0 до 100.
        System.out.println("Задание 4");
        Supplier<Integer> random = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(random.get());

        Supplier<Integer> rand = () -> (int) (Math.random() * 100);
        System.out.println(rand.get());
        System.out.println();

        //ЗАДАНИЕ 5.  Дан предикат condition и две функции ifTrue и ifFalse.
        // Напишите метод ternaryOperator, который из них построит новую функцию, возвращающую значение функции ifTrue,
        // если предикат выполнен, и значение ifFalse иначе.
        System.out.println("Задание 5");

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
    return     t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);}


}
