import java.util.*;

public class DS2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        int i = 0; // pointer for players
        int j = 0; // pointer for trainers

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                // Match found, move both pointers
                count++;
                i++;
                j++;
            } else {
                // Current trainer can't train this player, try next trainer
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DS2410 ds2410 = new DS2410();
        int[] players = { 1, 2, 3 };
        int[] trainers = { 2, 3, 4 };
        System.out.println(ds2410.matchPlayersAndTrainers(players, trainers)); // Output: 3
    }
}
