package com.khader.utils.corejavautils.asyn.service;

import com.khader.utils.corejavautils.asyn.dto.WaybillUpdateResult;

public interface WaybillService {
    WaybillUpdateResult updateWaybillStatus(String waybillNumber);
}
