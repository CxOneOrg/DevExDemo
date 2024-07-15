
class xss_blank5 {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
    }

    // Method to display search term from a query parameter
    public static void displaySearchTerm(String searchTerm) {
        // Simulate displaying the search term on a resulting page
        System.out.println("Search Term: " + sanitizeInput(searchTerm));
    }

    // Method to sanitize input to prevent XSS attacks
    private static String sanitizeInput(String input) {
        return input.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
