import java.util.UUID;;

public class Roon {
    private UUID key;
    private String name;

    public Roon(String name) {
        this.key = UUID.randomUUID();
    }

    public String getName() {
        return this.name;
    }

    public UUID getKey() {
        return this.key;
    }
}
