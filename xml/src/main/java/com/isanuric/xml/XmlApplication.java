package com.isanuric.xml;

import com.isanuric.xml.country.Continent;
import com.isanuric.xml.country.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getApplicationName());
        System.out.println(context.getDisplayName());
        System.out.println("StartupDate: " + context.getStartupDate());
        System.out.println("BeanDefinitionCount: " +context.getBeanDefinitionCount());
        System.out.println("ClassLoader: " + context.getClassLoader().getName());

        final Country country = (Country) context.getBean("country");
        System.out.println("*** country bean ***");
        System.out.println(country.getName());
        System.out.println(country.getCitizens());

        final Country countryGermany = (Country) context.getBean("countryGermany");
        System.out.println("*** countryGermany bean ***");
        System.out.println(countryGermany.getName());

        final Continent continent = (Continent) context.getBean("continent");
        System.out.println("*** continent bean ***");
        System.out.println(continent.getName());
        System.out.println(continent.getCountry());
        System.out.println(continent.getCountry().getName());
        System.out.println(continent.getCountry().getCapital());
    }
}
