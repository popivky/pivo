public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль

    int vasyaCash = Integer.parseInt(text.substring(text.indexOf("л") + 1,text.indexOf("е") - 4).trim());
    int petyaCash = Integer.parseInt(text.substring(text.indexOf("-") + 1, text.lastIndexOf("я") - 4).trim());
    int mashaCash = Integer.parseInt(text.substring(text.lastIndexOf("-") + 1,text.lastIndexOf("р")).trim());
    System.out.println(vasyaCash + petyaCash + mashaCash);

  }

}