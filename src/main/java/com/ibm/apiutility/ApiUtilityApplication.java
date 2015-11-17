package com.ibm.apiutility;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.codahale.metrics.JmxReporter;
import com.codahale.metrics.MetricRegistry;
import com.ibm.apiutility.resource.APIUtilityResource;
import com.ibm.apiutility.util.ConfigurationStrings;

public class ApiUtilityApplication extends Application<ConfigurationStrings> {
	public static final Logger log = LoggerFactory.getLogger(ApiUtilityApplication.class);
    public static void main(String[] args) throws Exception {
        new ApiUtilityApplication().run(args);
    }

    @Override
	public String getName() {
		return "A Greek Offering";
	}
    
    @Override
	public void initialize(Bootstrap<ConfigurationStrings> bootstrap) {
		final MetricRegistry mr = bootstrap.getMetricRegistry();
		final JmxReporter reporter = JmxReporter.forRegistry(mr).build();
		reporter.start();
	}
    
    @Override
    public void run(ConfigurationStrings conf, Environment env) throws Exception {
    	log.info("Opening the Greek Offering");
    	env.jersey().register(new APIUtilityResource());
    	final FilterRegistration.Dynamic cors = env.servlets().addFilter(
				"crossOriginRequsts", CrossOriginFilter.class);
		cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin,Authorization");
		cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),
				true, "/*");
    }

}