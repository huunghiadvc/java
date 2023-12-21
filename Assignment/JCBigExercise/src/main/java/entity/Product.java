package entity;

import annotations.data.Column;
import annotations.data.Id;
import annotations.data.Table;
import const_.DataType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Table(tableName = "products", group = "data/")
public class Product {
    private static long autoId = 1;
    @Id(columnName = "id", type = DataType.BIGINT)
    private long id;
    @Setter
    @Column(columnName = "name", type = DataType.VARCHAR)
    private String name;
    @Setter
    @Column(columnName = "producer", type = DataType.VARCHAR)
    private String producer;
    @Setter
    @Column(columnName = "line", type = DataType.VARCHAR)
    private String line;
    @Setter
    @Column(columnName = "price", type = DataType.DOUBLE)
    private double price;

    public Product(String name, String producer, String line, double price) {
        this.id = autoId++;
        this.name = name;
        this.producer = producer;
        this.line = line;
        this.price = price;
    }

    public Product() {
        this.id = autoId++;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", line='" + line + '\'' +
                ", price=" + price;
    }
}
