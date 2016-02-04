
/**
 * Write a description of class ComboLock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComboLock
{
    // instance variables - replace the example below with your own
    private String[] leftRight;
    private int[] num;
    private int dialNum;
    private int numTurns;
    public final int MAX_TURNS=3;
    /**
     * Constructor for objects of class ComboLock
     */
    public ComboLock(int secret1, int secret2, int secret3)
    {
        num = new int[MAX_TURNS];
        num[0]=secret1;
        num[1]=secret2;
        num[2]=secret3;
        leftRight = new String[MAX_TURNS];
        dialNum=0;
        numTurns=0;
    }

    public void reset()
    {
        dialNum=0;
        numTurns=0;
    }

    public boolean excTicks()
    {
        if(numTurns>=MAX_TURNS)
        {
            return true;
        }
        return false;
    }

    public void turnLeft(int ticks)
    {
        if(!excTicks())
        {
            dialNum+=ticks-40;
            /*if(dialNum<0)
            {
            dialNum+=40;
            }*/
            if(dialNum==num[numTurns])
            {
                leftRight[numTurns]="l";
            }
            numTurns++;
        }
        else
        {
            System.out.println("Too many ticks. Lock reset.");
            reset();
        }
        System.out.println(dialNum);
        System.out.println(leftRight);
    }

    public void turnRight(int ticks)
    {
        if(!excTicks())
        {
            dialNum+=ticks;
            if(dialNum>=40)
            {
                dialNum-=40;
            }
            if(dialNum==num[numTurns])
            {
                leftRight[numTurns]="r";
                
            }
            numTurns++;
        }
        else
        {
            System.out.println("Too many ticks. Lock reset.");
            reset();
        }

        System.out.println(dialNum);
        System.out.println(leftRight);
    }

    public boolean open()
    {

        if(leftRight[0].equals("r")&&leftRight[1].equals("l")&&leftRight[2].equals("r"))
        {
            return true;
        }
        return false;
    }
}
