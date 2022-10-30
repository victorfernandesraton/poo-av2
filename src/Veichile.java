import java.util.Scanner;

public class Veichile {
    private String plate;
    private String model;
    private String brand;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Placa:\t" + plate + "\n" +
                "Modelo:\t" + model + "\n" +
                "Marca:\t" + brand + "\n";
    }

    public Veichile(String plate, String model, String brand) {
        this.plate = plate;
        this.model = model;
        this.brand = brand;
    }

    public static Veichile create() {
        String[] data = { "", "", "" };
        String[] args = { "Placa", "Modelo", "Marca" };
        Scanner io = new Scanner(System.in);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            data[i] = io.nextLine();
        }
        return new Veichile(data[0], data[1], data[2]);
    }
}
