package Task_04_Account;

/*
Поля класса: личный номер клиента (id), имя клиента (name), счета клиента (account[])
Методы: поиск счета по number, сортировка счета по number и balance, вывод в консоль списка счетов,
вычисление общей суммы по счетам,

 */

public class Client {
    private long id;
    private String name;
    private Account[] accounts;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client(long id, String name, Account... accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
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

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account... accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        StringBuilder numAcc = new StringBuilder();
        for (Account acc : accounts) {
            numAcc.append("#" + acc.getNumber() + ", ");
        }
        return "Клиент: " +
                "id #" + id +
                ", имя '" + name + '\'' +
                ", номера счетов " + numAcc.substring(0, (numAcc.length() - 2)).toString() +
                '.';
    }
}
