package space.bumtiger.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@NoArgsConstructor
public class Product {
	@Id
  private Long id;
  private String name;
  private String brand;
  private String madein;
  private float price;
  public String getPriceStr() {
  	return String.format("%,.0f\n", price);
  }
}
