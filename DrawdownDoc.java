import java.util.ArrayList;

public class DrawdownDoc extends Document  {

    public DrawdownDoc(String text)
    {
        super(text);
    }

    @Override
    public void writeoutPutFile(String importantinfo) {

    }

    public void AnalyzeText()
    {
        //retval should hold clientname, drawdown date and drawdown capitol.
        String[] retval = new String[3];
        ArrayList<String> txtperline = new ArrayList<String>();
        String lines[] = txt.split("\\n");

        for(String line: lines) {
            txtperline.add(line);
        }

        retval[0] = findinvestorID(txtperline);
        retval[1] = findDrawDownDate(txtperline);
        retval[2] = findCapitalContribution(txtperline);


       Anayledtxt = retval;
    }

    public static String findinvestorID(ArrayList<String> txtperline)
    {
        int i = 1;
        //first thing we're looking for is the client name;
        while(true)
        {
            if(txtperline.get(i).contains("Investor ID:"))
            {
                String[] splitAtName = txtperline.get(i).split(" ") ;
                return "Investor ID =" +splitAtName[2];





            }

            if(i+1 == txtperline.size())
            {
                return "error at investor name (not found)";

            }
            i++;
        }

    }

    public static String findDrawDownDate(ArrayList<String> txtperline) {
        int i = 1;
        //first thing we're looking for is the client name;
        while (true) {
            if (txtperline.get(i).contains("Drawdown Summary")) {
                //the term drawdownDate and the actual date are seperated by 3 lines.
                String splitIt = txtperline.get(i+5);
               // String Date[] = splitIt.split(" ");
                  System.out.println(splitIt);

                return "Drawdown Date ="+ splitIt;


            }

            if (i + 1 == txtperline.size()) {
                return "error at Drawdown Date (not found) in ";

            }
            i++;
        }
    }

    //TODO: distinguish between positive and negative contribution.
    public static String findCapitalContribution(ArrayList<String> txtperline) {
        int i = 1;
        //now we're looking for the Capital Contribution
        while (true) {
            if (txtperline.get(i).contains("Drawdown Summary")) {
                //the term drawdownDate and the actual date are seperated by 3 lines.
                String splitIt = txtperline.get(i+9);
               // String Date[] = splitIt.split(" ");
                System.out.println(splitIt);

                return "Contribution ="+ splitIt;
            }

            if (i + 1 == txtperline.size()) {
                return "error at Capital Commitment Summary (not found)";

            }
            i++;
        }
    }

}
