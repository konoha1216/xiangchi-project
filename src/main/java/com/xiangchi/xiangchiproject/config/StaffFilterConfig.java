package com.xiangchi.xiangchiproject.config;

import com.xiangchi.xiangchiproject.filter.StaffFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StaffFilterConfig {

    @Bean
    public StaffFilter staffFilter() {
        return new StaffFilter();
    }

    @Bean(name = "staffFilterConf")
    public FilterRegistrationBean staffFilterConf() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(staffFilter());
        filterRegistrationBean.addUrlPatterns("/api/staff/update");
        filterRegistrationBean.setName("staffFilterConf");
        return filterRegistrationBean;
    }
}
