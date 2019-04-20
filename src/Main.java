import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static boolean parity(ArrayList<Long> words) {
        if(words == null || words.isEmpty()) return false;

        boolean parity = false;
        boolean previous = parity(words.get(0));

        for(int i = 1; i < words.size(); i++) {
            boolean current = parity(words.get(i));
            if(previous && current || !previous && !current)
                parity = false;
            else if(previous && !current || !previous && current)
                parity = true;

            previous = current;
        }

        return parity;
    }

    public static boolean parity(long word) {
        String header = "Word: " + word + ", 1's count: ";
        //String bits = "";

        boolean parity = false;
        int count = 0;
        for(int i = 63; i >= 0; i--) {
            long mask = (1 << i);
            if((word & mask) > 0) {
                //bits += "1";
                count++;
            }
            else {
                //bits += "0";
            }

            //if(i % 4 == 0) bits += " ";
        }

        if(count % 2 == 0) parity = false;
        else parity = true;

        header += count + ", parity: " + parity;
        System.out.println(header);
        //System.out.println(bits);

        return parity;
    }


    public static void main(String[] args) {
        boolean p = false;

        int count = 0;
        int inputCount = 5;

        ArrayList<Long> inputs = new ArrayList();
        while(count++ < inputCount)
            inputs.add(new Random().nextLong());

        boolean result = parity(inputs);
        System.out.println("Parity result: " + result);
    }
}
