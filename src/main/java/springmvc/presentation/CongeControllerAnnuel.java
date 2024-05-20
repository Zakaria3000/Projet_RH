package springmvc.presentation;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;
import springmvc.dao.entities.CongeAnnuel;
import springmvc.service.IService.IServiceCongeAnnuel;

@Controller
@Data
public class CongeControllerAnnuel {
    private  IServiceCongeAnnuel sc;

    @GetMapping("/conges")
    public String getConges(Model model, @RequestParam(defaultValue = "0") int numPage) {
        Page<CongeAnnuel> listConge = sc.listerConges(numPage);
        int currentPage = numPage;
        int totalPage = listConge.getTotalPages();
        model.addAttribute("listConge", listConge);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);
        return "indexConge"; 
    }

    @GetMapping("/addConge")
    public String getFormAddConge(Model model) {
        model.addAttribute("conge", new CongeAnnuel());
        return "AddCongeForm";
    }

    @PostMapping("/addConge")
    public String addConge(@Validated CongeAnnuel c, BindingResult br, Model model) {
        if (br.hasErrors()) {
           // model.addAttribute("addCongeModalOpen", true);
          //  return getConges(model, 0);  
            return "AddCongeForm";
        } else {
            sc.ajouterConge(c);
           // return "redirect:/conges";
            return "AddCongeForm";

        }
    }

    @GetMapping("/modifierConge/{id}")
    public String updateConge(@PathVariable Integer id, Model model) throws Exception {
    	CongeAnnuel conge = sc.rechercherConge(id);
        model.addAttribute("conge", conge);
        return "UpdateCongeForm";
    }

    @PostMapping("/modifierConge/{id}")
    public String updateConge(@PathVariable Long id, @Validated CongeAnnuel c, BindingResult br) {
        if (br.hasErrors()) {
            return "UpdateCongeForm";
        } else {
            sc.modifierConge(c);
            return "redirect:/conges";
        }
    }

    @GetMapping("/supprimerConge/{id}")
    public String deleteConge(@PathVariable Integer id, Model model) throws Exception {
        sc.supprimerConge(id);
        return "redirect:/conges";
    }
}
