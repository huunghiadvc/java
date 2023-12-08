package ViettelPostAPI.service.client;

import ViettelPostAPI.entity.PostOffice;
import const_.VPLoginRes;

import java.util.List;

public interface VPServiceClient {
    VPLoginRes login();
    List<PostOffice> getPostOffice(String token);
}
