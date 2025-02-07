package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        // split the string using spaces, check the last character of each split string
        // is there a way to do this for all non-letter characters? -- regex pattern?
        String[] words = new String[input.split(" ").length];
        words = input.split(" ");
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].charAt(words[i].length()-1) == 'y' || words[i].charAt(words[i].length()-1) == 'z'){
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        // substring -- is there a way to remove a substring from a string?
        // find the indexes and then remove?
        // REPLACE METHOD
        return base.replace(remove, "");

    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){

        // is there a way to get a count of substrings?
        // is.count == not.count ? true : false
        // use .split().length again? -- won't work for notnot.
        // .replace? -- works, feels complicated? see if there's another way

        input = input.replace("not", "*");
        input = input.replace("is", "+");
        int isCount = 0;
        int notCount = 0;

        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '*'){
                notCount++;
            }
            else if(input.charAt(i) == '+'){
                isCount++;
            }
        }

        return isCount == notCount;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){

        boolean isHappy = false;
        // check g, if there's a g in the next index, i++ to go to the one after
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == 'g' && input.charAt(i+1) == 'g'){
                isHappy = true;
                i++;
            }
            else if(input.charAt(i) == 'g' && input.charAt(i++) != 'g'){
               isHappy = false;
               i++;
            }
        }
        return isHappy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

        // check if i, i+1, and i+2 are the same.
        int count = 0;

        // .length() - 2 because it'll get an out of index error
        for(int i = 0; i < input.length()-2; i++){
            if(input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)){
                count++;
            }
        }
        return count;
    }
}
