import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();
        StepTracker.MonthData monthData = stepTracker.new MonthData();
        while (userInput != 0) {
            if (userInput == 1) {
                stepTracker.changeStepsInMonth(scanner);
            }
            if (userInput==2)
            {
                stepTracker.printStats(scanner);
            }
            if (userInput == 3)
            {
                stepTracker.changeGoalInMonth(scanner);
            }
            if (userInput > 3 || userInput < 0)
            {
                System.out.println("Введите существующую команду");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
    }
    public static void printMenu()
    {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 – Ввести количество шагов за определенный день");
        System.out.println("2 – Напечатать статистику за определённый месяц");
        System.out.println("3 – Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
