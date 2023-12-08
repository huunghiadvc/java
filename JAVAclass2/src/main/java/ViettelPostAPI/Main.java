package ViettelPostAPI;

import ViettelPostAPI.entity.PostOffice;
import ViettelPostAPI.service.client.Impl.VPServiceClientImpl;
import ViettelPostAPI.service.client.VPServiceClient;
import const_.VPLoginRes;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        VPServiceClient serviceClient = new VPServiceClientImpl();
        VPLoginRes u = serviceClient.login();

        List<PostOffice> postOffices = serviceClient.getPostOffice(u.getData().getToken());

        System.out.println(u);

        System.out.println(postOffices);


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
