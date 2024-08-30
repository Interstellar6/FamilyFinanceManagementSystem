package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Asset;
import org.interstellar.familyfinancemanagement.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    private AssetService assetService;

    // 添加资产记录
    @PostMapping("/add")
    public boolean addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    // 更新资产记录
    @PutMapping("/update")
    public boolean updateAsset(@RequestBody Asset asset) {
        return assetService.updateAsset(asset);
    }

    // 删除资产记录
    @DeleteMapping("/delete/{assetId}")
    public boolean deleteAsset(@PathVariable Integer assetId) {
        return assetService.deleteAsset(assetId);
    }

    // 根据ID查询资产记录
    @GetMapping("/get/{assetId}")
    public Asset getAssetById(@PathVariable Integer assetId) {
        return assetService.getAssetById(assetId);
    }

    // 查询所有资产记录
    @GetMapping("/all")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }
}

