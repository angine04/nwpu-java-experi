public class String2Int {
    public static void main(String[] args) throws Exception {
        String[] str = new String[3];
        str[0] = "123";
        str[1] = "1ab";
        str[2] = "1.234";
        for (String string : str) {
            try {
                System.out.println(Integer.parseInt(string));
            } catch (NumberFormatException e) {
                System.out.println("Exception catched: " + e.getMessage());
            } finally {
                System.out.println("finally executed");
            }
        }
        
    }
}
