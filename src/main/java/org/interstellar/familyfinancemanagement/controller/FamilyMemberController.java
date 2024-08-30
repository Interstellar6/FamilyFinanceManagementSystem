package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.FamilyMember;
import org.interstellar.familyfinancemanagement.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family-members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    // 添加家庭成员
    @PostMapping("/add")
    public boolean addFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.addFamilyMember(familyMember);
    }

    // 更新家庭成员信息
    @PutMapping("/update")
    public boolean updateFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberService.updateFamilyMember(familyMember);
    }

    // 删除家庭成员
    @DeleteMapping("/delete/{memberId}")
    public boolean deleteFamilyMember(@PathVariable Integer memberId) {
        return familyMemberService.deleteFamilyMember(memberId);
    }

    // 根据ID查询家庭成员
    @GetMapping("/get/{memberId}")
    public FamilyMember getFamilyMemberById(@PathVariable Integer memberId) {
        return familyMemberService.getFamilyMemberById(memberId);
    }

    // 查询所有家庭成员
    @GetMapping("/all")
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberService.getAllFamilyMembers();
    }
}
