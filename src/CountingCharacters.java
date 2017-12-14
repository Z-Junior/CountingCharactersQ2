/**
 * @author Z
 * @since 13 December 2017
 */

import java.util.Scanner;

public class CountingCharacters
{
    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {
        count();
    }

    public static void count()
    {
        String sPhrase = PromptString("Enter a sentence: ");

        int iSpaces = sPhrase.length() - sPhrase.replaceAll(" ", "").length();
        int iAs = sPhrase.length() - sPhrase.replaceAll("(?i)a", "").length();
        int iEs = sPhrase.length() - sPhrase.replaceAll("(?i)e", "").length();
        int iSs = sPhrase.length() - sPhrase.replaceAll("(?i)s", "").length();
        int iTs = sPhrase.length() - sPhrase.replaceAll("(?i)t", "").length();

        System.out.println(String.format("Spaces: %d \r\nA's: %d\r\nE's: %d\r\nS's: %d\r\nT's: %d", iSpaces, iAs, iEs, iSs, iTs));

        if (PromptString("Enter another phrase? (Yes/no)").equalsIgnoreCase("yes"))
            count();
    }

    private static String PromptString(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextLine())
        {
            System.out.flush();

            System.out.print("Whole number only: ");

            SCAN.next();
        }

        return SCAN.nextLine();
    }
}
