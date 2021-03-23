import java.util.function.Predicate;

public class Lambda_testing {
    static int p =8;
    public static void main(String[] args) {

        Operationable operation = (x,y)->{
            System.out.printf("%d + %d = ",x,y);
            p++;
            return x+y;
        };
        System.out.println(operation.calculate(5,8));
        Operationable operation1 = new Operationable() {
            //p++; не работает т.к. анонимные функции не видят
            @Override
            public int calculate(int a, int b) {
                System.out.printf("%d + %d = ",a,b);
                return a+b;
            }

        };
        System.out.println( operation1.calculate(32,50));
        Predicate<Integer> odd = x -> x%2 ==0;
        for(int i=0; i<=10;i++)
        {
            if(odd.test(i)){
                System.out.println(i);
            }
        }
        System.out.println("Main thread started...");
        Runnable r = ()->{
            System.out.printf("%s started... \n", Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("Thread has been interrupted");
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        };
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.printf("%s started... \n", Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }
                catch(InterruptedException e){
                    System.out.println("Thread has been interrupted");
                }
                System.out.printf("%s finished... \n", Thread.currentThread().getName());
            }
        };
        Thread myThread = new Thread(r,"MyThread");
        Thread myThread1 = new Thread(r1,"MyThread1");
        myThread.start();
        myThread1.start();
        System.out.println("Main thread finished...");
    }
}
