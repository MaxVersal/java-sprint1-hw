import java.util.Scanner;

public class StepTracker
{
    MonthData[] monthToData;
    int goal  = 10000;
    public StepTracker()
    {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++)
        {
            monthToData[i] = new MonthData();
        }

    }
    void printStats(Scanner scanner)
    {
        System.out.println("Введите номер месяца, за который хотите увидеть статистику:");
        int choice = scanner.nextInt();
        monthToData[choice].printStatistic(scanner);
    }
    void changeStepsInMonth(Scanner scanner)
    {
        System.out.println("Введите номер месяца, в котором хотите ввести количество шагов: ");
        int choice1 = scanner.nextInt();
        monthToData[choice1].changeSteps(scanner);
    }
    void changeGoalInMonth(Scanner scanner)
    {
        System.out.println("Введите номер месяца, в котором хотите изменить цель для дней: ");
        int choice3 = scanner.nextInt();
        monthToData[choice3].changeGoal(scanner);
    }

    class MonthData
    {

        int sum = 0;
        int[] day = new int[30];
        int[] goalForDay = new int[30];
        MonthData()
        {
            for (int i = 0 ; i < goalForDay.length; i++)
            {
                goalForDay[i] = 10000;
            }
        }
        void printStatistic(Scanner scanner) {
            for (int i = 0; i < day.length; i++) {
                System.out.println((i + 1) + " день: " + day[i] + ", ");
            }
            for (int i = 0; i < day.length; i++)
            {
                sum += day[i];

            }
            System.out.println("Общее количество шагов в месяце: " + sum);
            int middle;
            middle = sum/30;
            System.out.println("Среднее количество шагов: " + middle);
            int counter = 0;
            int bestLine = 0;
            for (int i =0; i< day.length; i++)
            {
                if (day[i] > goalForDay[i])
                {
                    counter++;
                }
                else if (day[i] < goalForDay[i])
                {
                    if (counter >= bestLine)
                    {
                        bestLine = counter;
                        counter = 0;
                    }
                }

            }
            System.out.println("Лучшая серия: " + bestLine);
            int distance = 0;
            Converter converter = new Converter();
            for (int i=0; i < day.length; i++)
            {
                distance += converter.convertDistance(day[i]);
            }
            System.out.println("Пройденная дистанция за месяц: " + distance);
            int quantityCcal = 0;
            for (int i =0; i < day.length; i++)
            {
                quantityCcal += converter.Ccal(day[i]);
            }
            System.out.println("Килокалории за месяц: " + quantityCcal);
        }

        void changeSteps(Scanner scanner)
        {
            System.out.println("Введите номер дня, в который хотите внести изменения по шагам: ");
            int userChoice  = scanner.nextInt();
            System.out.println("Введите количество шагов: ");
            int stepForDay = scanner.nextInt();
            day[userChoice - 1] = stepForDay;

        }
        void changeGoal(Scanner scanner)
        {
            System.out.println("введите новую цель: ");
            int newGoal = scanner.nextInt();
            for (int i = 0; i < goalForDay.length; i++)
            {
                goalForDay[i] = newGoal;
            }
        }
    }
}