public class QuestionDemo
{
   public static void main(String[] args)
   {
      ChoiceQuestion cq = new ChoiceQuestion();
      cq.addChoice("Austria", false);
      cq.addChoice("Canada", true);
      cq.display();
      System.out.println(cq.checkAnswer("2"));
   }
}