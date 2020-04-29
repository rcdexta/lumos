package counting;

public class FrogJump {
    public int solution(int X, int Y, int D) {
        int totalDistance = Y - X;
        int steps = totalDistance / D;
        int remaining = totalDistance % D;
        if (remaining > 0) {
            steps++;
        }
        return steps;
    }
}
