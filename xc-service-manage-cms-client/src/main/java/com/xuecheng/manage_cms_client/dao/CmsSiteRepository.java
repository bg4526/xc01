package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Title: xcEduService01
 * @Description:
 * @Author: xiaobai
 * @Date: 2019/10/25 23:03
 * @Version: 1.0
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {

}
