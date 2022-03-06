/**
 * @author Jawaad Ahmar
 * This class represents a single letter in the game
 */

public class Letter {
    
    // private instance variable of class Letter
    private char letter;
    private int label;
    private int UNSET = -1;
    private int UNUSED = 0;
    private int USED = 1;
    private int CORRECT = 2;


    /**
     * constructor initializes label to UNSET
     * @param c is the letter being initialized
     */
    public Letter (char c) {

        this.label = UNSET;
        this.letter = c;
    }

    /**
     * equals method checks if two letter objects have the same contents
     * @Override
     * @param otherObject is the otherObject being compared
     */
    public boolean equals (Object otherObject) {
        
        boolean equals_return = false;

        if (otherObject instanceof Letter) {
            if (this.letter == ((Letter)otherObject).letter) {
                equals_return = true;
            } 
        } else {
            equals_return = false;
        }
        
        return equals_return;
    }

    /**
     * @return a string value based on the value of label
     */
    public String decorator () {
        
        String decorator_return = "";

        if (label == USED) {
            decorator_return = "+";
        }

        if (label == UNUSED) {
            decorator_return = "-";
        }

        if (label == CORRECT) {
            decorator_return = "!";
        }

        if (label == UNSET) {
            decorator_return = " ";
        }

        return decorator_return;
    }

    /**
     * toString method decorates letter based on the value returned by decorator
     * @Override
     */
    public String toString () {

        return decorator() + this.letter + decorator();
    }

    /**
     * mutator sets label to UNUSED
     */
    public void setUnused () {

        label = UNUSED;
    }

    /**
     * mutator sets label to USED
     */
    public void setUsed () {

        label = USED;
    }

    /**
     * mutator sets label to CORRECT
     */
    public void setCorrect () {

        label = CORRECT;
    }

    /**
     * method checks if label us UNUSED
     */
    public boolean isUnused () {

        if (label == UNUSED) {
            return true;
        }

        return false;
    }

    /**
     * this method creates an aray of objects of the class Letter
     * @param s is the string that the array is created from
     * @return array of objects of the class Letter
     */
    public static Letter[] fromString (String s) {
        
        Letter[] letterArray = new Letter[s.length()];
        char[] chars = s.toCharArray();
        
        for (int i=0; letterArray.length > i; ++i) {
            letterArray[i] = new Letter(chars[i]);
        }

        return letterArray;
        
    }
}
