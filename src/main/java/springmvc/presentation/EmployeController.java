package springmvc.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.Data;
import springmvc.dao.entities.Employe;
import springmvc.service.IService.IServiceEmploye;

@Controller
@Data 
public class EmployeController {
    private final IServiceEmploye se;

    @Autowired
    public EmployeController(IServiceEmploye se) {
        this.se = se;
    }
	@GetMapping("/home")
	public String getHome(Model model,@RequestParam(defaultValue="0") int numPage) {
		Page<Employe> listemploye = se.listerEmploye(numPage);
		int currentPage=numPage;
		int totalPage=listemploye.getTotalPages();
		model.addAttribute("listemploye",listemploye);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("totalPage",totalPage);
	    model.addAttribute("employe", new Employe()); 

		return "navbar"; 
	}
	@GetMapping("/navbar")
	public String getnavbar() {
		return "navbar";
	}

	@GetMapping("/ajouterEmploye")
	public String getFormulaireAjoutEmploye(Model model) {
	    model.addAttribute("employe", new Employe());
	    return "AddEmployee";
	}

	@PostMapping("/ajouterEmploye")
	public String ajouterEmploye(@Validated Employe employe, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
	    if (bindingResult.hasErrors()) {
	        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employe", bindingResult);
	        redirectAttributes.addFlashAttribute("employe", employe);
	        return "redirect:/home#addEmployeeModal"; // Redirect back to the home page and open the modal
	    }
	    se.ajouterEmploye(employe);
	    return "redirect:/home";
	}
	

	@GetMapping("/modifier/{id}")
	public String update(@PathVariable Integer id, Model model) throws Exception {
		Employe employe = se.rechercherEmploye(id);
		model.addAttribute("employe", employe);
		return "home";
	}
	
	@PostMapping("/modifierEmploye")
	public String updateEmploye(@Validated Employe e, BindingResult br) {
	    if (br.hasErrors()) {
	        return "redirect:/home"; 
	    }
	    
	    se.ajouterEmploye(e);
	    
	    return "redirect:/home"; 
	}
	@GetMapping("/supprimer/{id}")
	public String delete(@PathVariable Integer id, Model model) throws Exception {
		se.supprimerEmploye(id);
		return "redirect:/home";
	}

}
