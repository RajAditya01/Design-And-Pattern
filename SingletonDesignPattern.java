public class SingletonDesignPattern {
    
    // Private static variable to hold the single instance of the class
    private static SingletonDesignPattern instance = null;
    
    // Private constructor to prevent instantiation of the class from outside
    private SingletonDesignPattern() {}
    
    // Public static method to get the single instance of the class
    public static SingletonDesignPattern getInstance() {
        // Check if the instance has already been created
        if (instance == null) {
            // Create a new instance of the class
            instance = new SingletonDesignPattern();
        }
        // Return the single instance of the class
        return instance;
    }
}
