import java.util.concurrent.*;


public class Exam1{
    private static MoneyDeposit acct = new MoneyDeposit();
    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int k = 0;k <500;k++){
            executor.execute(new DepositAmt());
        }
        executor.shutdown();
        while (!executor.isTerminated()){
            System.out.println("Balance is " +acct.getBal());
        }
        private static class DepositAmt implements Runnable{
            public void run(){
                acct.deposit(1);
            }
        }
        private static class MoneyDeposit{
            private int balance = 0;
            public int getBal(){
                return balance;
            }
            public void deposit(int amount){
                int newBal = balance + amount;
                try{
                    Thread.sleep(10)
                }
                catch (InterruptedException ex){
                    balance = newBal;
                }
            }
        }

    }
}