/**
 * @author Jawaad Ahmar
 * This class is a central repository for the information about a WordLL game
 */

public class WordLL {

    // private instance variable of the class WordLL
    private Word mysteryWord;
    private LinearNode<Word> history;


    /**
     * constructor initializes an empty history
     * @param mystery is initialized to instance variable mysteryWord
     */
    public WordLL (Word mystery) {

        history = null;
        this.mysteryWord = mystery;
    }

    /**
     * method tests a word against this games’ mystery word
     * calls method labelWord from class Word
     * @param guess is the word being compared to the mysteryWord
     * @return true if the two words are identical
     */
    public boolean tryWord (Word guess) {

        guess.labelWord(mysteryWord);

        if (history == null) {
            history = new LinearNode<Word>(guess);
        } else {
            LinearNode<Word> temp = history;
            history = new LinearNode<Word>(guess);
            history.setNext(temp);
        }
        
        if (guess.labelWord(mysteryWord)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * produces a string representation of the past guesses
     * @Override
     */
    public String toString () {

        String toString = "";
        LinearNode<Word> curr = history;

        while (curr != null) {
            toString += curr.getElement().toString();
            curr = curr.getNext();
        }
        
        return toString;
    }

}
