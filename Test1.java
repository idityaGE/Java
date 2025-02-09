
class Test1 {

    public static void main(String[] args) {
        // int x = y = z = 1; //! Error
        int x, y, z;
        x = y = z = 1;
        System.out.println(x + " " + y + " " + z);

        int a = 1;
        switch (a) {
            case 1:
                System.out.println("1");
                break;
            default:
                throw new AssertionError();
        }

    }
}
