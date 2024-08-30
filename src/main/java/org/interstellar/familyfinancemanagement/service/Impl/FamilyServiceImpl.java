package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Family;
import org.interstellar.familyfinancemanagement.mapper.FamilyMapper;
import org.interstellar.familyfinancemanagement.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper, Family> implements FamilyService {
    @Autowired
    FamilyMapper familyMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Family createFamily(String familyName) {
        Family family = new Family(familyName);
        family.setNum(1);
        familyMapper.insert(family);
        return family;
    }

    @Override
    public Family getFamilyByFamilyName(String familyName) {
        return familyMapper.selectByFamilyName(familyName);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean joinFamily(String familyName, String activateCode) {
        Family family = getFamilyByFamilyName(familyName);
        if (family == null) {
            throw new RuntimeException("Family not found");
        }
        if (family.getActivateCode().equals(activateCode)) {
            throw new RuntimeException("Invalid activate code!");
        }
        family.setNum(family.getNum()+1);
        familyMapper.updateById(family);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteFamily(String familyName) {
        Family family = getFamilyByFamilyName(familyName);
        if (family == null) {
            throw new RuntimeException("Family not found");
        }
        familyMapper.deleteById(family.getFamilyId());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean leaveFamily(String familyName) {
        Family family = getFamilyByFamilyName(familyName);
        if (family == null) {
            throw new RuntimeException("Family not found");
        }
        family.setNum(family.getNum()-1);
        familyMapper.updateById(family);
        return true;
    }


}
