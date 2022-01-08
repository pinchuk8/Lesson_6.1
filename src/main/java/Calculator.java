
public class Calculator {
    private String title;

    public Calculator(String title) {
        this.title = title;
    }

    public int sum(int a, int b){ return a + b;}
    public int dif (int a,int b){return a-b;}
    public int div (int a,int b){return a/b;}
    public int mult (int a,int b){return a*b;}

    public String getTitle() {
        return title;
    }
}