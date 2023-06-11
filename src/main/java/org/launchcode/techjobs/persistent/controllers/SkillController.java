package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    public void setSkillRepository(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping
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
    public String processAddSkillForm(@Valid Skill skill, BindingResult result, Model model) {
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
