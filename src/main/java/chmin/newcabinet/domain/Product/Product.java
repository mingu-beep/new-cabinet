package chmin.newcabinet.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {

    private Long id;
    private int category;
    private int board;
    private int price;
    private int dealType;
    private String productName;
    private String owner;
    private String location;
    private String image;
    //private Date updateDate;


    public Product() {
    }

    public Product(int category, int board, int price, int dealType,
                   String productName, String owner, String location, String image) {
        this.category = category;
        this.board = board;
        this.price = price;
        this.dealType = dealType;
        this.productName = productName;
        this.owner = owner;
        this.location = location;
        this.image = image;
    }
}
