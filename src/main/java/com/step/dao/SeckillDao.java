package com.step.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.step.entity.Seckill;

public interface SeckillDao {
	/*
	 * 如果返回值大于1，则为更新库存的记录行数
	 * 减少库存
	 */
	int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);
	/*
	 * 根据id查找商品
	 */
	Seckill queryById(@Param("seckillId")long seckillId);
	/*
	 * 根据偏移量查询秒杀商品
	 */
	List<Seckill> queryAll(@Param("offset")int offset,@Param("limit")int limit);
	/**
	 *  使用储存过程执行秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String,Object> paramMap);
}
