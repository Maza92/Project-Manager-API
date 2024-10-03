package api.proyect.manager.models.user;

import api.proyect.manager.models.Role;
import api.proyect.manager.models.enums.RoleName;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  @Column(nullable = false)
  private Long id;

  @Email
  @Max(value = 70)
  @NotNull
  @Column(nullable = false, unique = true)
  private String email;

  @NotNull
  @Column(nullable = false)
  private String password;

  @NotNull
  @Max(value = 30)
  @Min(value = 8)
  @Column(nullable = false, unique = true)
  private String username;

  @ManyToMany
  @JoinTable(
          name = "usuario_roles",
          joinColumns = @JoinColumn(name = "usuario_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;

  @Column(nullable = false, name = "created_at")
  private LocalDateTime createAt;

  @PrePersist
  protected void onCreate() {
    createAt = LocalDateTime.now();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
