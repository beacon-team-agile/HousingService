package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.domain.requests.FacilityReportDetailRequest;
import com.teamagile.housingservice.domain.response.AllFacilityReportDetailsResponse;
import com.teamagile.housingservice.domain.response.FacilityReportDetailResponse;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.exception.FacilityReportDetailNotFoundException;
import com.teamagile.housingservice.exception.FacilityReportNotFoundException;
import com.teamagile.housingservice.service.FacilityReportDetailService;
import com.teamagile.housingservice.service.FacilityReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("facility-report-detail")
public class FacilityReportDetailController {
    private FacilityReportService facilityReportService;
    private FacilityReportDetailService facilityReportDetailService;

    @Autowired
    public void FacilityReportService(FacilityReportService facilityReportService){
        this.facilityReportService = facilityReportService;
    }

    @Autowired
    public void FacilityReportDetailService(FacilityReportDetailService facilityReportDetailService){
        this.facilityReportDetailService = facilityReportDetailService;
    }

    @PostMapping("/add")
    public FacilityReportDetailResponse addFacilityReportDetail(@RequestBody FacilityReportDetailRequest request)
            throws FacilityReportNotFoundException {
        FacilityReportDetail facilityReportDetail = FacilityReportDetail.builder()
                .facilityReportId(facilityReportService.getFacilityReportById(request.getFacilityReportId()))
                .employeeId(request.getEmployeeId())
                .comment(request.getComment())
                .createDate(Calendar.getInstance().getTime())
                .lastModificationDate(Calendar.getInstance().getTime())
                .build();

        facilityReportDetailService.addFacilityReportDetail(facilityReportDetail);

        return FacilityReportDetailResponse.builder()
                .responseStatus(ResponseStatus.builder().success(true).message("Facility Report Detail Created!").build())
                .facilityReportDetail(facilityReportDetail)
                .build();
    }

    @GetMapping("/{facilityReportDetailId}")
    public FacilityReportDetailResponse getFacilityReportDetailById(@PathVariable Integer facilityReportDetailId) throws FacilityReportDetailNotFoundException {
        Optional<FacilityReportDetail> facilityReportDetailOptional = Optional
                .ofNullable(facilityReportDetailService.getFacilityReportDetailById(facilityReportDetailId));
        if (!facilityReportDetailOptional.isPresent()) {
            return FacilityReportDetailResponse.builder()
                    .responseStatus(ResponseStatus.builder()
                            .success(false)
                            .message("Facility Report Detail Not Found!")
                            .build())
                    .facilityReportDetail(null)
                    .build();
        }
        return FacilityReportDetailResponse.builder()
                .responseStatus(ResponseStatus.builder()
                        .success(true)
                        .message("Facility Report Detail Found Successfully!")
                        .build())
                .facilityReportDetail(facilityReportDetailOptional.get())
                .build();
    }

    @GetMapping("/all")
    public AllFacilityReportDetailsResponse getAllFacilityReportDetails() {
        List<FacilityReportDetail> facilityReportDetailList = facilityReportDetailService.getAllFacilityReportDetails();
        return AllFacilityReportDetailsResponse.builder()
                .responseStatus(
                        ResponseStatus.builder()
                                .success(true)
                                .message("Getting All Facility Report Details!")
                                .build()
                )
                .facilityReportDetailList(facilityReportDetailList)
                .build();
    }

    @PatchMapping("/{facilityReportDetailId}")
    public FacilityReportDetailResponse updateFacilityReportDetail(@PathVariable Integer facilityReportDetailId
            , @RequestBody FacilityReportDetail request) {
        FacilityReportDetail updated_facilityReportDetail = facilityReportDetailService
                .updateFacilityReportDetailInfo(facilityReportDetailId, request);

        return FacilityReportDetailResponse.builder()
                .responseStatus(
                        ResponseStatus.builder()
                                .success(true)
                                .message("Updated Facility Report Detail Successful")
                                .build()
                )
                .facilityReportDetail(updated_facilityReportDetail)
                .build();
    }
}
