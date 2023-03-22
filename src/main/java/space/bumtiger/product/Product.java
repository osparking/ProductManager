package space.bumtiger.product;

import java.math.BigDecimal;

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
  private BigDecimal price;
  
}
