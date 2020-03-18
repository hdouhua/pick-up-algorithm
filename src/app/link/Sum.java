package app.link;

/**
 * Sum: to understand recursive algorithm
 */
public class Sum {

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    /**
     * sum (arr[0..n]) = arr[0] + sum(arr[1..n]) 
     * => arr[l] + sum(arr[l..n])
     * => l ==n 
     * @param arr
     * @param l
     * @return
     */
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 6, 7 };
        System.out.println(sum(arr));
    }
}