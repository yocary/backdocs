/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.documentitos.validator;

import com.documentitos.commons.CommonValidatorSvc;
import com.documentitos.models.bitacora;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author yocary
 */
@Component("bitacoraValidator")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class bitacoraValidator implements CommonValidatorSvc<bitacora>{
    
    
    @Override
    public bitacora validate(bitacora e){
        return e;
    }
}
