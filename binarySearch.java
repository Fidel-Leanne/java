public class binarySearch {

    public static int binarySearch(int[] a, int left, int right, int x) {
        if (left < right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (x == a[mid]) {

            return mid;
        }

        if (x < a[mid]) {
            return binarySearch(a, left, mid - 1, x);
        }

        return binarySearch(a, left, mid + 1, x);
    }

}
