package org.interstellar.familyfinancemanagement.service;

import org.interstellar.familyfinancemanagement.entity.Asset;
import java.util.List;

public interface AssetService {
    // 添加资产记录
    boolean addAsset(Asset asset);

    // 更新资产记录
    boolean updateAsset(Asset asset);

    // 删除资产记录
    boolean deleteAsset(Integer assetId);

    // 根据ID查询资产记录
    Asset getAssetById(Integer assetId);

    // 查询所有资产记录
    List<Asset> getAllAssets();

    // 根据发起人查询所有资产记录
    List<Asset> getAssetsByLauncherId(Integer launcherId);
}
