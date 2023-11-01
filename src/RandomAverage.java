import java.util.Random;

public class RandomAverage{
    public static void main(String[] args) {
        Random random = new Random();
        int average = 0;
        boolean mode = true;
        while(true) {
            int rand = random.nextInt(1, 3);
            System.out.print(rand);
            average += rand;
        }
    }
}