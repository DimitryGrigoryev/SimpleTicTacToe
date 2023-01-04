package tictactoe;

import java.util.Scanner;

public class Main {

    private char[] arrayStr;

    public void setArrayStr() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        this.arrayStr = str.toCharArray();
    }

    public void setArrayStr(String initArea) {
        String str = initArea;
        this.arrayStr = str.toCharArray();
    }


    public void setCellArrayStr(char ch) {
        while (true) {
            Scanner s = new Scanner(System.in);
            int i = 0;
            int j = 0;
            try {
                i = s.nextInt();
                j = s.nextInt();
                if ((i < 1 || i > 3) || (j < 1 || j > 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (this.arrayStr[(j - 1) + 3 * (i - 1)] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    this.arrayStr[(j - 1) + 3 * (i - 1)] = ch;
                    break;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        this.printArea();
    }

    public void printArea() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(arrayStr[j + (3 * i)] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    private boolean checkWins(char ch) {
        boolean statusWin = false;
        if (arrayStr[0] == ch) {
            if (arrayStr[1] == ch) {
                if (arrayStr[2] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[0] == ch) {
            if (arrayStr[4] == ch) {
                if (arrayStr[8] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[0] == ch) {
            if (arrayStr[3] == ch) {
                if (arrayStr[6] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[1] == ch) {
            if (arrayStr[4] == ch) {
                if (arrayStr[7] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[2] == ch) {
            if (arrayStr[5] == ch) {
                if (arrayStr[8] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[2] == ch) {
            if (arrayStr[4] == ch) {
                if (arrayStr[6] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[3] == ch) {
            if (arrayStr[4] == ch) {
                if (arrayStr[5] == ch) {
                    statusWin = true;
                }
            }
        }
        if (arrayStr[6] == ch) {
            if (arrayStr[7] == ch) {
                if (arrayStr[8] == ch) {
                    statusWin = true;
                }
            }
        }
        return statusWin;
    }

    private int checkStatus() {
        String[] result = {"Game not finished", "Draw", "X wins", "O wins", "Impossible"};
        int indexRes = 0;
        int countX = 0;
        int countO = 0;
        boolean oWins = false;
        boolean xWins = false;

        for (char ch: arrayStr) {
            if (ch == 'X') countX++;
            if (ch == 'O') countO++;
        }
        if (Math.abs(countO - countX) >= 2) {
            indexRes = 4;
        } else {
            if (countX >= 3) xWins = checkWins('X');
            if (countO >= 3) oWins = checkWins('O');
            if (xWins && oWins) {
                indexRes = 4;
            } else if (xWins){
                indexRes = 2;
            } else if (oWins) {
                indexRes = 3;
            } else if (countX + countO == 9) {
                indexRes = 1;
            }
        }
        if (indexRes != 0)System.out.println(result[indexRes]);
        return indexRes;
    }

    private void playGame() {
        int statusGame = 0;
        int count = 0;
        while (statusGame == 0) {
            char ch = 'O';
            if (count % 2 == 0) ch = 'X';
            this.setCellArrayStr(ch);
            statusGame = this.checkStatus();
            count++;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Main playArea = new Main();
        playArea.setArrayStr("_________");
        playArea.printArea();
        playArea.playGame();
    }


}
