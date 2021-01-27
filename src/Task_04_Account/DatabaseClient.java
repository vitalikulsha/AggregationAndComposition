package Task_04_Account;

import java.util.Arrays;

class DatabaseClient {
    static Account account_00 = new Account(4040404, 10000);
    static Account account_01 = new Account(2020202, -20000);
    static Account account_02 = new Account(1010101, 10000);
    static Account account_03 = new Account(3030303, 1000000);
    static Account[] accounts = {account_00, account_01, account_02, account_03};

    //сортировка счетов по возрастания номеров
    static Account[] sortAccountsByNumber(Client client) {
        Arrays.sort(client.getAccounts(), ComparatorAccount.NumberAccountComparator);
        return client.getAccounts();
    }

    //сортировка по балансу на счете
    static Account[] sortAccountsByBalance(Client client) {
        Arrays.sort(client.getAccounts(), ComparatorAccount.BalanceAccountComparator);
        return client.getAccounts();
    }

    //поиск счета по номеру
    static Account searchAccountByNumber(int num, Client client) {
        Account foundAccount = null;
        for (Account account : client.getAccounts()) {
            if (num == account.getNumber()) {
                foundAccount = account;
                break;
            }
        }
        if (foundAccount == null) {
            System.out.println("Счёт с номером " + num + " не найден.");
        }
        return foundAccount;
    }

    //вычисление общей суммы по счетам
    static int sumMoney(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            sum += account.getBalance();
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим положительный балансы.
    static int sumMoneyPositive(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            if (account.getUnblocked()) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим отрицательные балансы.
    static int sumMoneyNegative(Client client) {
        int sum = 0;
        for (Account account : client.getAccounts()) {
            if (!account.getUnblocked()) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    //вывод в консоль массива счетов
    static void printAccount(Client client) {
        for (Account account : client.getAccounts()) {
            System.out.println(account.toString());
        }
    }
}
