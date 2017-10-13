package com.step.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.step.dto.Exposer;
import com.step.dto.SeckillExecution;
import com.step.entity.Seckill;
import com.step.exception.RepeatKillException;
import com.step.exception.SeckillCloseException;
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                      "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    
	//@Test
	public void testGetSeckillList() {
		List<Seckill> seckills=seckillService.getSeckillList();
        System.out.println(seckills);
	}

	//@Test
	public void testGetById() {
		long seckillId=1000;
        Seckill seckill=seckillService.getById(seckillId);
        System.out.println(seckill);
	}

	//@Test
	public void testExportSeckillUrl() {
		long seckillId=1000;
	    Exposer exposer=seckillService.exportSeckillUrl(seckillId);
	    System.out.println(exposer);
	}

	//@Test
	public void testExecuteSeckill() {
		long seckillId=1000;
	    long userPhone=13476191876L;
	    String md5="bf204e2683e7452aa7db1a50b5713bae";
	    SeckillExecution seckillExecution=seckillService.executeSeckill(seckillId,userPhone,md5);
	    System.out.println(seckillExecution);
	}
	//@Test//完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() throws Exception {
        long seckillId=1000;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed())
        {

            System.out.println(exposer);

            long userPhone=13476191876L;
            String md5=exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
            }catch (RepeatKillException e)
            {
                e.printStackTrace();
            }catch (SeckillCloseException e1)
            {
                e1.printStackTrace();
            }
        }else {
            //秒杀未开启
            System.out.println(exposer);
        }
	}
    @Test
    public void testExecuteSeckillProcedure() {
    	long seckillId = 1000;
        long phone = 18795990000L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
            logger.info("execution={}", execution);
        }
    }
}
