import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Program {

    public MenuOptions[] maiMenuOptions = {
            new MenuOptions("Fazer entrada de um carro", 1),
            new MenuOptions("Lançar o serviço e valor do serviço no carro cadastrado;", 2),
            new MenuOptions("Liberação do carro", 3),
            new MenuOptions("Listar carros na oficina;", 4),
            new MenuOptions("Listar vagas na oficina.", 5),
            new MenuOptions("sair", 0)
    };

    public ArrayList<Veichile> veichiles = new ArrayList<Veichile>();
    public ArrayList<Service> services = new ArrayList<Service>();

    public void printOptions(MenuOptions[] options) {
        for (MenuOptions menuOption : options) {
            System.out.println(menuOption);
        }
    }

    public void start() {
        int mainOption = -1;
        Scanner io = new Scanner(System.in);
        while (mainOption != 0) {
            System.out.println("======= veichile manager =========");
            printOptions(maiMenuOptions);

            mainOption = io.nextInt();
            try {

                switch (mainOption) {
                    case 1:
                        this.addVeichile();
                        break;
                    case 2:
                        this.createService();
                        break;
                    case 3:
                        this.freeService();
                        break;
                    case 4:
                        this.printVeichiles();
                        break;
                    case 5:
                        this.printServices();
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        io.close();
    }

    public void addVeichile() throws Exception {
        Veichile tempVeichile = Veichile.create();
        Veichile findVeichile = this.findVeichileByPlate(tempVeichile.getPlate());
        if (findVeichile == null) {
            this.veichiles.add(tempVeichile);
            return;
        } else {
            throw new Exception("duplicated plate");
        }
    }

    public Veichile findVeichileByPlate(String plate) {
        for (Veichile item : this.veichiles) {
            if (item.getPlate().equals(plate)) {
                return item;
            }
        }
        return null;
    }

    public static void printList(ArrayList list) {
        Iterator iter = list.iterator();
        int index = 0;
        while (iter.hasNext()) {
            Object item = iter.next();
            index++;
            System.out.println(index + "\t-\t" + "-------" + "\n" + item + "\n");
        }

    }

    public void printVeichiles() {
        this.printList(this.veichiles);
    }

    public Service findServiceByVeichilePlate(String plate) {
        for (Service service : this.services) {
            if (service.getVeichile().getPlate().equals(plate)) {
                return service;
            }
        }
        return null;
    }

    public void createService() throws Exception {
        Scanner io = new Scanner(System.in);

        System.out.println("Placa de veículo para serviço");
        Veichile tempVeichile = this.findVeichileByPlate(io.nextLine());
        if (tempVeichile != null) {
            Service tempService = this.findServiceByVeichilePlate(tempVeichile.getPlate());
            if (tempService == null) {
                System.out.println(tempVeichile);
                this.services.add(Service.create(tempVeichile));
                return;
            } else {
                throw new Exception("veichile has been in service");
            }
        }
    }

    public void removeServiceByVeichilePlate(String plate) {
        Iterator iter = this.services.iterator();
        while (iter.hasNext()) {
            Service item = (Service) iter.next();
            if (item.getVeichile().getPlate().equals(plate)) {
                System.out.println(item);
                iter.remove();
                return;
            }
        }
    }

    public void freeService() throws Exception {
        Scanner io = new Scanner(System.in);
        System.out.println("Placa de veículo em serviço a ser removido");
        String plate = io.nextLine();
        Service tempService = this.findServiceByVeichilePlate(plate);
        if (tempService == null) {
            throw new Exception("not find service by this plate");
        }
        this.removeServiceByVeichilePlate(plate);
    }

    public void printServices() {
        System.out.println("Total de services:\t" + services.size());
        System.out.println("Vagas disponiveis:\t" + (30 - services.size()));
        this.printList(this.services);
    }
}
