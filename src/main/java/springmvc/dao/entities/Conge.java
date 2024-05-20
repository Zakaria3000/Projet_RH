package springmvc.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_conge")
public class Conge implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	@ManyToOne
	@JoinColumn(name = "employe_id")
	private Employe employe;
	@ManyToMany
	@JoinTable(
			name = "evaluation_conge",
			joinColumns = @JoinColumn(name = "conge_id"),
			inverseJoinColumns = @JoinColumn(name = "adminrh_id")
			)
	private List<AdminRH> adminsRH;
}