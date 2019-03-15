package com.stu.sd.service.impl;


import com.stu.sd.model.Province;
import com.stu.sd.repository.ProvinceRepo;
import com.stu.sd.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepo provinceRepo;

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }
}
