package ViettelPostAPI.service;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.entity.client.ServiceExpressWrapper;

import java.util.List;

public interface VPService {
    List<PostOffice> getPostOffice();
    List<ServiceExpressWrapper> getListService();
}
