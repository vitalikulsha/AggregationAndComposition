package Task_04_Account;

/*
Поля класса: номер счета (number), сумма на счете (balance),
состояние счета (isUnblocked): если сумма на счете отрицательная, то счет заблокирован (false),
если положительная - разблокирован (true)
Метод, который будет снимать деньги withdraw и там проверять баланс и обновлять  isBlocked
 */
public class Account {
    private int number;
    private int balance;
    private boolean isUnblocked;

    public Account(int number, int balance) {
        this.number = number;
        this.balance = balance;
        this.isUnblocked = balance > 0 ? true : false;
    }

    //снятие денег со счета, обновление баланса и статуса счета
    public void withdraw(int amountMoney) {
        if (isUnblocked) {
            int newBalance = this.balance - amountMoney;
            System.out.println("Было снято " + amountMoney + " у.е. Остаток - " + newBalance + " у.е.");
            if (newBalance < 0) {
                System.out.println("Счет заблокирован.");
                this.isUnblocked = false;
            } else {
                this.isUnblocked = true;
            }
            this.balance = newBalance;
        } else {
            System.out.println("Счет заблокирован, нельзя снять деньги.");
        }
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

    public boolean getUnblocked() {
        return isUnblocked;
    }

    public void setUnblocked(boolean unblocked) {
        this.isUnblocked = unblocked;
    }

    @Override
    public String toString() {
        String statusAcc = isUnblocked ? "разблокирован" : "заблокирован";
        return "Счёт: " +
                "номер #" + number +
                ", сумма средств " + balance +
                " у.е., состояние '" + statusAcc + '\'';
    }
}
