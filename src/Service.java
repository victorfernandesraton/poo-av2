import java.util.Scanner;

public class Service {
    private Veichile veichile;
    private String description;
    private float ammount;

    public Veichile getVeichile() {
        return veichile;
    }

    public void setVeichile(Veichile veichile) {
        this.veichile = veichile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmmount() {
        return ammount;
    }

    public void setAmmount(float ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "Veículo:\t" + veichile.toString() + "\n" +
                "Desrição:\t" + description + "\n" +
                "Custo:\t" + ammount + "\n";
    }

    public Service(Veichile veichile, String description, float ammount) {
        this.veichile = veichile;
        this.description = description;
        this.ammount = ammount;
    }

    public static Service create(Veichile veichile) {
        String description = "";
        float ammount = 0;
        Scanner io = new Scanner(System.in);
        System.out.println("Descrição");
        description = io.nextLine();
        System.out.println("Custo");
        ammount = Float.parseFloat(io.nextLine());
        return new Service(veichile, description, ammount);
    }
}
