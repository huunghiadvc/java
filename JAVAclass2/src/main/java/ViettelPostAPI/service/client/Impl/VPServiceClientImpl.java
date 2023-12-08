package ViettelPostAPI.service.client.Impl;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.PostOfficeWrapperClass;
import ViettelPostAPI.service.client.VPServiceClient;
import config.properties.ViettelPostApiProperties;
import const_.VPLoginReq;
import const_.VPLoginRes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import utils.RestUtils;

import java.util.List;

public class VPServiceClientImpl implements VPServiceClient {
    Logger logger;
    ViettelPostApiProperties viettelApi;
    RestUtils restUtils = new RestUtils();

    public VPServiceClientImpl() {
        viettelApi = new ViettelPostApiProperties();
        viettelApi.DataSourceProperties();
        logger = LogManager.getLogger(VPServiceClientImpl.class);
    }

    @Override
    public VPLoginRes login() {

        String url = viettelApi.getBaseUrl() + viettelApi.getLogin();
        try {
            RestUtils restUtils = new RestUtils();
            VPLoginReq request = VPLoginReq.builder()
                    .username(viettelApi.getUsername())
                    .password(viettelApi.getPassword())
                    .build();

            ResponseEntity<?> responseEntity = restUtils.send(
                    url, HttpMethod.POST, request, VPLoginRes.class
            );

            System.err.println(responseEntity);

            return (VPLoginRes) responseEntity.getBody();
        } catch (Exception e){
            logger.error("error");
            return null;
        }
    }

    @Override
    public List<PostOffice> getPostOffice(String token) {
        String url = viettelApi.getBaseUrl() + viettelApi.getGetListPostOffice();
        ResponseEntity<?> response = restUtils.send(token, url, HttpMethod.GET, PostOfficeWrapperClass.class);
        PostOfficeWrapperClass officeWrapperClass = (PostOfficeWrapperClass) response.getBody();
        if (officeWrapperClass != null){
            return officeWrapperClass.getPostOffices();
        }
        return null;
    }
}
