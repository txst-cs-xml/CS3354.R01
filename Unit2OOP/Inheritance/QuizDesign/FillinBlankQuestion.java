import java.util.ArrayList;
public class FillinBlankQuestion extends Question{
    private ArrayList<String> blanks = new ArrayList<String>();
 
    /**
       Sets the answer for this question.
       @param correctResponse the answer
    */
    public void setAnswer(ArrayList<String> correctResponses)
    {
       blanks = correctResponses; 
    }


}
