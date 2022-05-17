package edu.estu.ovs.core.config;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class ControllerConfig {

    @InitBinder // trim all strings that is @RequestParam
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
