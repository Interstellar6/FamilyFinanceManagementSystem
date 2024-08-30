package org.interstellar.familyfinancemanagement.service;

import org.interstellar.familyfinancemanagement.entity.Family;

public interface FamilyService {
    public Family createFamily(String familyName);

    Family getFamilyByFamilyName(String familyName);

    public boolean joinFamily(String familyName, String activateCode);

    public boolean deleteFamily(String familyName);

    boolean leaveFamily(String familyName);

}
