package com.step.service;

import java.util.List;

import com.step.dto.Exposer;
import com.step.dto.SeckillExecution;
import com.step.entity.Seckill;
import com.step.exception.RepeatKillException;
import com.step.exception.SeckillCloseException;
import com.step.exception.SeckillException;

public interface SeckillService {
	/**
     * 查询全部的秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     *查询单个秒杀记录
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀操作，有可能失败，有可能成功，所以要抛出我们允许的异常
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;
    /**
     * 调用存储过程来执行秒杀操作，不需要抛出异常
     * 
     * @param seckillId 秒杀的商品ID
     * @param userPhone 手机号码
     * @param md5 md5加密值
     * @return 根据不同的结果返回不同的实体信息
     */
    SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);
}
