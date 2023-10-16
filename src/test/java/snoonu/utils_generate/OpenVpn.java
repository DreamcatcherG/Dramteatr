//package snoonu.utils_generate;
//
//import com.github.openvpn_runner.OpenvpnRunner;
//import com.github.openvpn_runner.OpenvpnState;
//import com.github.openvpn_runner.VpnConfig;
//
//public class OpenVpn {
//    private OpenvpnRunner openvpnRunner;
//
//    public void connect() {
//        String configPath = getClass().getClassLoader().getResource("config.ovpn").getPath();
//        VpnConfig vpnConfig = new VpnConfig.Builder()
//                .withConfigPath(configPath)
//                .build();
//
//        openvpnRunner = new OpenvpnRunner();
//        openvpnRunner.setVpnConfig(vpnConfig);
//        openvpnRunner.start();
//
//        // Ждем, пока подключение установится
//        while (openvpnRunner.getState() != OpenvpnState.CONNECTED) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void disconnect() {
//        if (openvpnRunner != null) {
//            openvpnRunner.stop();
//        }
//    }
//}
