package springmvc.presentation;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.dao.entities.CongeMaladie;
import springmvc.service.IService.IServiceCongeMaladie;
public class CongeMaladieController {
	private  IServiceCongeMaladie sc;
	  @GetMapping("/congesMaladie")
	    public String getConges(Model model, @RequestParam(defaultValue = "0") int numPage) {
	        Page<CongeMaladie> listConge = sc.listerConges(numPage);
	        int currentPage = numPage;
	        int totalPage = listConge.getTotalPages();
	        model.addAttribute("listConge", listConge);
	        model.addAttribute("currentPage", currentPage);
	        model.addAttribute("totalPage", totalPage);
	        return "indexCongeMaladie"; 
	    }

	    @GetMapping("/addCongeMaladie")
	    public String getFormAddConge(Model model) {
	        model.addAttribute("conge", new CongeMaladie());
	        return "AddCongeFormMaladie";
	    }

	    @PostMapping("/addCongeMaladie")
	    public String addConge(@Validated CongeMaladie c, BindingResult br, Model model) {
	        if (br.hasErrors()) {
	            model.addAttribute("addCongeModalOpen", true);
	            return getConges(model, 0);  
	        } else {
	            sc.ajouterConge(c);
	            return "redirect:/congesMaladie";
	        }
	    }

	    @GetMapping("/modifierCongeMaladie/{id}")
	    public String updateConge(@PathVariable Integer id, Model model) throws Exception {
	    	CongeMaladie conge = sc.rechercherConge(id);
	        model.addAttribute("conge", conge);
	        return "UpdateCongeFormMaladie";
	    }

	    @PostMapping("/modifierCongeMaladie/{id}")
	    public String updateConge(@PathVariable Long id, @Validated CongeMaladie c, BindingResult br) {
	        if (br.hasErrors()) {
	            return "UpdateCongeFormMaladie";
	        } else {
	            sc.modifierConge(c);
	            return "redirect:/congesMaladie";
	        }
	    }

	    @GetMapping("/supprimerCongeMaladie/{id}")
	    public String deleteConge(@PathVariable Integer id, Model model) throws Exception {
	        sc.supprimerConge(id);
	        return "redirect:/congesMaladie";
	    }
}
