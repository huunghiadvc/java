package ViettelPostAPI.service.impl;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.service.VPService;
import ViettelPostAPI.service.client.Impl.VPServiceClientImpl;
import ViettelPostAPI.service.client.VPServiceClient;
import config.properties.ViettelPostApiProperties;
import const_.VPLoginRes;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class VPServiceImpl implements VPService {
    VPServiceClient serviceClient;

    ViettelPostApiProperties viettelApi;

    public VPServiceImpl() {
        serviceClient = new VPServiceClientImpl();
        viettelApi = new ViettelPostApiProperties();
        viettelApi.DataSourceProperties();
    }

    @Override
    public void syncVPData() {
        VPLoginRes loginRes = serviceClient.login();
        if (loginRes != null && loginRes.getStatus().equalsIgnoreCase("200")){
            // login success -> load data

        }
    }
}
