package AtmService;//기록 조회 서비스

public class Record {
    // 1->입금 2->출금 3->잔액조회
    private int serviceNum;
    // 입출금 금액
    private int amount;
    // 현재 잔고
    private int currentBalance;

    //constructor
    public Record(int num, int money, int curMoney) {
        serviceNum = num;
        amount = money;
        currentBalance = curMoney;
    }

    public int getNum() {
        return serviceNum;
    }
    public int getAmount() {
        return amount;
    }
    public int getCurrentBalance() {
        return currentBalance;
    }
}