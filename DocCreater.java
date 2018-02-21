public class DocCreater {

    public String[] txtfiles;

    public DocCreater(String[] txtfiles)
    {
        this.txtfiles=txtfiles;
    }

    //TODO: Add in the 2 other documents and create if statements for the others.
     public Document[] AnaylzeDocType()
     {
         Document [] retval = new Document[txtfiles.length];
         System.out.println(txtfiles.length);
         for(int i = 0; i < txtfiles.length; i++)
         {
             if(txtfiles[i].contains("Return of Capital"))
             {
                 retval[i] = new RecallDoc(txtfiles[i]);
                 System.out.println("RecallDoc created" + i);
             }

             if(txtfiles[i].contains("Drawdown Notice")) {
                 retval[i] = new DrawdownDoc(txtfiles[i]);
                 System.out.println("DrawdownDoc created" + i);
             }

             if(txtfiles[i].contains("Income")) {
                 retval[i] = new IncomeDoc(txtfiles[i]);
                 System.out.println("IncomeDoc created" + i );
             }



         }
         return retval;


     }


}
