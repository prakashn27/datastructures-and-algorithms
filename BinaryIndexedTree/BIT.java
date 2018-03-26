import java.util.Arrays;

public class BIT {
    int[] array;

    BIT(int n) {
        array = new int[n+1];
    }
    public Integer rsq(int ind) {
        int sum = 0;
        while (ind > 0) {
            sum += array[ind];
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and decrementing ind by that number
            ind -= ind & (-ind);
        }

        return sum;
    }


    public void update(int ind, int value) {
        assert ind > 0;
        while (ind < array.length) {
            array[ind] += value;
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
            ind += ind & (-ind);
        }
        System.out.println(Arrays.toString(array));
    }
    public Integer rsq(int b, int a) {
        assert b >= a && a > 0 && b > 0;
        return rsq(b) - rsq(a - 1);
    }

    public static void main(String[] args) {
        BIT t = new BIT(6);
        t.update(1, 1);
        t.update(2, 2);
        t.update(3, 3);
        t.update(4, 4);
        t.update(5, 5);
        t.update(6,6);
        System.out.println(t.rsq(6, 3));
    }
}
