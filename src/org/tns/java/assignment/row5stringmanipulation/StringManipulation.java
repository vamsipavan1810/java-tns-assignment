package org.tns.java.assignment.row5stringmanipulation;

import java.util.regex.Pattern;

public class StringManipulation {

    private StringManipulation() { }
    
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }
    
    public static String extractDomain(String email) {
        if (email == null || !email.contains("@")) {
            return "";
        }
        return email.substring(email.indexOf('@') + 1);
    }
    
    public static String camelToSnake(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : input.toCharArray()) {
        	if('A' <= ch && ch <= 'Z') {
        		sb.append('_');
        		sb.append((char)(ch + 'a' - 'A'));
        	} else sb.append(ch);
        }
        
        return sb.toString();
    }
    
    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=input.length()-1; i>=0; --i) {
        	sb.append(input.charAt(i));
        }
        
        return sb.toString();
    }
    
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        
        int left = 0;
        int right = input.length() - 1;
        while(left < right) {
        	char leftChar =  input.charAt(left);
        	char rightChar = input.charAt(right);
        	left++;
        	right--;
        	if(leftChar == rightChar) continue;
        	if(!Character.isAlphabetic(leftChar) || !Character.isAlphabetic(rightChar)) return false;
        	int dif = leftChar - rightChar;
        	if(dif != 'a' - 'A' && dif  != 'A' - 'a') return false;
        }
        return true;
    }
    
    public static void compareConcatenationPerformance() {
        int iterations = 10000;

        long start = System.nanoTime();
        @SuppressWarnings("unused")
		String str = "";

        for (int i = 0; i < iterations; i++) {
            str += i;
        }

        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            sb.append(i);
        }

        long builderTime = System.nanoTime() - start;

        System.out.println("  String (+) Time    : " + stringTime + " ns");
        System.out.println("  StringBuffer Time  : " + builderTime + " ns");
    }
    
    public static String getMultiLineText() {
        return """
                  Good Morning all,
                      My name is Vamsi Pavan. Nice to meet you all.

                  Regards,
                  Vamsi Pavan
                """;
    }
    
    public static String formatUserDetails(String name, int age, double salary) {
        return ".------------------------------------------.\n| Name: %s | Age: %d | Salary: %.2f |\n'------------------------------------------'"
                .formatted(name, age, salary);
    }
    
    public static void main(String[] args) {

    	System.out.println("Email validation:");
        String email = "john.doe@gmail.com";

        System.out.println("  Email Valid: " + isValidEmail(email));
        System.out.println("  Domain: " + extractDomain(email));

        String camelCase = "thinkNSolutions";
        System.out.println("Snake Case: \n  " + camelCase + " => " + camelToSnake(camelCase));

        String word = "vamsipavan";
        System.out.println("Reversed: \n  " + word + " => " + reverseString(word));
        String palinString1 = "%1abCDdcba1%";
        String palinString2 = "abcdcdba";
        System.out.println("Palindromes:");
        System.out.println("  " + palinString1 + "\t => " + isPalindrome(palinString1));
        System.out.println("  " + palinString2 + "\t => " + isPalindrome(palinString2));

        System.out.println("\nConcatinantion performance:");
        compareConcatenationPerformance();

        System.out.println("\nMultiLine Text Block:\n");
        System.out.println(getMultiLineText());

        System.out.println("String formatting:");
        System.out.println(
                formatUserDetails("Vamsi", 23, 50000.75)
        );
    }
}