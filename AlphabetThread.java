public class Main implements Runnable {
    private Thread t;
    private volatile boolean running;

    public void start() {
        if (running) return;
        running = true;
        t = new Thread(this);
        t.start();
    }

    public void stop() {
        running = false;
        if (t != null) t.interrupt();
    }

    @Override
    public void run() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder pool = new StringBuilder(letters);

        while (running && pool.length() > 0) {
            int i = (int) (Math.random() * pool.length());
            System.out.print(pool.charAt(i) + " ");
            pool.deleteCharAt(i);

            try {
                Thread.sleep(50 + (int) (Math.random() * 450));
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("\nDone");
        running = false;
    }

    public void join() {
        try {
            if (t != null) t.join();
        } catch (InterruptedException ignored) {}
    }

    public static void main(String[] args) {
        Main l = new Main();
        l.start();
        l.join();
    }
}

    public static void main(String[] args) {
        Main m = new Main();
        m.start();
    }
}
