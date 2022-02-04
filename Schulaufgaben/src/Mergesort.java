import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;

public class Mergesort {

    public static void main(String[] args) {
        int[] toSort = {1,5,7,8,34,12,11,56};
        merge_sort(toSort, toSort.length);

        System.out.println(Arrays.toString(toSort));
    }

    public static void  merge_sort(int[]a, int x){
        if(x < 2){
            return;
        }
        int mid = x / 2;
        int[] l = new int[mid];
        int[] r = new int[x - mid];

        System.arraycopy(a, 0, l, 0, mid);
        if (x - mid >= 0) System.arraycopy(a, mid, r, 0, x - mid);
        merge_sort(l, mid);
        merge_sort(r, x - mid);

        merge(a, l, r, mid, x - mid);
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    @Test
    public void successfulTest(){
        int[] toSort = {1,5,7,8,34,12,11,56};
        int[] Sorted = {1,5,7,8,11,12,34,56};
        merge_sort(toSort, toSort.length);
        Assert.assertArrayEquals(toSort,Sorted);
    }


}
