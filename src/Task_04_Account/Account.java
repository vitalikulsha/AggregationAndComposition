package Task_04_Account;

/*
Поля класса: номер счета (number), сумма на счете (balance),
состояние счета (status): если сумма на счете отрицательная, то счет заблокирован (false),
если положительная - разблокирован (true)
 */
public class Account {
    private int number;
    private int balance;
    private boolean status;
    private Client client;

    public Account() {
    }

    public Account(int number, int balance) {
        this.number = number;
        this.balance = balance;
        this.status = balance < 0 ? true : false;
    }

    public Account(int number, int balance, Client client) {
        this.number = number;
        this.balance = balance;
        this.client = client;
        this.status = balance < 0 ? true : false;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        String statusAcc = status ? "заблокирован" : "разблокирован";
        return "Счёт: " +
                "номер #" + number +
                ", сумма средств " + balance +
                " у.е., состояние '" + statusAcc +
                "', имя клиента " + client.getName() +
                '.';
    }
}
