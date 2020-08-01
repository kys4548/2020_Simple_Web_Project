package com.youngsil.licensingservice.controller;

import com.youngsil.licensingservice.model.License;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/license")
public class LicenseServiceController {

    @GetMapping("/{licenseId}")
    public License getLicenses(@PathVariable String organizationId,
                               @PathVariable String licenseId) {
        return License.builder()
                .id(licenseId)
                .organizationId(organizationId)
                .productName("Teleco")
                .licenseType("Seat")
                .build();
    }
}
