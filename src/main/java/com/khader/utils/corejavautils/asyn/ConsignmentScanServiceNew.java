package com.khader.utils.corejavautils.asyn;//package com.ajex.aone.ops.service;
//
//import com.ajex.aone.ops.controller.request.ConsignmentScanRequest;
//import com.ajex.aone.ops.entity.Consignment;
//import com.ajex.aone.ops.utils.SecurityUtils;
//import com.ajex.core.web.exceptions.ResourceExistsException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//
//public class ConsignmentScanServiceNew {
//
//    private ConsignmentService consignmentService;
//    private  EmployeesService employeesService;
//    private final Map<Integer, ConsignmentScanHandler> handlers;
//
//
//
//    public ConsignmentScanServiceNew(List<ConsignmentScanHandler> handlerList){
//        this.handlers = new HashMap<>();
//
//        // Populate the map with event codes and their corresponding handlers
//        handlerList.forEach(handler -> {
//            handler.getHandlerEventCode().forEach(eventCode -> handlers.put(eventCode, handler));
//        });
//    }
//
//    public void applyScan(Integer eventCode, ConsignmentScanRequest consignmentScanRequest) {
//        verifyEmployeeAccess(consignmentScanRequest.getEmployeeCode(), consignmentScanRequest.getHubCode());
//
//        consignmentScanRequest.setClientId(SecurityUtils.getClientId());
//        consignmentScanRequest.setEventCode(eventCode);
//
//        consignmentService.getByTrackingId(consignmentScanRequest.getTrackingId())
//                .ifPresent(consignment ->
//                        handleEventCode(consignmentScanRequest,consignment));
//    }
//
//
//
//    private void verifyEmployeeAccess(String employeeCode, String hubCode) {
//        if (!employeesService.verifyEmpHub(employeeCode, hubCode)) {
//            throw new ResourceExistsException("No access to Employee");
//        }
//    }
//
//
//    public void handleEventCode(ConsignmentScanRequest request,Consignment consignment) {
//        int eventCode = request.getEventCode();
//        ConsignmentScanHandler handler = handlers.get(eventCode);
//
//        if (handler != null) {
//            handler.invokeAnotherHandler(request,consignment);
//            handler.handleScan(request,consignment);
//        } else {
//            // Handle unknown event codes or log a warning
//            System.out.println("No handler found for event code: " + eventCode);
//        }
//    }
//
//
//}