package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GirlException;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertGirl(){//事务控制
        Girl girl = new Girl();
        girl.setAge(25);
        girl.setCupSize("B");
        girlRepository.save(girl);

        Girl girl2 = new Girl();
        girl2.setAge(26);
        girl2.setCupSize("BBBBBBBBBB");
        girlRepository.save(girl2);
    }

    /**
     * 自定义异常测试
     */
    public void tsetException() throws Exception{
        throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
    }
    /**
     * 系统异常
     */
    public void tsetSysException(Object object) {
        object.toString();
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
