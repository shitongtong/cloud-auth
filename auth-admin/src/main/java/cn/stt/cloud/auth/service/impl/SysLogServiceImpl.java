package cn.stt.cloud.auth.service.impl;


import cn.stt.cloud.auth.entity.SysLog;
import cn.stt.cloud.auth.mapper.SysLogMapper;
import cn.stt.cloud.auth.page.ColumnFilter;
import cn.stt.cloud.auth.page.MybatisPageHelper;
import cn.stt.cloud.auth.page.PageRequest;
import cn.stt.cloud.auth.page.PageResult;
import cn.stt.cloud.auth.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        ColumnFilter columnFilter = pageRequest.getColumnFilter("userName");
        if (columnFilter != null) {
            return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", columnFilter.getValue());
        }
        return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
    }

}
