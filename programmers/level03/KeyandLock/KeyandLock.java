package programmers.level03.KeyandLock;

public class KeyandLock {
    public int[][] rightTurnKey(int[][] key) {
        int len = key.length;
        int[][] turnedKey = new int[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                turnedKey[j][len-1-i] = key[i][j];
            }
        }

        return turnedKey;
    }

    public void printTwoDimensionalArray(int[][] tdarr) {
        for(int i = 0; i < tdarr.length; i++) {
            for (int j = 0; j < tdarr.length; j++) {
                System.out.print(tdarr[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        KeyandLock kl = new KeyandLock();
        int[][] key = { {0,0,0},
                        {1,0,0},
                        {0,1,1}};
        int[][] turnedKey = new int[key.length][key.length];
        turnedKey = kl.rightTurnKey(key);
        kl.printTwoDimensionalArray(turnedKey);
        
    }
}
