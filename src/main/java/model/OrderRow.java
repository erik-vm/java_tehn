package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Embeddable
@Table(name = "order_rows")
public class OrderRow {

    @Column(name = "item_name")
    private String itemName;
    @NotNull
    @Min(1)
    private int quantity;
    @NotNull
    @DecimalMin("0.01")
    private double price;
}
