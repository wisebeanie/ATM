package AtmService;

// 고객 이용 화면
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    public static void main(String[] args) {
        // 서비스 이용 유무
        char otherService = 'Y';
        // 기록
        ArrayList<Record> transaction = new ArrayList<Record>();
        // 초기 계좌 잔고 설정
        Account myAccount = new Account( 500000 );
        System.out.printf( "고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );

        // 만원권 1000장
        int ten = 1000;
        // 오만원권 200장
        int five = 200;

        while ( otherService == 'Y') {
            System.out.println( "\n1. 입금" );
            System.out.println( "2. 출금" );
            System.out.println( "3. 예금 조회" );

            // input
            Scanner input = new Scanner( System.in );
            System.out.printf( "원하시는 서비스의 번호를 입력해주세요: ");
            int service = input.nextInt();

            // 입금
            if (service == 1) {
                // 입금 금액
                int depositAmount;
                System.out.printf( "\n입금 금액을 입력해주세요: " );
                depositAmount = input.nextInt();
                System.out.printf( "\n%d 원을 입금합니다. \n\n", depositAmount );
                myAccount.deposit( depositAmount );
                // !입금 금액
                // 기록 저장
                Record record = new Record(1, depositAmount, myAccount.getBalance());
                transaction.add(record);
                // !기록 저장
                System.out.printf( "고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );

                System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                otherService = input.next().charAt(0);
            }
            // !입급
            // 출금
            else if ( service == 2 ) {
                // 출금 금액
                int withdrawAmount;
                System.out.printf( "\n출금 금액을 입력해주세요: ");
                withdrawAmount = input.nextInt();
                // 출금 금액 설정 (10000원, 50000원)
                while ( withdrawAmount % 10000 != 0 && withdrawAmount % 50000 != 0 ) {
                    System.out.println( "출금 금액은 10000원이나 50000원 권으로만 가능합니다" );
                    System.out.printf( "\n출금 금액을 입력해주세요: ");
                    withdrawAmount = input.nextInt();
                }
                // !출금 금액 설정
                // 잔액 부족시
                if ( withdrawAmount > myAccount.getBalance() ) {
                    System.out.printf( "출금 금액이 부족합니다\n고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );
                    System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                    otherService = input.next().charAt(0);
                    continue;
                }
                // !잔액 부족
                // 지폐 개수 계산
                String dollor;
                System.out.printf( "만원과 오만원 중 하나를 선택해주세요: ");
                dollor = input.next();

                // 만원 권 출금
                if (dollor == "만원") {
                    // 지폐가 없을 경우
                    if (withdrawAmount / 10000 > ten) {
                        System.out.println( "지폐가 부족합니다.");
                        System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                        otherService = input.next().charAt(0);
                        continue;
                    }
                    else {
                        System.out.printf("\n%d 원을 출금합니다. \n\n", withdrawAmount);
                        myAccount.withdraw(withdrawAmount);
                        // 지폐 수 차감
                        ten = ten - withdrawAmount / 10000;

                        // 기록 저장
                        Record record = new Record(2, withdrawAmount, myAccount.getBalance());
                        transaction.add(record);
                        // !기록 저장
                        System.out.printf( "고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );
                        System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                        otherService = input.next().charAt(0);
                    }
                }
                // 5만원 권 출금
                else {
                    if (withdrawAmount / 50000 > five) {
                        System.out.println( "지폐가 부족합니다.");
                        System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                        otherService = input.next().charAt(0);
                        continue;
                    }
                    else {
                        System.out.printf("\n%d 원을 출금합니다. \n\n", withdrawAmount);
                        myAccount.withdraw(withdrawAmount);
                        // 지폐 수 차감
                        five = five - withdrawAmount / 50000;

                        // 기록 저장
                        Record record = new Record(2, withdrawAmount, myAccount.getBalance());
                        transaction.add(record);
                        // !기록 저장
                        System.out.printf( "고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );
                        System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                        otherService = input.next().charAt(0);
                    }
                }
                // !지폐 수 계산
            }
            // !출금
            // 잔액 조회
            else if ( service == 3 ) {
                System.out.printf( "\n고객님의 현재 잔액은 %d 원입니다\n", myAccount.getBalance() );
                System.out.printf( "다른 서비스를 이용하시겠습니까? (Y/N): ");
                otherService = input.next().charAt(0);
            }
            // !잔액 조회
        }

        // 기록 조회
        System.out.println( "\n업무 내용입니다" );
        for (Record i : transaction) {
            // 입금 업무
            if (i.getNum() == 1) {
                System.out.printf( "입금: %d원 잔액: %d원\n", i.getAmount(), i.getCurrentBalance());
            }
            // !입금 업무
            // 출금 업부
            else if (i.getNum() == 2) {
                System.out.printf( "출금: %d원 잔액: %d원\n", i.getAmount(), i.getCurrentBalance());
            }
            // !출금 업무
        }
        //! 기록 조회
        System.out.println( "이용해 주셔서 감사합니다" );
    }
}
