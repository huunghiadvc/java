package ViettelPostAPI.service.impl;

import ViettelPostAPI.CallableWorker;
import ViettelPostAPI.const_.VPServiceType;
import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.client.ServiceExpressWrapper;
import ViettelPostAPI.entity.client.VPPostExpress;
import ViettelPostAPI.service.VPService;
import ViettelPostAPI.service.client.Impl.VPServiceClientImpl;
import ViettelPostAPI.service.client.VPServiceClient;
import config.properties.ViettelPostApiProperties;
import const_.VPLoginRes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.*;

public class VPServiceImpl implements VPService {
    VPServiceClient serviceClient;

    ViettelPostApiProperties viettelApi;

    public VPServiceImpl() {
        serviceClient = new VPServiceClientImpl();
        viettelApi = new ViettelPostApiProperties();
    }

    @Override
    public List<PostOffice> getPostOffice() {
        VPLoginRes loginRes = serviceClient.login();
        if (loginRes != null && loginRes.getStatus().equalsIgnoreCase("200")){
            // login success -> load data
            return serviceClient.getPostOffice(loginRes.getData().getToken());
        }
        return null;
    }

    @Override
    public List<ServiceExpressWrapper> getListService() {
        EnumSet.allOf(VPServiceType.class).forEach(item -> {
            List<VPPostExpress> wrapperList = serviceClient.getListService(item.type);
            System.out.println(wrapperList);
        });

        // multi thread
        List<Future<List<VPPostExpress>>> futureList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<List<VPPostExpress>> callable;
        Future<List<VPPostExpress>> future;
        for (VPServiceType item : VPServiceType.values()) {
            callable = new CallableWorker(item.type, serviceClient);
            future = executor.submit(callable);
            futureList.add(future);
        }

        List<VPPostExpress> vpPostExpresses = new ArrayList<>();
        for (Future<List<VPPostExpress>> f : futureList) {
            try{
                List<VPPostExpress> vpe = f.get();
                vpPostExpresses.addAll(vpe);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error " + e.getMessage());
            }
        }

        System.err.println(vpPostExpresses);


        return null;
    }
}
