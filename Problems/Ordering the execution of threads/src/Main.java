class Invoker {

    public static void invokeMethods(Thread t1, Thread t2, Thread t3) throws InterruptedException {
        // start passed instances here
        t3.start();
        t2.start();
        t1.start();

        t3.interrupt();
        t2.interrupt();
        t1.interrupt();

        Thread.sleep(300);
    }
}