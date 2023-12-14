package src.entities;

public class Products {

    private String name;
    private Double price;
    private Integer quantity;

    public Products(){
    }

    public Products(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double totalValue(){
        return getQuantity() * getPrice();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s,%.2f", getName(), totalValue()));
        return sb.toString();
    }
}
