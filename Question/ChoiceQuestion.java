
public class ChoiceQuestion extends Question
{
    // instance variables - replace the example below with your own
    private int numberOfChoices;

    /**
     * Constructor for objects of class ChoiceQuestion
     */
    public ChoiceQuestion()
    {
        super();
        numberOfChoices=0;
    }

    public void addChoice (String choice, boolean correct)
    {
        numberOfChoices++;
        addText("\n" + numberOfChoices+")" +choice);

        if(correct)
        {
            String choiceString = ""+numberOfChoices;
            this.setAnswer(choiceString);
        }
    }
}
