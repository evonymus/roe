package com.evonymus.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.evonymus.roe.service.RoeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/WEB-INF/main-servlet.xml"})
public class TestRoeService {
     

	private RoeServiceImpl roeService;

    @Ignore
    public void testRoeService() {
    	//MainConfig config = new MainConfig();
    	//RoeService roeService = config.getBean(RoeService.class);
        assertNotNull(roeService);
        List<String> codes = roeService.getCodeList();
        assertNotNull(codes);

    }


    
}
