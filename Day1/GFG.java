/* This is the first solution  the overall time complexity of the code 
can be approximated as O(t * n * m), 
where t is the number of test cases, 
n is the average length of the input sentence, 
and m is the average length of the tokens. */





//{Driver Code Starts here 
//Initial Template for Java

import java.io.*;

class GFG 
{

public static void main(String args[]) throws IOException 
{

BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(read.readLine());

while (t-- > 0) {
	String S = read.readLine();
	Solution ob = new Solution();
	System.out.println(ob.ExtractNumber(S));
}
}
}


//  Driver Code Ends}

class Solution 
{
    long ExtractNumber(String sentence)
     {
        String[] tokens = sentence.split("\\s+"); // Split by whitespace
        
        long maxNumberWithout9 = -1;
        
        for (String token : tokens) 
        {
            if (token.matches("\\d+")) { // Check if the token is a number
                long number = Long.parseLong(token);
                if (isValidNumber(number) && number > maxNumberWithout9) 
                {
                    maxNumberWithout9 = number;
                }
            }
        }
        
        return maxNumberWithout9;
    }
    
    boolean isValidNumber(long number) 
    {
        while (number > 0) 
        {
            long digit = number % 10;
            if (digit == 9) 
            {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
