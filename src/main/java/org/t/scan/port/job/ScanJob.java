package org.t.scan.port.job;

import org.t.scan.port.entity.ScanObject;
import org.t.scan.port.engine.ScanEngine;

/**
 * 扫描任务类，执行具体的扫描任务
 */
public class ScanJob implements Runnable{
    // 扫描信息
    private ScanObject object;
    // 扫描类型
    private String scanType;

    public ScanJob(ScanObject object,String scanType) {
        this.object = object;
        this.scanType = scanType;

    }

    @Override
    public void run() {
        ScanEngine.scan(object, scanType);
    }
}

