package com.mycompany.bowlingscore;

import java.util.Scanner;

public class BowlingScorer {
    
    public int totalScore(String input) {
        int total = 0;
        int i = 0;
        if (input.equalsIgnoreCase("xxxxxxxxxx")) {
            return 300;
        }
        while (i < input.length()) {
            switch (input.charAt(i)) {
                case 'x':
                    total += 10;
                    if ((i + 1) < input.length()) {
                        switch (input.charAt(i + 1)) {
                            case 'x':
                                total += 10;
                                break;
                            case '-':
                                break;
                            default:
                                total += Integer.valueOf(String.valueOf(input.charAt(i + 1)));
                                break;
                        }
                        if ((i + 2) < input.length()) {
                            switch (input.charAt(i + 2)) {
                                case 'x':
                                    total += 10;
                                    break;
                                case '/':
                                    total += 10 - Integer.valueOf(String.valueOf(input.charAt(i + 1)));
                                    break;
                                case '-':
                                    break;
                                default:
                                    total += Integer.valueOf(String.valueOf(input.charAt(i + 2)));
                                    break;
                            }
                        }
                    }
                    break;
                case '/':
                    total += 10 - Integer.valueOf(String.valueOf(input.charAt(i - 1)));
                    if ((i + 1) < input.length()) {
                        switch (input.charAt(i + 1)) {
                            case 'x':
                                total += 10;
                                break;
                            case '-':
                                break;
                            default:
                                total += Integer.valueOf(String.valueOf(input.charAt(i + 1)));
                                break;
                        }
                    }
                    break;
                case '-':
                    break;
                default:
                    if (i == (input.length() - 1)) {
                        if (input.charAt(i - 1) != '/'){
                            if (input.charAt(i - 2) != 'x') {
                                total += Integer.valueOf(String.valueOf(input.charAt(i)));
                            }
                        }
                    } else if (i == (input.length() - 2)) {
                        if (input.charAt(i - 2) != 'x') {
                            total += Integer.valueOf(String.valueOf(input.charAt(i)));
                        }
                    } else {
                        total += Integer.valueOf(String.valueOf(input.charAt(i)));
                    }
                    break;
            }
            i++;
        }
        return total;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BowlingScorer bs = new BowlingScorer();
        System.out.println("Please enter the scores for each frame. Use x for a strike, / for "
                + "a spare, and - for a miss. Then press Enter.");
        
        String inputScore = scan.next();
        int total = bs.totalScore(inputScore);
        
        System.out.println("Your bowling score is: " + total);
    }
}
