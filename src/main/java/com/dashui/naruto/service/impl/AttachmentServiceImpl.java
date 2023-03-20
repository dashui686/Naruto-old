package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.Attachment;
import com.dashui.naruto.service.AttachmentService;
import com.dashui.naruto.mapper.AttachmentMapper;
import org.springframework.stereotype.Service;

/**
* @author 13276
* @description 针对表【attachment(附件表)】的数据库操作Service实现
* @createDate 2023-03-20 16:18:28
*/
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment>
    implements AttachmentService{

}




