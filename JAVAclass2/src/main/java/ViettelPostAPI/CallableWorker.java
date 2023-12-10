package ViettelPostAPI;

import ViettelPostAPI.entity.client.VPPostExpress;
import ViettelPostAPI.service.client.VPServiceClient;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable<List<VPPostExpress>> {
    private int type;
    private final VPServiceClient serviceClient;

    public CallableWorker(int type, VPServiceClient serviceClient) {
        this.type = type;
        this.serviceClient = serviceClient;
    }

    @Override
    public List<VPPostExpress> call() throws Exception {
        return serviceClient.getListService(type);
    }
}
