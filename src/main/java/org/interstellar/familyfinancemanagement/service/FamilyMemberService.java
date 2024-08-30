package org.interstellar.familyfinancemanagement.service;

import org.interstellar.familyfinancemanagement.entity.FamilyMember;

import java.util.List;

public interface FamilyMemberService {
    // 添加家庭成员
    boolean addFamilyMember(FamilyMember familyMember);

    // 更新家庭成员信息
    boolean updateFamilyMember(FamilyMember familyMember);

    // 删除家庭成员
    boolean deleteFamilyMember(Integer memberId);

    // 根据ID查询家庭成员
    FamilyMember getFamilyMemberById(Integer memberId);

    // 查询所有家庭成员
    List<FamilyMember> getAllFamilyMembers();
}
