package com.teamagile.housingservice.controller;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.domain.requests.FacilityReportRequest;
import com.teamagile.housingservice.domain.response.AllFacilityReportsResponse;
import com.teamagile.housingservice.domain.response.FacilityReportResponse;
import com.teamagile.housingservice.entity.FacilityReport;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import com.teamagile.housingservice.exception.FacilityNotFoundException;
import com.teamagile.housingservice.exception.FacilityReportNotFoundException;
import com.teamagile.housingservice.service.FacilityReportDetailService;
import com.teamagile.housingservice.service.FacilityReportService;
import com.teamagile.housingservice.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("facility-report")
public class FacilityReportController {
    private FacilityService facilityService;
    private FacilityReportService facilityReportService;
    private FacilityReportDetailService facilityReportDetailService;

    @Autowired
    public void FacilityService(FacilityService facilityService){
        this.facilityService = facilityService;
    }

    @Autowired
    public void FacilityReportService(FacilityReportService facilityReportService){
        this.facilityReportService = facilityReportService;
    }

    @Autowired
    public void FacilityReportDetailService(FacilityReportDetailService facilityReportDetailService){
        this.facilityReportDetailService = facilityReportDetailService;
    }

    @PostMapping("/add_report")
    public FacilityReportResponse addFacilityReport(@RequestBody FacilityReportRequest request) throws FacilityNotFoundException {

        FacilityReport facilityReport = FacilityReport.builder()
                .facilityId(facilityService.getFacilityById(request.getFacilityId()))
                .employeeId(request.getEmployeeId())
                .title(request.getTitle())
                .description(request.getDescription())
                .createDate(Calendar.getInstance().getTime())
                .status(request.getStatus())
                .build();

        facilityReportService.addFacilityReport(facilityReport);

        return FacilityReportResponse.builder()
                .responseStatus(ResponseStatus.builder().success(true).message("Facility Report Created!").build())
                .facilityReport(facilityReport)
                .build();
    }

    @GetMapping("/{facilityReportId}")
    public FacilityReportResponse getFacilityReportById(@PathVariable Integer facilityReportId) throws FacilityReportNotFoundException{
        Optional<FacilityReport> facilityReportOptional = Optional.ofNullable(facilityReportService.getFacilityReportById(facilityReportId));
        if (!facilityReportOptional.isPresent()) {
            return FacilityReportResponse.builder()
                    .responseStatus(ResponseStatus.builder()
                            .success(false)
                            .message("Facility Report Not Found!")
                            .build())
                    .facilityReport(null)
                    .build();
        }
        return FacilityReportResponse.builder()
                .responseStatus(ResponseStatus.builder()
                        .success(true)
                        .message("Facility Report Found Successfully!")
                        .build())
                .facilityReport(facilityReportOptional.get())
                .build();
    }

    @GetMapping("/all")
    public AllFacilityReportsResponse getAllFacilityReports() {
        List<FacilityReport> facilityReportList = facilityReportService.getAllFacilityReports();
        return AllFacilityReportsResponse.builder()
                .responseStatus(
                        ResponseStatus.builder()
                                .success(true)
                                .message("Getting All Facility Reports!")
                                .build()
                )
                .facilityReportList(facilityReportList)
                .build();
    }

    @GetMapping("/facility/{facilityId}")
    public AllFacilityReportsResponse getFacilityReportsByFacilityId(@PathVariable Integer facilityId) {
        List<FacilityReport> facilityReportList = facilityReportService.getFacilityReportsByFacilityId(facilityId);
        return AllFacilityReportsResponse.builder()
                .responseStatus(
                        ResponseStatus.builder()
                                .success(true)
                                .message("Getting Facility Reports From Facility!")
                                .build()
                )
                .facilityReportList(facilityReportList)
                .build();
    }
}
