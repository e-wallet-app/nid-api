package com.ewallet.nidapi.initialize;

import com.ewallet.nidapi.dto.request.NidInfoRequest;
import com.ewallet.nidapi.repository.NidInfoRepository;
import com.ewallet.nidapi.service.NidInfoServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitializeData {

    private final NidInfoRepository nidRepository;

    private final NidInfoServiceImpl nidInfoService;

    private final ResourceLoader resourceLoader;

    public InitializeData(NidInfoRepository nidRepository, NidInfoServiceImpl nidInfoService, ResourceLoader resourceLoader) {
        this.nidRepository = nidRepository;
        this.nidInfoService = nidInfoService;
        this.resourceLoader = resourceLoader;
    }

    public void initialize() {
        if (nidRepository.count() < 1) {
            try {
                List<NidInfoRequest> nidModels = new ObjectMapper()
                        .readValue(resourceLoader.getResource ("classpath:nid_users.json").getInputStream (),
                                new TypeReference<ArrayList<NidInfoRequest>>() {});
                nidModels.forEach (nidInfoService::create);
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }
}
