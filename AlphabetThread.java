public class AlphabetThread extends Thread {

    @Override
    public void run() {
        try {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                System.out.print(ch + " ");
                int randomSleep = (int) (Math.random() * 500); // random delay up to 0.5 sec
                Thread.sleep(randomSleep);
            }
        } catch (InterruptedException e) {
            System.out.println("\nThread interrupted!");
        }
    }

    public static void main(String[] args) {
        AlphabetThread thread = new AlphabetThread();
        thread.start();
    }
}
