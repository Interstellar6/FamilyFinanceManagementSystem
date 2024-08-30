package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Family;
import org.interstellar.familyfinancemanagement.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @PostMapping("/create")
    public Family createFamily(@RequestBody String familyName) {
        return familyService.createFamily(familyName);
    }

    @GetMapping("/getByName/{familyName}")
    public Family getFamilyByFamilyName(@PathVariable String familyName) {
        return familyService.getFamilyByFamilyName(familyName);
    }

    @PostMapping("/join")
    public boolean joinFamily(@RequestBody String familyName, @RequestBody String activateCode) {
        return familyService.joinFamily(familyName, activateCode);
    }

    @PostMapping("/delete")
    public boolean deleteFamily(@RequestBody String familyName) {
        return familyService.deleteFamily(familyName);
    }

    @PostMapping("/leave")
    public boolean leaveFamily(@RequestBody String familyName) {
        return familyService.leaveFamily(familyName);
    }
}

