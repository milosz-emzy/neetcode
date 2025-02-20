package codility;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
class FrogJump {
    public int solution(int X, int Y, int D) {
        // Implement your solution here
        int distance = Y - X;

        // jump 30, distance 60 ( 60 % 30 == 0)-> 2 jumps, no remainder of division no need for extra jump
        if(distance % D == 0) return (distance / D);

        //jump 30 distance 55 or 65 ->  distance % D != 0, so
        // 55 % 30 != 0 55 / 30 = 1, so it needs +1 jump, 65 % 30 != 0,
        // it needs +1 jump to jump over remainder of division
        return (distance / D ) + 1;
    }
}
