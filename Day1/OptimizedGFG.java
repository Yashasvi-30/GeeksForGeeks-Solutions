



//{Driver Code Starts here 
//Initial Template for Java

import java.io.*;

class OptimizedGFG 
{

public static void main(String args[]) throws IOException 
{
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = 0;
    try {
        t = Integer.parseInt(read.readLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input for the number of test cases.");
        return;
    }

    while (t-- > 0) {
        String S = read.readLine();
        Solution ob = new Solution();
        System.out.println(ob.ExtractNumber(S));
    }
}
}


//  Driver Code Ends}
class Solution {
    long ExtractNumber(String sentence) {
        String[] tokens = sentence.split("\\s+"); // Splitting the sentence into tokens (words)
        long maxNumberWithout9 = -1; // Variable to store the maximum number without '9'
        
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) { // Check if the token starts with a digit
                long number = parseNumber(token); // Parsing the number from the token
                if (number != -1 && number > maxNumberWithout9) {
                    maxNumberWithout9 = number; // Updating maxNumberWithout9 if a larger valid number is found
                }
            }
        }
        
        return maxNumberWithout9; // Returning the largest valid number found
    }
    
    long parseNumber(String token) {
        long number = 0;
        boolean containsNine = false; // Flag to check if the number contains '9'
        
        for (char ch : token.toCharArray()) {
            if (ch == '9') {
                containsNine = true; // Set flag if '9' is found in the token
                break;
            }
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0'); // Building the number from digits
            }
        }
        
        return containsNine ? -1 : number; // Return -1 if '9' is found, otherwise return the parsed number
    }
}
