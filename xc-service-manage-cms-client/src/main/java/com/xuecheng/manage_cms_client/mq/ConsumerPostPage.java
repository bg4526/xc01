package com.xuecheng.manage_cms_client.mq;

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms_client.dao.CmsPageRepository;
import com.xuecheng.manage_cms_client.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

/**
 * @Title: xcEduService01
 * @Description: 消费者
 * @Author: xiaobai
 * @Date: 2019/10/27 22:31
 * @Version: 1.0
 */
@Slf4j
@Component
public class ConsumerPostPage {
    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Autowired
    private PageService pageService;

    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void postPage(String msg) {
        Map map = JSON.parseObject(msg, Map.class);
        log.info("receive cms post page:{}", msg.toString());
        //查询页面id
        String pageId = (String) map.get("pageId");
        //查询页面信息
        Optional<CmsPage> id = cmsPageRepository.findById(pageId);
        if (!id.isPresent()) {
            log.info("reveive cms post page,cmsPage is null:{}", id);
            return;
        }
        //将页面保存到服务器物理路径
        pageService.savePageToServerPath(pageId);
    }

}
