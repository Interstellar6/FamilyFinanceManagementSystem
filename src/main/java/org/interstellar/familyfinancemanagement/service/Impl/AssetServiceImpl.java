package org.interstellar.familyfinancemanagement.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Asset;
import org.interstellar.familyfinancemanagement.mapper.AssetMapper;
import org.interstellar.familyfinancemanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AssetServiceImpl extends ServiceImpl<AssetMapper, Asset> implements AssetService {

    @Autowired
    private AssetMapper assetMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addAsset(Asset asset) {
        return assetMapper.insert(asset) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAsset(Asset asset) {
        return assetMapper.updateById(asset) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAsset(Integer assetId) {
        return assetMapper.deleteById(assetId) > 0;
    }

    @Override
    public Asset getAssetById(Integer assetId) {
        return assetMapper.selectById(assetId);
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetMapper.selectList(null);
    }

    @Override
    public List<Asset> getAssetsByLauncherId(Integer launcherId) {
        return assetMapper.selectByLaucherId(launcherId);
    }
}


