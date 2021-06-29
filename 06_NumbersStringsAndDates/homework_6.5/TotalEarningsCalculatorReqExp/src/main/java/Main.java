public class Main {

  public static void main(String[] args) {



  }

  public static int calculateSalarySum(String text){
    //TODO: реализуйте метод
      int totalCash = 0;
      String [] sentences = text.split(",\\s+");
      for( int i = 0; i < sentences.length; i++){

      if( sentences.length == 1){
          System.out.println("Никто ничего не заработал");
        break;
      }
        totalCash += Integer.parseInt(sentences[i].replaceAll("[^0-9]", ""));
    }
      return totalCash;

  }

}