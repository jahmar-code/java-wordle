/**
 * @author Jawaad Ahmar
 * This class represents a word in the game that is comprised of any number of letters
 */

public class Word {

    // private instance variable of the class Word
    private LinearNode<Letter> firstLetter;

    
    /**
     * constructor creates a linked list from the given paramater
     * @param letters is the array that is converted into a linked list
     */
    public Word (Letter[] letters) {

        LinearNode<Letter> temp = null;

        for (int i = 0; i <  letters.length; i++) {
            LinearNode<Letter> obj = new LinearNode<Letter>(letters[i]);
            if (temp != null) {
                temp.setNext(obj);
            } else {
                firstLetter = obj;
            }
            temp = obj;
        }
    }

    /**
     * this method returns a string representation of the word of this class
     * @Override
     */
    public String toString () {
        
        String toString = "";

        LinearNode<Letter> word_curr = this.getFirstLetter();
        toString += "Word: ";
        while (word_curr != null) {
            toString += word_curr.getElement().toString() + " ";
            word_curr = word_curr.getNext();
        }

        return toString;
    }
    
    /**
     * helper method
     * @return the first object of linked list
     */
    private LinearNode<Letter> getFirstLetter () {

        return firstLetter;
    }

    /**
     * helper method
     * @return the length of the word of this class
     */
    private int getWordLength () {

        LinearNode<Letter> word_curr = this.getFirstLetter();
        int j = 0;

        while (word_curr != null) {
            word_curr = word_curr.getNext();
            ++j;
        }

        return j;
    }

    /**
     * helper method deletes decorator values from a word
     * @param wordtype is the word to be reset 
     */
    private void reset(Word wordtype) {

        LinearNode<Letter> curr = wordtype.getFirstLetter();

        while (curr != null) {
            String str = curr.getElement().toString();
            String substring = str.substring(1, str.length() - 1);
            char c = substring.charAt(0);
            LinearNode<Letter> obj = new LinearNode<Letter>(new Letter(c));
            curr.setElement(new Letter(c));
            curr = curr.getNext();
        }
    }

    /**
     * compares this word to a mystery word
     * @return true if this word and mystery word are identical
     */
    public boolean labelWord (Word mystery) {

        LinearNode<Letter> mystery_curr = mystery.getFirstLetter();
        LinearNode<Letter> word_curr = this.getFirstLetter();

        if (!(mystery_curr.getElement() instanceof ExtendedLetter)) {
            reset(mystery);
            reset(this);
        } 
        
        boolean labelWord_return = false;
        mystery_curr = mystery.getFirstLetter();

        while (mystery_curr != null) {
            word_curr = this.getFirstLetter();
            while (word_curr != null) {
                    String word = word_curr.getElement().toString();
                    String substring = word.substring(0,1);
                if (word_curr.getElement().equals(mystery_curr.getElement())) {
                    word_curr.getElement().setUsed();
                    word_curr = word_curr.getNext();
                } else if (substring.equals("+")){
                    word_curr = word_curr.getNext();
                } else {
                    word_curr.getElement().setUnused();
                    word_curr = word_curr.getNext();
                }
            }
            mystery_curr = mystery_curr.getNext();
        }

        mystery_curr = mystery.getFirstLetter();
        word_curr = this.getFirstLetter();
        int k = 0;

        while ((mystery_curr != null) && (word_curr != null)) {

            String word = word_curr.getElement().toString();
            String substring = word.substring(1, word.length() - 1);
            String mysterWord = mystery_curr.getElement().toString();
            String substring2 = mysterWord.substring(1, mysterWord.length() - 1);

            if (substring.equals(substring2)) {
                word_curr.getElement().setCorrect();
                word_curr = word_curr.getNext();
                mystery_curr = mystery_curr.getNext();
                ++k;
            } else {
                word_curr = word_curr.getNext();
                mystery_curr = mystery_curr.getNext();
                
            }
        }

        if (k == this.getWordLength()) {

            labelWord_return = true;
        }

        return labelWord_return;  
    }
}
