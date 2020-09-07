package net.zicron.jol.logic;

public class MathTools {
    public static int roundBy32(int x){
        int counter1 = 0;
        int counter2 = 0;

        int xx = x;
        int xxx = x;

        while(xx % 32 != 0){
            xx++;
            counter1++;
        }

        while(xxx % 32 != 0){
            xxx--;
            counter2++;
        }

        if(counter2 > counter1){
            return xxx;
        }

        return xx;
    }
}
