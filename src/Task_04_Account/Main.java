package Task_04_Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  Task 04
4. Счета. Клиент может иметь несколько счетов в банке.
Учитывать возможность блокировки/разблокировки счета.
Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Client client = new Client(2021, "Иванов Иван Иванович");
        Account account_01 = new Account(2020202, -20000, client);
        Account account_02 = new Account(1010101, 10000, client);
        Account account_03 = new Account(3030303, 1000000, client);
        Account account_04 = new Account(4040404, 10000, client);
        client.setAccount(account_01, account_02, account_03, account_04);
        System.out.println(client.toString());
        int numAcc = readNumberAccount(reader);
        client.searchAccount(numAcc);
        System.out.println("Счета клиента '" + client.getName() + "' отсортированы по возрастанию номера:");
        client.sortAccountNumber();
        client.printAccount();
        System.out.println("Счета клиента '" + client.getName() + "' отсортированы по возрастанию баланса:");
        client.sortAccountBalance();
        client.printAccount();
        System.out.println("Сумма на счетах: " + client.sumMoney() + " у.е.");
        System.out.println("Сумма на счетах, имеющих положительный баланс: " + client.sumMoneyPositive() + " у.е.");
        System.out.println("Сумма на счетах, имеющих отрицательный баланс: " + client.sumMoneyNegative() + " у.е.");
    }

    public static int readNumberAccount(BufferedReader reader) throws IOException {
        int numAcc = 0;
        boolean test = true;
        while (test) {
            try {
                System.out.print("Введите номер счёта для поиска: #");
                numAcc = Integer.parseInt(reader.readLine());
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Номер счета введен некорректно: " + e);
                test = true;
            }
        }
        return numAcc;
    }
}
