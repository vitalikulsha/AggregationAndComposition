package Task_04_Account;

/*
Поля класса: личный номер клиента (id), имя клиента (name), счета клиента (account[])
Методы: поиск счета по number, сортировка счета по number и balance, вывод в консоль списка счетов,
вычисление общей суммы по счетам,

 */

import java.util.Arrays;

public class Client {
    private long id;
    private String name;
    private Account[] account;

    public Client() {
    }

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(long id, String name, Account... account) {
        this.id = id;
        this.name = name;
        this.account = account;
    }

    //сортировка счетов по возрастания номеров
    public Account[] sortAccountNumber() {
        Arrays.sort(this.account, ComparatorAccount.NumberAccountComparator);
        return this.account;
    }

    //сортировка по балансу на счете
    public Account[] sortAccountBalance() {
        Arrays.sort(this.account, ComparatorAccount.BalanceAccountComparator);
        return this.account;
    }

    //поиск счета по номеру
    public void searchAccount(int num) {
        boolean test = true;
        for (Account acc : account) {
            if (num == acc.getNumber()) {
                test = false;
                System.out.println(acc.toString());
                break;
            }
        }
        if (test) {
            System.out.println("Счёт с номером " + num + " не найден.");
        }
    }

    //вычисление общей суммы по счетам
    public int sumMoney() {
        int sum = 0;
        for (Account acc : account) {
            sum += acc.getBalance();
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим положительный балансы.
    public int sumMoneyPositive() {
        int sum = 0;
        for (Account acc : account) {
            if (acc.getStatus()) {
                sum += acc.getBalance();
            }
        }
        return sum;
    }

    //вычисление суммы по всем счетам, имеющим отрицательные балансы.
    public int sumMoneyNegative() {
        int sum = 0;
        for (Account acc : account) {
            if (!acc.getStatus()) {
                sum += acc.getBalance();
            }
        }
        return sum;
    }

    //вывод в консоль массива счетов
    public void printAccount() {
        for (Account acc : account) {
            System.out.println(acc.toString());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccount() {
        return account;
    }

    public void setAccount(Account... account) {
        this.account = account;
    }

    @Override
    public String toString() {
        StringBuilder numAcc = new StringBuilder();
        for (Account acc : account) {
            numAcc.append("#" + acc.getNumber() + ", ");
        }
        return "Клиент: " +
                "id #" + id +
                ", имя '" + name + '\'' +
                ", номера счетов " + numAcc.substring(0, (numAcc.length() - 2)).toString() +
                '.';
    }
}
