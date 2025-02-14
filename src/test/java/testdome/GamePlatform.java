package testdome;

public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        for(int i : inclinations) {
            initialSpeed= (double )(-1 * i) + initialSpeed;
            System.out.println(initialSpeed);
        }
        return initialSpeed;
    }

    public static void main(String[] args){
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}