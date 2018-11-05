package com.zd.river.modules.base.controller.common;

import com.zd.river.common.limit.RedisRaterLimiter;
import com.zd.river.common.utils.IpInfoUtil;
import com.zd.river.common.utils.QiniuUtil;
import com.zd.river.common.utils.ResultUtil;
import com.zd.river.common.vo.Result;
import com.zd.river.config.exception.RiverException;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;

/**
 * @author Exrickx
 */
@Slf4j
@RestController
@Api(description = "文件上传接口")
@RequestMapping("/river/upload")
@Transactional
public class UploadController {

    @Autowired
    private RedisRaterLimiter redisRaterLimiter;

    @Autowired
    private QiniuUtil qiniuUtil;

    @Autowired
    private IpInfoUtil ipInfoUtil;

    @RequestMapping(value = "/file",method = RequestMethod.POST)
    @ApiOperation(value = "文件上传")
    public Result<Object> upload(@RequestParam("file") MultipartFile file,
                                 HttpServletRequest request) {

        // IP限流 在线Demo所需 5分钟限1个请求
        String token = redisRaterLimiter.acquireTokenFromBucket("upload:"+ipInfoUtil.getIpAddr(request), 1, 300000);
        if (StrUtil.isBlank(token)) {
            throw new RiverException("上传那么多干嘛，等等再传吧");
        }

        String result = null;
        String fileName = qiniuUtil.renamePic(file.getOriginalFilename());
        try {
            FileInputStream inputStream = (FileInputStream) file.getInputStream();
            //上传七牛云服务器
            result = qiniuUtil.qiniuInputStreamUpload(inputStream,fileName);
        } catch (Exception e) {
            log.error(e.toString());
            return new ResultUtil<Object>().setErrorMsg(e.toString());
        }

        return new ResultUtil<Object>().setData(result);
    }
}
