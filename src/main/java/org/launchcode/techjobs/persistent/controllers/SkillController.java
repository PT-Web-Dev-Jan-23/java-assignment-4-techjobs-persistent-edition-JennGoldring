package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private EmployerRepository employerRepository;

    public SkillController() {

    }
    @Autowired(required = false)
    public SkillController(SkillRepository skillRepository, EmployerRepository employerRepository) {
        this.skillRepository = skillRepository;
        this.employerRepository = employerRepository;
    }
    @GetMapping("")
    public String index(Model model) {
        Iterable<Skill> skills = skillRepository.findAll();
        model.addAttribute("skills", skills);
        return "skills/index";
    }

    @GetMapping("/add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "skills/add";
    }

    @PostMapping("/add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill skill, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "redirect:/skills/add";
        }
        skillRepository.save(skill);

        return "redirect:/skills";
    }


    @GetMapping("/{id}")
    public String displayViewSkill(Model model, @PathVariable("id") int id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        if (skill == null) {
            return "error";
        }
        model.addAttribute("skill", skill);
        return "skills/view";
    }
}
