package test;

class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final MyData data = new MyData();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                public void run() {
                    data.add();

                }

            }).start();
            new Thread(new Runnable() {

                public void run() {
                    data.dec();

                }

            }).start();
        }
    }

}

class MyData {
    private int j = 0;

    public synchronized void add() {
        j++;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println("线程" + Thread.currentThread().getName() + "j为：" + j);
    }

}
