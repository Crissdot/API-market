package com.course.market.web.controller;

import com.course.market.domain.PurchaseDomain;
import com.course.market.domain.service.PurchaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    @ApiOperation("Get all purchases")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<PurchaseDomain>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    @ApiOperation("Search a purchase with client ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<List<PurchaseDomain>> getByClient(
            @ApiParam(value = "The id of the client", required = true, example = "1") @PathVariable("idClient") String clientId
    ) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Create a new purchase")
    @ApiResponse(code = 201, message = "Created")
    public ResponseEntity<PurchaseDomain> create(
            @ApiParam(value = "The content of the purchase", required = true) @RequestBody PurchaseDomain purchase
    ) {
        return new ResponseEntity<>(purchaseService.create(purchase), HttpStatus.CREATED);
    }
}
