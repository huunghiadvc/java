package ViettelPostAPI.service.client;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.client.ServiceExpressWrapper;
import ViettelPostAPI.entity.client.VPPostExpress;
import const_.VPLoginRes;

import java.util.List;

public interface VPServiceClient {
    VPLoginRes login();
    List<PostOffice> getPostOffice(String token);
    List<VPPostExpress>  getListService(int type);
}
