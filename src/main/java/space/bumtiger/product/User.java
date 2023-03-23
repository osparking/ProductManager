package space.bumtiger.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

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
}
