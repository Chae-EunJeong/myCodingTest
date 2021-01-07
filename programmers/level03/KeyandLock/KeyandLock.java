package programmers.level03.KeyandLock;

public class KeyandLock {
    /* check every chances to open using functions */
    public boolean checkEveryChances(int[][] key, int[][] lock) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            check = openLockWithKey(key, lock);
            if (check) {
                break;
            }
            key = rightTurnKey(key);
            printTwoDimensionalArray(key);
        }
        return check;
    }

    /* make key array to right turn */
    public int[][] rightTurnKey(int[][] key) {
        int len = key.length;
        int[][] turnedKey = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                turnedKey[j][len-1-i] = key[i][j];
            }
        }

        return turnedKey;
    }

    /* padding lock array into (2*N + 1)size */
    public int[][] paddingLockArray(int[][] lock) {
        int n = lock.length;
        int[][] zeroPaddingArray = new int[2*n+1][2*n+1];
        int lockIndexRow = 0;
        int lockIndexCol = 0;

        for (int i = n-1; i < 2*n-1; i++) {
            for (int j = n-1; j < 2*n-1; j++) {
                zeroPaddingArray[i][j] = lock[lockIndexRow][lockIndexCol++];
            }
            lockIndexRow++;
            lockIndexCol = 0;
        }
        return zeroPaddingArray;
    }

    /* add key to the padding lock array */
    public boolean openLockWithKey(int[][] key, int[][] lock) {
        int[][] paddingLockArr = paddingLockArray(lock);
        int n = paddingLockArr.length;
        int m = key.length;
        int[][] lockKeyArray = new int[n][n];
        lockKeyArray = copyTwoDimensionalArray(paddingLockArr);
        boolean check = false;

        for (int i = 0; i < 2*m - 1; i++) {
            for (int j = 0; j < 2*m - 1; j++) {
                for (int k = 0; k < m; k++) {
                    for(int l = 0; l < m; l++) {
                        lockKeyArray[i+k][j+l] += key[k][l];
                    }
                }
                printTwoDimensionalArray(lockKeyArray);
                System.out.println();
                check = isLockOpenOrNot(lock, lockKeyArray);
                if (check) {
                    return check;
                }
                lockKeyArray = copyTwoDimensionalArray(paddingLockArr);
            }
        }

        return check;
    }

    /* check all element is 1 in origin part of lock array */
    public boolean isLockOpenOrNot(int[][] lock, int[][] lockKeyArray) {
        boolean check = true;
        int n = lock.length;

        for (int i = n-1; i <= 2*n-2; i++) {
            for (int j = n-1; j <= 2*n-2; j++) {
                if (lockKeyArray[i][j] != 1) {
                    check = false;
                }
            }
        }

        return check;
    }

    /* printing two dimensional array */
    public void printTwoDimensionalArray(int[][] tdarr) {
        for (int i = 0; i < tdarr.length; i++) {
            for (int j = 0; j < tdarr.length; j++) {
                System.out.print(tdarr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /* deep copy two dimensional array - using arraycopy for not using for loop twice */
    public int[][] copyTwoDimensionalArray(int[][] tdarr) {
        int len = tdarr.length;
        int[][] copyArray = new int[len][len];
        for(int i = 0; i < len; i++) {
            System.arraycopy(tdarr[i], 0, copyArray[i], 0, len);
        }
        return copyArray;
    }

    public static void main(String[] args) {
        KeyandLock kl = new KeyandLock();
        int[][] key = { {0,0,0},
                        {1,0,0},
                        {0,1,1}};
        int[][] lock = {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        System.out.println(kl.checkEveryChances(key, lock));
    }
}
