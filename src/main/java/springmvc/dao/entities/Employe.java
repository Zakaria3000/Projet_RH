package springmvc.dao.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Employe {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID_EMP;
	@NotBlank @Size(min = 3)
	private String Nom;
	@NotBlank @Size(min = 4)
	private String Prenom;
	@NotBlank @Email
	private String Email;
	@NotBlank @Size(min = 4)
	private String Poste;
	@NotBlank @Pattern(regexp = "^(06|07)\\d{8}$")
	private String telephone;
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
    private List<Conge> conges;

}
