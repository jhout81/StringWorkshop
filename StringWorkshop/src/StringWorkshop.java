import java.util.Scanner;

public class StringWorkshop {

    public static void main(String[] args) {
        //initializing variables
        Scanner in = new Scanner(System.in);
        //needed empty string to pass through functions when new content wasn't added
        String addedContent = "";
        String optionMenu;
        //user entered starting string to kick off program
        System.out.print("Enter a starting string: ");
        String noobPwnString = in.nextLine();
        System.out.println();
        optionMenu = """
                        
                Pick an option:
                1. Add content
                2. Check if string contains substring
                3. Output length
                4. Output substring after prefix
                5. Output substring before suffix
                6. Output substring between prefix and suffix
                7. Exit
                        """;

        System.out.print(optionMenu + ": ");
        int optionNumber = in.nextInt();
        //While loop for the different options
        while (optionNumber >= 1 && optionNumber < 7) {
            if (optionNumber == 1) {
                in.nextLine();
                System.out.print("Type in your content and press Enter: ");
                addedContent = in.nextLine();
                System.out.println();
                System.out.println("Current string: " + addContent(noobPwnString, addedContent));

            } else if (optionNumber == 2) {
                in.nextLine();
                System.out.print("Please type in a substring and hit enter: ");
                String subStrng = in.nextLine();
                System.out.println();
                System.out.println("Does the string contain " + "'" + subStrng + "'" + " true or false? " + containSubstring(noobPwnString, subStrng, addedContent));

            } else if (optionNumber == 3) {
                System.out.println("The length is: " + noobPwnStringLength(noobPwnString, addedContent));

            } else if (optionNumber == 4) {
                in.nextLine();
                System.out.print("Please enter a Prefix: ");
                String preFix = in.nextLine();
                System.out.println();
                System.out.println("Substring: " + prefixSub(noobPwnString, preFix, addedContent));

            } else if (optionNumber == 5) {
                in.nextLine();
                System.out.print("Please enter a Suffix: ");
                String suFfix = in.nextLine();
                System.out.println();
                System.out.println("Substring: " + suffixSub(noobPwnString, suFfix, addedContent));

            } else if (optionNumber == 6) {
                in.nextLine();
                System.out.print("Prefix: ");
                String preFix = in.nextLine();
                System.out.println();

                System.out.print("Suffix: ");
                String suFfix = in.nextLine();
                System.out.println();

                System.out.print("Substring: " + betweenSuffixPrefix(noobPwnString, suFfix, preFix, addedContent));
                System.out.println();
            }
            System.out.print(optionMenu + ": ");
            optionNumber = in.nextInt();
            System.out.println();
        }
        exitMessage(optionNumber);

    }

    //option 1 adds content to the original string and returns it
    public static String addContent(String original, String contentString) {
        original = original.concat(contentString);
        return original;
    }

    //option 2 checks if string contains user entered substring and returns true or false
    public static Boolean containSubstring(String original, String subWay, String contentString) {
        original = addContent(original, contentString);
        return original.toUpperCase().contains(subWay.toUpperCase());

    }

    //option 3 checks original string length if contentString is empty or outputs modified string length and returns length
    public static int noobPwnStringLength(String original, String contentString) {
        original = addContent(original, contentString);
        return original.length();
    }

    //option 4 returns substring after prefix
    public static String prefixSub(String original, String prefix, String contentString) {
        int afterPrefix;
        original = addContent(original, contentString);
        String originalUpper = original.toUpperCase();
        String prefixUpper = prefix.toUpperCase();
        //if substring is in string then afterPrefix gets the starting index at the end of the prefix to use
        if (containSubstring(original, prefix, contentString)) {
            afterPrefix = (originalUpper.indexOf(prefixUpper)) + prefix.length();
            return original.substring(afterPrefix);
        }
        return "No Substring";
    }

    //option 5 returns substring before suffix
    public static String suffixSub(String original, String suffix, String contentString) {
        int beforeSuffix;
        original = addContent(original, contentString);
        String originalUpper = original.toUpperCase();
        String suffixUpper = suffix.toUpperCase();
        //if substring is in string then beforeSuffix gets the right index parameter to print out substring
        if (containSubstring(original, suffix, contentString)) {
            beforeSuffix = originalUpper.indexOf(suffixUpper);
            return original.substring(0, beforeSuffix);
        }
        return "No Substring";
    }

    //option 6 returns substring between prefix and suffix
    public static String betweenSuffixPrefix(String original, String suff, String pref, String contentString) {
        int rightIndex;
        int leftIndex;
        original = addContent(original, contentString);
        String originalUpper = original.toUpperCase();
        String prefixUpper = pref.toUpperCase();
        String suffixUpper = suff.toUpperCase();
        //if there is a substring then this get the left index and right index and returns the substring using those index numbers as parameters
        if (containSubstring(original, pref, contentString) && containSubstring(original, suff, contentString)) {
            leftIndex = originalUpper.indexOf(prefixUpper) + pref.length();
            rightIndex = originalUpper.indexOf(suffixUpper);
            return original.substring(leftIndex, rightIndex);
        }
        return "One or more substrings were not present";

    }

    //option 7 to exit it's fun when you hit a number that is not 7 lol
    public static void exitMessage(int optionPicked) {
        if (optionPicked == 7) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("You hit some other bullshit other than 7 that exited the program GOODBYE!");
        }

    }
}
