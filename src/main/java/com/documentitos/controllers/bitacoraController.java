/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.controllers;

import com.documentitos.commons.CommonController;
import com.documentitos.models.bitacora;
import com.documentitos.services.bitacoraSvc;
import com.documentitos.validator.bitacoraValidator;
import io.swagger.annotations.Api;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yocary
 */
@Api
@RestController
@RequestMapping("external/bitacora")
@EnableEurekaClient
public class bitacoraController extends CommonController<bitacora, bitacoraSvc, bitacoraValidator> {
    
}
