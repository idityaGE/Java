
class Test2 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        System.out.println(arr);

        int[][] arr2d = new int[3][];
        arr2d[0] = new int[2];
        arr2d[1] = new int[3];

        arr2d[0][0] = 1;

        System.out.println(arr2d);
        System.out.println(arr2d[0]);
        System.out.println(arr2d[0][0]);
        System.out.println(arr2d[0][1]);
        System.out.println(arr2d[2][0]); // Error: null pointer variable

    }
}
