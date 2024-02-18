package com.khader.utils.corejavautils.asyn;

import com.khader.utils.corejavautils.asyn.dto.WaybillUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class UpdateWaybillStatusController {

    @Autowired
    private UpdateWaybillStatusService myService;

    @PostMapping("/update-waybills")
    public WaybillUpdateResponse updateWaybills(@RequestBody List<String> waybillNumbers) throws ExecutionException, InterruptedException {
        CompletableFuture<WaybillUpdateResponse> result = myService.updateWaybills(waybillNumbers);
        return result.get(); // This blocks until all waybills are updated
    }
}