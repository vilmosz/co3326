package co3326;

public interface User {
        
    public int[] send(User user, String message);
    
    public String receive(User user, int[] cipher);
       
}
