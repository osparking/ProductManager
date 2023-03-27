package space.bumtiger.product.security;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
import space.bumtiger.product.Provider;

@Data
@Table(name ="users")
public class User {
  @Id
  @Column("user_id")
  private Long id;

  private String username;
  private String password;
  private String role;
  private boolean enabled;
  private Provider provider;
  
}
