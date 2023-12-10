package ViettelPostAPI;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.process.VPProcess;
import ViettelPostAPI.service.VPService;
import ViettelPostAPI.service.client.Impl.VPServiceClientImpl;
import ViettelPostAPI.service.client.VPServiceClient;
import ViettelPostAPI.service.impl.VPServiceImpl;
import const_.VPLoginRes;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        VPService vpService = new VPServiceImpl();

        Thread b = new VPProcess("Viettel-Post-Process", vpService);
        b.start();


//        UserData u = ClientUtils.login();
//
//        if (u == null){
//            System.out.println("failed");
//        } else {
//            System.out.println(u);
//        }
//        ViettelLab.insert(u);
//        List<PostOffice> postOffices = ClientUtils.getListPostOffice(u.getToken());

//        System.out.println(postOffices.get(0));

//        ViettelLab.insert(postOffices);
//        ViettelLab.insert();
    }
}
