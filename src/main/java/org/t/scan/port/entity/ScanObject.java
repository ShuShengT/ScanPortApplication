package org.t.scan.port.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 扫描信息实体
 */
public class ScanObject {
    private String ip;
    private int port;
    private String service;
    private Boolean isOpen;
    private String banner;
    // 存放服务指纹和服务的对应关系 banner -> service
    private static Map<String,String> bannerMaps = new HashMap<>();
    // 存放常见端口与服务的对应关系 port -> service
    private static Map<Integer,String> portMaps = new HashMap<>();

    static {
        bannerMaps.put("ssh","SSH");
        portMaps.put(22,"SSH");
        bannerMaps.put("ftp","FTP");
        portMaps.put(21,"FTP");
        portMaps.put(20,"FTP");
        bannerMaps.put("smtp","SMTP");
        portMaps.put(25,"SMTP");
        bannerMaps.put("mysql","MySQL");
        portMaps.put(3389,"MySQL");
    }

    public ScanObject(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getService() {
        return service;
    }

    public void setService() {
        // 先根据port判断服务类型
        if (portMaps.containsKey(this.port)){
            this.service = portMaps.get(this.port);
        }
        if (banner != null && !banner.equals("")){
            for (String key : bannerMaps.keySet()) {
                if (banner.toLowerCase().contains(key)) {
                    this.service = bannerMaps.get(key);
                    break;
                }
            }
        }
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;

    }

    @Override
    public String toString() {
        return "ScanObject{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", service='" + service + '\'' +
                ", isOpen=" + isOpen +
                ", banner='" + banner + '\'' +
                '}';
    }
}

