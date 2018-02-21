public abstract class Document {

    public String txt;
    public String[] Anayledtxt;
   public Document(String text)
   {
       txt = text;
   }

   public abstract void AnalyzeText();
   public abstract void writeoutPutFile(String importantinfo);
}
