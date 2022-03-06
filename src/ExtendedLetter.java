/**
 * @author Jawaad Ahmar
 * This class is a subclass of Letter and extends its fuctionality beyond single letters
 */

public class ExtendedLetter extends Letter{
    
    // private instance variables of the class ExtendedLetter
    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;


    /**
     * constructor is called when a single string parameter is entered
     * constructor initializes instance variables of the superclass
     * @param s is the value that content is initialized to 
     */
    public ExtendedLetter (String s) {

        super('c');
        this.content = s;
        this.related = false;
        this.family = SINGLETON;
    }

    /**
     * constructor is called when a string and a integer parameter is entered
     * constructor initializes instance variables of the superclass
     * @param s is the value that content is initialized to 
     * @param fam this is a positive number used to compare two ExtendedLetter classes
     */
    public ExtendedLetter (String s, int fam) {

        super('c');
        this.content = s;
        this.related = false;
        this.family = fam;
    }

    /**
     * equals method comapares two ExtendedLetter objects 
     * @Override
     * @return true if objects have the same content
     */
    public boolean equals (Object other) {
        
        ExtendedLetter other_letter = (ExtendedLetter) other;
        
        if (!(other_letter instanceof ExtendedLetter)) {
            return false;
        } else {
            if (this.family == other_letter.family) {
                this.related = true;
            }
            if (this.content.equals(other_letter.content)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * produces a string representation of this ExtendedLetter object
     */
    public String toString () {

        if ((this.isUnused()) && this.related == true) {
            return "." + this.content + ".";
        } else {
            return super.decorator() + this.content + super.decorator();
        }
    }

    /**
     * creates an array of Letter objects
     * @param content the string contents being converted into an array
     * @param codes the integer contents being converted into an array
     * @return the array of Letter objects
     */
    public static Letter[] fromStrings (String[] content, int[] codes) {

        Letter[] letters = new Letter[content.length];
        int i = 0;

        if (codes == null) {
            for (i=0; letters.length > i; ++i) {
                letters[i] = new ExtendedLetter(content[i]);
            }
        } else {
            for (i=0; letters.length > i; ++i) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            }
        }

        return letters;
    }

}
