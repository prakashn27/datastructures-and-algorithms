import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SegmentTree {
    int[] minArray;
    int size;
    int[] arr;
    SegmentTree(int[] a) {
        minArray = new int[4*a.length];
        size = a.length-1;
        arr = a;
        build(1, 0, size, a);
        System.out.println(Arrays.toString(minArray));
    }
    private int calLeft(int p) {
        return p*2;
    }
    private int calRight(int p) {
        return p*2 + 1;
    }
    private int build(int p, int l, int r, int[] a) {
        if(l > r) return -1;
        if(l == r) {
            minArray[p] = l;
            return minArray[p];
        }
        int left = build(calLeft(p), l, (l+r)/2, a);
        int right = build(calRight(p),(l+r)/2+1, r, a);
        if(left == -1) return right;
        if(right == -1) return left;
        minArray[p] = (a[left] < a[right]) ? left : right;
        return minArray[p];
    }
    private int rmq(int p, int l, int r, int i, int j) {
        if(i > r || j < l) return -1;
        if(l >= i && r <= j) return minArray[p];
        int left = rmq(calLeft(p), l, (l+r)/2, i, j);
        int right = rmq(calRight(p),(l+r)/2+1, r, i, j);
        if(left == -1) return right;
        if(right == -1) return left;
        return (arr[left] < arr[right]) ? left : right;
    }
    public int rmq(int i, int j) {
        return rmq(1, 0, size, i, j);
    }
    
    public static void main(String[] args) {
        int arr[] = { 2,5,1,4,9,3 };         // the original array
        SegmentTree st = new SegmentTree(arr);

        System.out.println("              idx   0, 1, 2, 3, 4, 5\n");
        System.out.println("              A is {2, 5, 1, 4, 9, 3}\n");
        System.out.println("RMQ(0, 3) = " + st.rmq(0, 3));             // answer = index 2a
        System.out.println("RMQ(0, 5) = " + st.rmq(0, 5));             // answer = index 2
        System.out.println("RMQ(3, 4) = " + st.rmq(3, 4));             // answer = index 3
        System.out.println("RMQ(4, 5) = " + st.rmq(4, 5));             // answer = index 5
    }

}
