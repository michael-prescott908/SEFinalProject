package Items;

public abstract class Item {
    protected Integer price;
    protected String name;
    protected Integer serial;

    public Item(){}

    public Item(Integer price, String name, Integer serial) {
        this.price = price;
        this.name = name;
        this.serial = serial;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
