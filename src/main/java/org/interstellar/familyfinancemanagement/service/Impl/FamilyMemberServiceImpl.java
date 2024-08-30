package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.FamilyMember;
import org.interstellar.familyfinancemanagement.mapper.FamilyMemberMapper;
import org.interstellar.familyfinancemanagement.service.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FamilyMemberServiceImpl extends ServiceImpl<FamilyMemberMapper, FamilyMember> implements FamilyMemberService {

    @Autowired
    private FamilyMemberMapper familyMemberMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addFamilyMember(FamilyMember familyMember) {
        return familyMemberMapper.insert(familyMember) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateFamilyMember(FamilyMember familyMember) {
        return familyMemberMapper.updateById(familyMember) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteFamilyMember(Integer memberId) {
        return familyMemberMapper.deleteById(memberId) > 0;
    }

    @Override
    public FamilyMember getFamilyMemberById(Integer memberId) {
        return familyMemberMapper.selectById(memberId);
    }

    @Override
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberMapper.selectList(null);
    }
}

