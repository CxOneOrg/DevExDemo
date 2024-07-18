
class xss_blank5 {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
    }

    public String runOsCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Command executed";
    }
}
