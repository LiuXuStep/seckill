package com.step.dao;

import org.apache.ibatis.annotations.Param;

import com.step.entity.SuccessKilled;

public interface SuccessKilledDao {
	/*
	 * 插入购买明细，可过滤重复
	 */
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	/*
	 * 根据id查找SuccessKilled对象,其中包含了被秒杀商品对象
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	
}
