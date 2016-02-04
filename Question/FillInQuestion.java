import java.util.*;

public class FillInQuestion extends Question
{
    /*
     * this class supports fill-in-the-blank questions where the answer is specified in the question's text.
     * For example:
     *     text: "The inventor of Jaa was _James Gosling_."
     *     
     *     This will extract the answer from the question's text and replace the answer with ______.
     */

    //we will override the setText method of the Question class to extract the answer from the text
    public void setText(String questionText)
    {
        Scanner parser = new Scanner(questionText);
        parser.useDelimiter("_");
        String question = parser.next();
        String answer = parser.next();
        question += "______________" + parser.next();
        
        super.setText(question);
        setAnswer(answer);
    }
}