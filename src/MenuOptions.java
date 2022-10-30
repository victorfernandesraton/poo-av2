
public class MenuOptions {

    private String label;
    private int option;


    public MenuOptions(String label, int option) {
        this.label = label;
        this.option = option;
    }

    public String getLabel() {
        return label;
    }
    public int getOption() {
        return option;
    }

    @Override
    public  String toString() {
        return  this.option + " - " + this.label;
    }
}
