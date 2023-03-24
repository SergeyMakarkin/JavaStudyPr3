import java.util.*;

public class Main {
    private static List<Passport> passportList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Макаркин Сергей Сергеевич РИБО-01-21");

        passportList.add(new Passport(445566, "Антонов Андрей Антонович", "сантехник", false));
        passportList.add(new Passport(112134, "Иванов Иван Иванович", "директор", true));
        passportList.add(new Passport(306306, "Яковлева Юлия Аристарховна", "секретарь", false));
        passportList.add(new Passport(654321, "Петров Петр Петрович", "программист", true));
        passportList.add(new Passport(777777, "Сидоров Сидор Сидорович", "бухгалтер", false));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить пропуск в список");
            System.out.println("2. Вывести список с сортировкой по ФИО");
            System.out.println("3. Вывести список с сортировкой по номеру пропуска");
            System.out.println("4. Завершить программу");
            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addPassport(passportList);
                    break;
                case "2":
                    printPassportListSortedByName();
                    break;
                case "3":
                    printPassportListSortedByNumber();
                    break;
                case "4":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }
    public static void printPassportListSortedByName() {
        List<Passport> sortedList = new ArrayList<>(passportList);
        sortedList.sort(Comparator.comparing(Passport::getFullName));
        System.out.println("Passport list sorted by name:");
        for (Passport passport : sortedList) {
            System.out.println(passport);
        }
    }

    public static void printPassportListSortedByNumber() {
        List<Passport> sortedList = new ArrayList<>(passportList);
        sortedList.sort(Comparator.comparingInt(Passport::getPassportNumber));
        System.out.println("Passport list sorted by number:");
        for (Passport passport : sortedList) {
            System.out.println(passport);
        }
    }
    public static void addPassport(List<Passport> passportList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер пропуска: ");
        int number = scanner.nextInt();
        System.out.print("Введите ФИО: ");
        scanner.nextLine();
        String fio = scanner.nextLine();
        System.out.print("Введите должность: ");
        String position = scanner.nextLine();
        System.out.print("Пропуск допускает на закрытую территорию (true/false): ");
        boolean access = scanner.nextBoolean();

        boolean found = false;
        for (int i = 0; i < passportList.size(); i++) {
            if (passportList.get(i).getPassportNumber() == number) {
                if (!passportList.get(i).getFullName().equals(fio)) {
                    System.out.println("Пропуск с таким номером уже существует, но ФИО отличаются.");
                    return;
                } else {
                    passportList.remove(i);
                    break;
                }
            }
        }

        passportList.add(new Passport(number, fio, position, access));
        System.out.println("Пропуск успешно добавлен.");
    }
}