package kr.or.ddit.case06.conf;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

@ComponentScan(basePackages = "kr.or.ddit.case06.objs.admin"
, lazyInit = true
, useDefaultFilters = false
, includeFilters = {@Filter(type = FilterType.ANNOTATION, classes = Controller.class)}
)
public class AdminConfig {

}
