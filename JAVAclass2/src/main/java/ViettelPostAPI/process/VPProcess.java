package ViettelPostAPI.process;

import ViettelPostAPI.entity.client.ServiceExpressWrapper;
import ViettelPostAPI.service.VPService;

import java.util.List;

public class VPProcess extends Thread {
    // get data from VP Post after 5 minutes
    long lastVPSyncTime;
    VPService vpService;

    public VPProcess(String threadName, VPService vpService) {
        this.setName(threadName);
        this.lastVPSyncTime = System.currentTimeMillis();
        this.vpService = vpService;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.err.println("Process "+ this.getName()+" is running");
//                if(System.currentTimeMillis() - lastVPSyncTime > 300000){
                    // sync data from vp here
                    lastVPSyncTime = System.currentTimeMillis();
                    vpService.getListService();
                    System.out.println(System.currentTimeMillis() - lastVPSyncTime + " ms");
//                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
