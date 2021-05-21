public class Printer {
    private String queue = "";
    private int pagesCount = 0;
    private int documentsCount = 0;
    private int totalPrint = 0;


    public Printer(String queue) {
        this.queue = this.queue + queue;
    }

    public Printer () {
    }

    public void append(String text, String name, int pages) {
        queue = queue + "\n" + text + " - " + name + " - " + pages + " стр";
        pagesCount += pages;
        documentsCount = documentsCount++;
    }
    public void append(String text, int pages) {
        queue = queue + "\n" + text + " - " + pages + " стр";
        pagesCount += pages;
        documentsCount = documentsCount++;
    }
    public void append(String text, String name) {
        queue = queue + "\n" + text + " - " + name;
        documentsCount = documentsCount++;
    }


    public void clear() {
        queue = "";
    }

    public void print() {
        System.out.println(queue);
        clear();
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public int getDocumentsCount() {
        return documentsCount;
    }


    public int totalPrint (){
        totalPrint = pagesCount + documentsCount;
        return  totalPrint;
    }

}

