package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Title: xcEduService01
 * @Description:
 * @Author: xiaobai
 * @Date: 2019/10/25 23:02
 * @Version: 1.0
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {

}
