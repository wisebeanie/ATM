//import AtmService.Account;
//
//import java.util.Scanner;
//
//public class AccountTest {
//    public static void main(String[] args) {
//        Account account1 = new Account( 50.00 );
//        Account account2 = new Account( 0.00 );
//
//        System.out.printf( "account1 balance: %.2f\n", account1.getBalance());
//        System.out.printf( "account2 balance: %.2f\n", account2.getBalance());
//
//        Scanner input = new Scanner( System.in );
//
//        //입금
//        double depositAmount;
//        System.out.printf( "Enter deposit amount for account1: ");
//        depositAmount = input.nextDouble();
//        System.out.printf("\nadding %.2f to account1 balance\n\n", depositAmount);
//        account1.deposit( depositAmount );
//        System.out.printf( "account1 balance: %.2f\n", account1.getBalance());
//        System.out.printf( "account2 balance: %.2f\n", account2.getBalance());
//
//        System.out.printf( "Enter deposit amount for account2: ");
//        depositAmount = input.nextDouble();
//        System.out.printf("\nadding %.2f to account2 balance\n\n", depositAmount);
//        account2.deposit( depositAmount );
//        System.out.printf( "account1 balance: %.2f\n", account1.getBalance());
//        System.out.printf( "account2 balance: %.2f\n", account2.getBalance());
//        //출금
//        double withdrawAmount;
//        System.out.printf( "\nEnter debit amount for account1: ");
//        withdrawAmount = input.nextDouble();
//        // 출금 금액 설정
//        if ( withdrawAmount > account1.getBalance() ) {
//            System.out.println( "Debit amount exceeded account balance." );
//        }
//        System.out.printf("\nsubtracting %.2f from account1 balance.\n", withdrawAmount );
//        account1.withdraw( withdrawAmount );
//
//        System.out.printf( "account1 balance: %.2f\n", account1.getBalance());
//        System.out.printf( "account2 balance: %.2f\n", account2.getBalance());
//
//        System.out.printf( "\nEnter debit amount for account2: ");
//        withdrawAmount = input.nextDouble();
//        // 출금 금액 설정
//        if ( withdrawAmount > account2.getBalance() ) {
//            System.out.println( "Debit amount exceeded account balance." );
//        }
//        System.out.printf( "account1 balance: %.2f\n", account1.getBalance());
//        System.out.printf( "account2 balance: %.2f\n", account2.getBalance());
//
//    }
//}
