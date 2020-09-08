package AtmService;

public class Account {
    private int balance;
    // constructor
    public Account( int initialBalance ) {
        // initialBalance 가 0이 넘는지 확인
        if ( initialBalance > 0.0 ) {
            balance = initialBalance;
        }
    }
    // 입금
    public void deposit( int amount ) {
        balance = balance + amount;
    }
    // 출금
    public void withdraw( int amount ) {
        balance = balance - amount;
    }
    // 잔고 조회
    public int getBalance() {
        return balance;
    }
}
